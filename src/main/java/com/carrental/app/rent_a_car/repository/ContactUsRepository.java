package com.carrental.app.rent_a_car.repository;

import com.carrental.app.rent_a_car.entity.ContactUsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUsEntity, Long> {
    ContactUsEntity findContactUsEntityById(long id);
}
