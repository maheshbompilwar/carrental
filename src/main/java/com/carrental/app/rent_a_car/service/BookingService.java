package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.BookingEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;

import java.util.List;

public interface BookingService {
    ResponseMessage createBooking(BookingEntity bookingEntity);

    List<BookingEntity> getBookings();

    BookingEntity getBooking(long id);

    ResponseMessage updateBooking(BookingEntity bookingEntity);

    ResponseMessage deleteBooking(long id);
}
