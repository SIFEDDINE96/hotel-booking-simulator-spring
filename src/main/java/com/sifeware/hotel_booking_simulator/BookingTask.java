package com.sifeware.hotel_booking_simulator;

import java.util.concurrent.ThreadLocalRandom;

public class BookingTask implements Runnable {
    private final int bookingId;

    public BookingTask(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
            System.out.println("✅ Booking processed for ID: " + bookingId +
                    " by " + Thread.currentThread());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
