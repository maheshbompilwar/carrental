package com.carrental.app.rent_a_car.repository;

import com.carrental.app.rent_a_car.entity.ContactUsQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsQueryRepository extends JpaRepository<ContactUsQueryEntity, Long> {
    ContactUsQueryEntity findContactUsQueryEntityById(long id);
}
