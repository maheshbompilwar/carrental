package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.TestimonialEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;

import java.util.List;

public interface TestimonialService {
    ResponseMessage createTestimonial(TestimonialEntity testimonialEntity);

    List<TestimonialEntity> getTestimonials();

    TestimonialEntity getTestimonial(long id);

    ResponseMessage updateTestimonial(TestimonialEntity testimonialEntity);

    ResponseMessage deleteTestimonial(long id);
}
