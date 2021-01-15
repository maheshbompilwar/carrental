package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.entity.TestimonialEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testimonial/")
public class TestimonialController {

    @Autowired
    TestimonialService testimonialService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to admin ...";
    }

    @PostMapping(value = "createTestimonial")
    public ResponseMessage createTestimonial(@RequestBody TestimonialEntity testimonialEntity) {
        return testimonialService.createTestimonial(testimonialEntity);
    }

    @GetMapping(value = "getTestimonials")
    public List<TestimonialEntity> getTestimonials() {
        return testimonialService.getTestimonials();
    }

    @GetMapping(value = "getTestimonial/{id}")
    public TestimonialEntity getTestimonial(@PathVariable long id) {
        return testimonialService.getTestimonial(id);
    }

    @PostMapping(value = "updateTestimonial")
    public ResponseMessage updateTestimonial(@RequestBody TestimonialEntity adminEntity) {
        return testimonialService.updateTestimonial(adminEntity);
    }

    @GetMapping(value = "deleteTestimonial/{id}")
    public ResponseMessage deleteTestimonial(@PathVariable long id) {
        return testimonialService.deleteTestimonial(id);
    }
}
