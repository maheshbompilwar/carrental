package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.BookingEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.BookingRepository;
import com.carrental.app.rent_a_car.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public ResponseMessage createBooking(BookingEntity bookingEntity) {
        bookingRepository.save(bookingEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public List<BookingEntity> getBookings() {
       return bookingRepository.findAll();
    }

    @Override
    public BookingEntity getBooking(long id) {
      return bookingRepository.findBookingEntityById(id);
    }

    @Override
    public ResponseMessage updateBooking(BookingEntity bookingEntity) {
        if (bookingRepository.findBookingEntityById(bookingEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");
       bookingRepository.save(bookingEntity);
        return new ResponseMessage("Record Updated Successfully...", true);
    }

    @Override
    public ResponseMessage deleteBooking(long id) {
        if (bookingRepository.findBookingEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        bookingRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }
}
