package com.DSA.LLD.Booking.Facade;

/*
        Facade
            -> It is a structural design pattern
            -> Enables us to setup the code in a neat and clean structure
            -> Makes complex APIs easy to use
            -> It is more about refactoring

            -> We add a layer of Facade Class to interact and do the complex operations.
                -> So, the code will call the facade class instead of directly calling the complex methods.
                -> This improves the code clarity and makes it easy to maintain
                -> How is this different from Abstraction?


            -> Example with Analogy?
                -> In a self serviced restaurants, the customer has to do the following
                    -> Order, get the token
                    -> When the food arrives, give token, receive food
                    -> Get water if needed
                    -> Place the tray in trash can
                -> In serviced restaurants
                    -> We have a waiter
                        -> Asks for our order, notes it down
                        -> When the food is ready, he brings it to us
                        -> Water and every need is taken care of
                        -> At the end, waiter cleans the table
                        -> And bill is also paid to him
                    -> Waiter acts as a facade layer.

                -> So, in terms of programming
                    -> Whenever we have a complex system and operations that are to be used by the client
                    -> Instead of exposing the endpoints or the operations directly to the client, we can add a facade layer
                    -> Client can order the facade layer to do the required operations
                        -> Thus reducing complexity for the client.

     */


/*
    For this demo:
        -> Movie ticket booking system
            -> Checks if movie is available
            -> Books ticket, makes payment
            -> Sends a message and notification

 */

public class Client {

    public static void main(String[] args) {

        /*
            User user = new User("chitransh", "test@gmail.com", 1234567891L);
            TicketSystem ticket = new TicketSystem();
            ticket.setTicketNumber(123);
            ticket.setMovieName("Movie1");

            PaymentSystem ps = new PaymentSystem();
            ps.chargeCard();

            NotificationSystem ns = new NotificationSystem();
            ns.sendEmail(user, ticket);
            ns.sendMessage(user, ticket);


            Above is a basic non-facade design, in the below non-commented code, Facade class code will be written.
            Intuitively, what do we need to do?
                -> All the initializations related to booking, we do not want client to do it
                    -> That will be done by FacadeClass


         */

        User user = new User("chitransh", "test@gmail.com", 1234567891L);
        BookingFacade booking = new BookingFacade();
        booking.createBooking(user);
    }
}
