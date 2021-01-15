package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.SubscriberEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.SubscriberRepository;
import com.carrental.app.rent_a_car.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    SubscriberRepository subscriberRepository;

    @Override
    public ResponseMessage createSubscriber(SubscriberEntity subscriberEntity) {
        subscriberRepository.save(subscriberEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public List<SubscriberEntity> getSubscribers() {
       return subscriberRepository.findAll();
    }

    @Override
    public SubscriberEntity getSubscriber(long id) {
      return subscriberRepository.findSubscriberEntityById(id);
    }

    @Override
    public ResponseMessage updateSubscriber(SubscriberEntity subscriberEntity) {
        if (subscriberRepository.findSubscriberEntityById(subscriberEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");
       subscriberRepository.save(subscriberEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public ResponseMessage deleteSubscriber(long id) {
        if (subscriberRepository.findSubscriberEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        subscriberRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }
}
