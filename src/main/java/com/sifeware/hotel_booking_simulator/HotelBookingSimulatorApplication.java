package com.sifeware.hotel_booking_simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelBookingSimulatorApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HotelBookingSimulatorApplication.class, args);

        BookingService bookingService = new BookingService();
        int totalBookings = 5000;

        System.out.println("========== Traditional Threads ==========");
        bookingService.simulateBookings(totalBookings, false);

        System.out.println("\n========== Virtual Threads ==========");
        bookingService.simulateBookings(totalBookings, true);
    }

}
