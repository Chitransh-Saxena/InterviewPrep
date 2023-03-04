package com.DSA.LLD;

public class BookMyShow {

    /*
        Requirements
            -> Already provided with a directory or access to get cinema halls with

       Flow
        -> When we open BMS or any system like this
            -> We can search for movies or nearby movie theatres
            -> Once we select the required item, we make a booking
     */

    public<List<Movie>> getMovies(Date date, Location location);
    pulic<List<CinemaHall>> getHalls(Location);

    // From above, we know we need Movie and CinemaHall Class

    public class Movie {


    }

    public class CinemaHall {

        List<Movie> moviesHere;

        // We can have some auditorium or hall identifier where the movie would be booked
        List<Auditorium> auditoriumList;
            // We can instantiate different auditorium types with different sorts of seats

        // During booking, that would be taken into consideration

        // Do we book a seat from auditorium or from CinemaHall?
        // Based on above, we can think if we need to provide seat info list from here, and then instantiate a Auditorium and Seat Object for a certain user
        List<Seat> seat;
            // Above will hold seats info, which is booked and which is not.
            // We can argue if this list also needs to be part of show or not.
    }

    // Since we need to map these to certain people and make a proper booking, it is better to provide these with some certain unique identifiers

    // Once, we select which show to book, we have to make a booking

    public class Booking {


    }

    // Further, for each seat we can have some enums for types of Booking (booked, unbooked, poepleAreCurrentlyBooking
    // Similarly, we can have enums for seatTypes [Luxury, small, etc.]

    // We can also have some enum for Generes, and use it as a filter in Main BMS dashboard





    // Once these classes are created, we need to add structure and behaviour to them

    /*
        What sort of behaviour are we expecting
            -> Once user is able to select which seat, which movie which theatre
            -> User should be able to book the movie tickets
                -> But the user should not be able to directly do this
                -> We need to create abstraction and provide him with the methods to book the ticket
                    -> At the same time, we need our system to handle the database transaction control as well (to avoid booking conflicts)
            -> Once this user has booked the tickets,
                -> We need to use some sort of message queue to update everyone that the certain seats are booked.
                    -> Even if this is not that instant, we should be good. So an MQ is fine.
                    -> How do we update the UI?
                        -> Scheduled polling from BE?
                        -> Ajax Long Polling?
                        -> One thread for this, subscriber listening for publisher to give something.


            -> Search class should be also implemented, for all the search criteria.

            -> Payment has also to be processed.
     */

    /*
        Concurrency Control in database
            -> Process of managing simultaneous database calls and connections
            -> This is supposed to be done in shared database, in order to serialization transactions

       Purpose
        -> To enforce isolation
            -> Two transactions have to work isolated. In a sequence
        -> To preserve DB consistency
        -> To resolve read and write conflicts.



        Concurrency Control Techniques
            -> Lock Based Protocol
                -> Provides exclusive use of data items for current transaction
                    -> To access data item (We acquire Lock on Data
                    -> Till the completion of transaction (Lock is released afterwards)
                -> All data items must be accessed in a mutually exclusive manner
                    -> If one transaction is accessing the data items, no other transaction is allowed to update the data items.

                -> Types of Locks in Lock-based Protocol
                    -> Shared Lock (Lock-S)
                        -> Not updating, only reading the data value
                    -> Exclusive Lock (Lock-X)
                        -> When we are updating the value (update, delete)
                        -> Used in both read and write
     */
}
