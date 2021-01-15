package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.entity.ContactUsQueryEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.ContactUsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactUsQuery/")
public class ContactUsQueryController {

    @Autowired
    ContactUsQueryService contactUsQueryService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to admin ...";
    }

    @PostMapping(value = "createContactUsQuery")
    public ResponseMessage createContactUsQuery(@RequestBody ContactUsQueryEntity contactUsQueryEntity) {
        return contactUsQueryService.createContactUsQuery(contactUsQueryEntity);
    }

    @GetMapping(value = "getContactUsQueries")
    public List<ContactUsQueryEntity> getContactUsQueries() {
        return contactUsQueryService.getContactUsQueries();
    }

    @GetMapping(value = "getContactUsQuery/{id}")
    public ContactUsQueryEntity getContactUsQuery(@PathVariable long id) {
        return contactUsQueryService.getContactUsQuery(id);
    }

    @PostMapping(value = "updateContactUsQuery")
    public ResponseMessage updateContactUsQuery(@RequestBody ContactUsQueryEntity contactUsQueryEntity) {
        return contactUsQueryService.updateContactUsQuery(contactUsQueryEntity);
    }

    @GetMapping(value = "deleteContactUsQuery/{id}")
    public ResponseMessage deleteContactUsQuery(@PathVariable long id) {
        return contactUsQueryService.deleteContactUsQuery(id);
    }
}
