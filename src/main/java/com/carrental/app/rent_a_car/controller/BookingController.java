package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.entity.BookingEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking/")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to booking ...";
    }

    @PostMapping(value = "createBooking")
    public ResponseMessage createBooking(@RequestBody BookingEntity bookingEntity) {
        return bookingService.createBooking(bookingEntity);
    }

    @GetMapping(value = "getBookings")
    public List<BookingEntity> getBookings() {
        return bookingService.getBookings();
    }

    @GetMapping(value = "getBooking/{id}")
    public BookingEntity getBooking(@PathVariable long id) {
        return bookingService.getBooking(id);
    }

    @PostMapping(value = "updateBooking")
    public ResponseMessage updateBooking(@RequestBody BookingEntity bookingEntity) {
        return bookingService.updateBooking(bookingEntity);
    }

    @GetMapping(value = "deleteBooking/{id}")
    public ResponseMessage deleteBooking(@PathVariable long id) {
        return bookingService.deleteBooking(id);
    }
}
