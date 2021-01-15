package com.carrental.app.rent_a_car.repository;

import com.carrental.app.rent_a_car.entity.TestimonialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepository extends JpaRepository<TestimonialEntity, Long> {
    TestimonialEntity findTestimonialEntityById(long id);
}
