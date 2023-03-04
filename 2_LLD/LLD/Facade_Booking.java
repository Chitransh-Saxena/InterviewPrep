package com.DSA.LLD;

public class Facade_Booking {

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
                    -> When the food arrives, give token, recieve food
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
}
