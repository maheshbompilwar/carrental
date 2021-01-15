package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.ContactUsQueryEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.ContactUsQueryRepository;
import com.carrental.app.rent_a_car.service.ContactUsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsQueryServiceImpl implements ContactUsQueryService {

    @Autowired
    ContactUsQueryRepository contactUsQueryRepository;

    @Override
    public ResponseMessage createContactUsQuery(ContactUsQueryEntity contactUsQueryEntity) {
        contactUsQueryRepository.save(contactUsQueryEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public List<ContactUsQueryEntity> getContactUsQueries() {
       return contactUsQueryRepository.findAll();
    }

    @Override
    public ContactUsQueryEntity getContactUsQuery(long id) {
      return contactUsQueryRepository.findContactUsQueryEntityById(id);
    }

    @Override
    public ResponseMessage updateContactUsQuery(ContactUsQueryEntity contactUsQueryEntity) {
        if (contactUsQueryRepository.findContactUsQueryEntityById(contactUsQueryEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");
       contactUsQueryRepository.save(contactUsQueryEntity);
        return new ResponseMessage("Record Updated Successfully...", true);
    }

    @Override
    public ResponseMessage deleteContactUsQuery(long id) {
        if (contactUsQueryRepository.findContactUsQueryEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        contactUsQueryRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }
}
