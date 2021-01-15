package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.entity.ContactUsEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactUs/")
public class ContactUsController {

    @Autowired
    ContactUsService contactUsService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to ContactUs ...";
    }

    @PostMapping(value = "createContactUs")
    public ResponseMessage createContactUs(@RequestBody ContactUsEntity contactUsEntity) {
        return contactUsService.createContactUs(contactUsEntity);
    }

    @GetMapping(value = "getContactUs")
    public List<ContactUsEntity> getContactUs() {
        return contactUsService.getContactUs();
    }

    @GetMapping(value = "getContactUs/{id}")
    public ContactUsEntity getContactUs(@PathVariable long id) {
        return contactUsService.getContactUs(id);
    }

    @PostMapping(value = "updateContactUs")
    public ResponseMessage updateContactUs(@RequestBody ContactUsEntity contactUsEntity) {
        return contactUsService.updateContactUs(contactUsEntity);
    }

    @GetMapping(value = "deleteContactUs/{id}")
    public ResponseMessage deleteContactUs(@PathVariable long id) {
        return contactUsService.deleteContactUs(id);
    }
}
