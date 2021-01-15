package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.entity.SubscriberEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriber/")
public class SubscriberController {

    @Autowired
    SubscriberService subscriberService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to admin ...";
    }

    @PostMapping(value = "createSubscriber")
    public ResponseMessage createSubscriber(@RequestBody SubscriberEntity subscriberEntity) {
        return subscriberService.createSubscriber(subscriberEntity);
    }

    @GetMapping(value = "getSubscribers")
    public List<SubscriberEntity> getSubscribers() {
        return subscriberService.getSubscribers();
    }

    @GetMapping(value = "getSubscriber/{id}")
    public SubscriberEntity getSubscriber(@PathVariable long id) {
        return subscriberService.getSubscriber(id);
    }

    @PostMapping(value = "updateSubscriber")
    public ResponseMessage updateSubscriber(@RequestBody SubscriberEntity subscriberEntity) {
        return subscriberService.updateSubscriber(subscriberEntity);
    }

    @GetMapping(value = "deleteSubscriber/{id}")
    public ResponseMessage deleteSubscriber(@PathVariable long id) {
        return subscriberService.deleteSubscriber(id);
    }
}
