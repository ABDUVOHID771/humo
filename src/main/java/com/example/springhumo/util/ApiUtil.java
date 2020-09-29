package com.example.springhumo.util;

import com.example.springhumo.constant.HumoAction;
import com.example.springhumo.model.dto.humo.response.ErrorResponseObj;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;

public class ApiUtil {
    public ApiUtil() {
    }

    public static Boolean canSendNotification(String errorBody, HumoAction action) {
        Boolean sendNotification = Boolean.TRUE;
        if (action == HumoAction.EXPORT && !errorBody.isEmpty()) {
            try {
                Integer startIndex = errorBody.lastIndexOf("<ag:AccessGatewayException>");
                Integer endIndex = errorBody.indexOf("</ag:AccessGatewayException>");
                errorBody = errorBody.substring(startIndex + 27, endIndex);
                errorBody = "<envelop>" + errorBody + "</envelop>";
                XmlMapper mapper = new XmlMapper();
                new ErrorResponseObj();

                try {
                    ErrorResponseObj responseObj = (ErrorResponseObj)mapper.readValue(errorBody, ErrorResponseObj.class);
                    if (responseObj.getCode().equalsIgnoreCase("-1")) {
                        sendNotification = Boolean.FALSE;
                    }
                } catch (IOException var8) {
                    sendNotification = Boolean.TRUE;
                }
            } catch (Exception var9) {
                sendNotification = Boolean.TRUE;
            }
        }

        return sendNotification;
    }
}
