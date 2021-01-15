package com.carrental.app.rent_a_car.repository;

import com.carrental.app.rent_a_car.entity.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long> {
    SubscriberEntity findSubscriberEntityById(long id);
}
