package com.example.springhumo.mapper;

import com.example.springhumo.model.dto.humo.response.CardHistoryResponseDto;
import com.example.springhumo.model.dto.humo.response.ErrorDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;

public class CommonMapper {
    private static Logger logger = LogManager.getLogger(CommonMapper.class);

    public CommonMapper() {
    }

    public static List<CardHistoryResponseDto> xmlToHistoryResponseDto(String xml) throws IOException {
        JSONObject jObject = XML.toJSONObject(xml);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(jObject.toString(), Object.class);
        String output = mapper.writeValueAsString(json);
        Map env = (Map)mapper.readValue(output, Map.class);
        Map bod = (Map)env.get("Body");
        List<Map> multiref = (List)bod.get("multiRef");
        Optional<Map> rowMap = multiref.stream().filter((map) -> {
            return map.get("row") != null;
        }).findFirst();
        List<Map> rows = new ArrayList();
        if (rowMap.isPresent()) {
            Boolean isList = Boolean.TRUE;

            try {
                rows = (List)((Map)rowMap.get()).get("row");
            } catch (Exception var15) {
                isList = Boolean.FALSE;
            }

            if (!isList) {
                Map row = (Map)((Map)rowMap.get()).get("row");
                ((List)rows).add(row);
            }
        }

        List<Map> transactionContainers = new ArrayList();
        if (rows != null && !((List)rows).isEmpty()) {
            Iterator var17 = ((List)rows).iterator();

            while(var17.hasNext()) {
                Map row = (Map)var17.next();
                String href = row.get("href").toString().replaceAll("#", "");
                Optional<Map> container = multiref.stream().filter((map) -> {
                    return map.get("id") != null && map.get("id").toString().equalsIgnoreCase(href);
                }).findFirst();
                if (container.isPresent()) {
                    transactionContainers.add(container.get());
                }
            }
        }

        List<CardHistoryResponseDto> historyResponseEnvelopDtos = new ArrayList();
        if (!transactionContainers.isEmpty()) {
            Iterator var19 = transactionContainers.iterator();

            while(var19.hasNext()) {
                Map transactionContainer = (Map)var19.next();
                List<Map> items = (List)transactionContainer.get("item");
                historyResponseEnvelopDtos.add(new CardHistoryResponseDto(items, multiref));
            }
        }

        return historyResponseEnvelopDtos;
    }

    public static Optional<ErrorDto> xmlErrorStringToErrorDto(String rawXml, String parseObjStart, String parseObjEnd) {
        if (rawXml != null && !rawXml.isEmpty()) {
            Integer startIndex = rawXml.lastIndexOf(parseObjStart);
            Integer endIndex = rawXml.indexOf(parseObjEnd);
            rawXml = rawXml.substring(startIndex + 32, endIndex);
            rawXml = "<envelop>" + rawXml + "</envelop>";
            XmlMapper mapper = new XmlMapper();

            try {
                ErrorDto errorDto = (ErrorDto)mapper.readValue(rawXml, ErrorDto.class);
                return Optional.of(errorDto);
            } catch (JsonParseException var7) {
                logger.error(var7.getMessage());
            } catch (JsonMappingException var8) {
                logger.error(var8.getMessage());
            } catch (IOException var9) {
                logger.error(var9.getMessage());
            }

            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }
}
