package com.sifeware.hotel_booking_simulator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BookingService {

    public void simulateBookings(int totalBookings, boolean useVirtualThreads) throws Exception {
        ExecutorService executor;

        if (useVirtualThreads) {
            System.out.println("🚀 Using Virtual Threads...");
            executor = Executors.newVirtualThreadPerTaskExecutor();
        } else {
            System.out.println("🧱 Using Platform Threads...");
            executor = Executors.newFixedThreadPool(200);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < totalBookings; i++) {
            executor.submit(new BookingTask(i));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(50);
        }

        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("⏱️ Completed " + totalBookings + " bookings in " + timeTaken + " ms");
    }
}
