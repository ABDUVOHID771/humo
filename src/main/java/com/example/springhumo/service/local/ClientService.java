package com.example.springhumo.service.local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.example.springhumo.model.dto.humo.response.ListCustomer;
import com.example.springhumo.model.entity.Card;
import com.example.springhumo.model.entity.HumoClient;
import com.example.springhumo.repository.HumoClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private HumoClientRepository humoClientRepository;
    @Autowired
    @Qualifier("cardService")
    private CardService cardService;

    public ClientService() {
    }

    public Card save(ListCustomer listCustomer, Card card) {
        String clientId = listCustomer.getClient();
        String clientB = listCustomer.getClientB();
        String docsId = listCustomer.getIdCard();
        String serialNo = listCustomer.getSerialNo();
        String docName = listCustomer.getDocName();
        String mobPhone = listCustomer.getMobilePhone();
        String firstName = listCustomer.getFNames();
        String surname = listCustomer.getSurname();
        String birthDateStr = listCustomer.getBDate() == null ? "" : listCustomer.getBDate().replaceAll("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate bDate = birthDateStr.isEmpty() ? null : LocalDate.parse(birthDateStr, formatter);
        Optional<HumoClient> clientDb = this.humoClientRepository.findByClientId(clientId);
        Long id = null;
        if (clientDb.isPresent()) {
            id = ((HumoClient)clientDb.get()).getId();
        }

        HumoClient client = HumoClient.builder().id(id).clientId(clientId).clientB(clientB).docsId(docsId).serialNo(serialNo).docName(docName).mobPhone(mobPhone).firstName(firstName).surname(surname).birthDate(bDate).build();
        HumoClient savedClient = (HumoClient)this.humoClientRepository.save(client);
        card.setHumoClient(savedClient);
        return this.cardService.saveCard(card);
    }
}
