package com.example.market.service;

import com.example.market.model.Contact;
import com.example.market.model.enums.EInquiryStatus;
import com.example.market.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact) {

        contact.setStatus(EInquiryStatus.OPEN.toString());
        Contact queryResults = contactRepository.save(contact);


        return (queryResults != null && queryResults.getInquiryId() > 0);
    }

    public List<Contact> findInquiriesByStatus() {

        List<Contact> inquiriesList = contactRepository.findByStatus(EInquiryStatus.OPEN.toString());
        return inquiriesList;
    }

    public boolean updateInquiryStatus(int inquiryId) {

        //notice Optional object
        Optional<Contact> contact = contactRepository.findById(inquiryId);

        contact.ifPresent(contactObj -> {
            contactObj.setStatus(EInquiryStatus.CLOSED.toString());
        });

        Contact queryResults = contactRepository.save(contact.get());

        return (queryResults != null && queryResults.getUpdatedBy() != null);
    }

}
