package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.AdminEntity;
import com.carrental.app.rent_a_car.entity.SubscriberEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;

import java.util.List;

public interface SubscriberService {
    ResponseMessage createSubscriber(SubscriberEntity subscriberEntity);

    List<SubscriberEntity> getSubscribers();

    SubscriberEntity getSubscriber(long id);

    ResponseMessage updateSubscriber(SubscriberEntity adminEntity);

    ResponseMessage deleteSubscriber(long id);
}
