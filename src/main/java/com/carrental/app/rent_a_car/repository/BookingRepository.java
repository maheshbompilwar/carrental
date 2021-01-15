package com.carrental.app.rent_a_car.repository;

import com.carrental.app.rent_a_car.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    BookingEntity findBookingEntityById(long id);
}
