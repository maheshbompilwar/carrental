package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.ContactUsEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.ContactUsRepository;
import com.carrental.app.rent_a_car.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    ContactUsRepository contactUsRepository;

    @Override
    public ResponseMessage createContactUs(ContactUsEntity contactUsEntity) {
        contactUsRepository.save(contactUsEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public List<ContactUsEntity> getContactUs() {
       return contactUsRepository.findAll();
    }

    @Override
    public ContactUsEntity getContactUs(long id) {
      return contactUsRepository.findContactUsEntityById(id);
    }

    @Override
    public ResponseMessage updateContactUs(ContactUsEntity contactUsEntity) {
        if (contactUsRepository.findContactUsEntityById(contactUsEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");
       contactUsRepository.save(contactUsEntity);
        return new ResponseMessage("Record Updated Successfully...", true);
    }

    @Override
    public ResponseMessage deleteContactUs(long id) {
        if (contactUsRepository.findContactUsEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        contactUsRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }
}
