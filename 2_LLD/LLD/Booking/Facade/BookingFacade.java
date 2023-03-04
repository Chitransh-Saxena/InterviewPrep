package com.DSA.LLD.Booking.Facade;

public class BookingFacade {

    public void createBooking(User user) {

        TicketSystem ticket = new TicketSystem();
        PaymentSystem ps = new PaymentSystem();
        NotificationSystem ns = new NotificationSystem();

        ticket.setTicketNumber(123);
        ticket.setMovieName("Movie1");

        ps.chargeCard();

        ns.sendEmail(user, ticket);
        ns.sendMessage(user, ticket);
    }
}
