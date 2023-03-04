package com.DSA.LLD;

public class AmazonLLD {

    /*
        Requirements
            -> Users should be able to add and remove products to sell
            -> Search based on product, category etc.
            -> Any user can search and add to cart
                -> Only registered users can buy
            -> Checkout and purchase
            -> Product Rating etc.
            -> Shipment Tracking



        Flow that we understand
            -> User logs in
                -> Sees some products
                -> Is given option to search for products
                -> Registers and creates an account
            -> For Registration, it is a simple process
                -> RegisteredUser class would be instantiated
                -> Details stored in DB
                -> Proceed to main page again
            -> For Search
                -> List of products open
                    -> Count
                    -> Price
                    -> Delivery Available or not
                -> Sorted by some criteria
                    -> Provide other sorting criteria
                -> Adding this to cart
                    -> Since, cart should have a single instance, it is good to have cart as a singleton pattern
                -> Purchase of product
                    -> Payment, notification, etc.
                -> Delivery tracking
                    -> Update status after each physical update
                    -> Notify the user
     */
}
