package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.TestimonialEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.TestimonialRepository;
import com.carrental.app.rent_a_car.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    TestimonialRepository testimonialRepository;

    @Override
    public ResponseMessage createTestimonial(TestimonialEntity testimonialEntity) {
        testimonialRepository.save(testimonialEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public List<TestimonialEntity> getTestimonials() {
       return testimonialRepository.findAll();
    }

    @Override
    public TestimonialEntity getTestimonial(long id) {
      return testimonialRepository.findTestimonialEntityById(id);
    }

    @Override
    public ResponseMessage updateTestimonial(TestimonialEntity testimonialEntity) {
        if (testimonialRepository.findTestimonialEntityById(testimonialEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");
       testimonialRepository.save(testimonialEntity);
        return new ResponseMessage("Record Updated Successfully...", true);
    }

    @Override
    public ResponseMessage deleteTestimonial(long id) {
        if (testimonialRepository.findTestimonialEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        testimonialRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }
}
