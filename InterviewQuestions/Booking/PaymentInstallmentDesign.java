package com.DSA.InterviewQuestions.Booking;

/*

You are booking service provider and customers can book hotels from your website.
Customer has to pay all the amount at once, but you can pay to the hotel in installments (This part is configurable). What will be the high level design of such system

*/

public class PaymentInstallmentDesign {

    /*
        Functional Requirements
            -> Mentioned above. That's it
        Non-Functional Requirements
            -> Scalable design (Booking has a huge customer base)
            -> Low Latency
            -> Consistency of the system
                -> Once a payment is done, it should not be done again.
                -> If it fails, transaction has to roll back properly
                    -> If multiple transactions are involved, how to roll back


        How to proceed with such question in an interview
            -> Requirement discussion and how the functional requirement can be converted into a solution
            -> Discussion on various components that can be involved in the picture
                -> Question - How do we come to a conclusion on what all components are required for a system
                -> Answer
                    -> Understand how the requirement flows
                        -> Break down the requirement into use-cases
                    -> Group the use-cases based on logical components
                        -> All the requirements related to making a booking or cancelling a booking would go to the booking service
                        -> If there is no installment required, we can directly interact with some payment gateway service, bypassing whatever scheduler we want.

    */
}
