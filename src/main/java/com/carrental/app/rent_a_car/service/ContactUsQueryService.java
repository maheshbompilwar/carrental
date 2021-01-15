package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.ContactUsQueryEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;

import java.util.List;

public interface ContactUsQueryService {
    ResponseMessage createContactUsQuery(ContactUsQueryEntity contactUsQueryEntity);

    List<ContactUsQueryEntity> getContactUsQueries();

    ContactUsQueryEntity getContactUsQuery(long id);

    ResponseMessage updateContactUsQuery(ContactUsQueryEntity contactUsQueryEntity);

    ResponseMessage deleteContactUsQuery(long id);
}
