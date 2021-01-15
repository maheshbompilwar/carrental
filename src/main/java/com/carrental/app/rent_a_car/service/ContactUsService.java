package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.ContactUsEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;

import java.util.List;

public interface ContactUsService {
    ResponseMessage createContactUs(ContactUsEntity contactUsEntity);

    List<ContactUsEntity> getContactUs();

    ContactUsEntity getContactUs(long id);

    ResponseMessage updateContactUs(ContactUsEntity contactUsntity);

    ResponseMessage deleteContactUs(long id);
}
