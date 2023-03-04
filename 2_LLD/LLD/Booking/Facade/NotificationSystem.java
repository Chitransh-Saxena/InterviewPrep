package com.DSA.LLD.Booking.Facade;

public class NotificationSystem {

    public void sendEmail(User user, TicketSystem ticketSystem) {

        System.out.println("Ticket sent to " + user.getUserEmail() + " for Movie" + ticketSystem.getMovieName());
    }

    public void sendMessage(User user, TicketSystem ticketSystem) {

        System.out.println("Ticket sent to " + user.getUserNumber() + " for Movie" + ticketSystem.getMovieName());
    }
}
