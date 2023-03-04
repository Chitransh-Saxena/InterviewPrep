//package com.DSA.InterviewQuestions;
//
//public class PhonePE_LLD {
//
//    Design and implement coupon management system where any distributor can create a batch and ingest coupons into it, and then the system will grant coupons from batch to the user. Basically a first class platform to distribute coupons
//
//            Requirements
//            Batch: A group of coupons having the same characteristics belonging to a distributor, from which coupons will be distributed to the users. There will be complete isolation across batches, i.e anything in one batch won't depend on another batch.
//
//    Batch should have batchId, batchState, validityPeriod, distributor, couponType etc.
//    A batch will initially be in CREATED state and you will need to create a state machine of allowed transitions for a batch.
//    Need to have an approval flow where state needs to be updated to an approved state
//    Then a defined state to mark the batch active.
//    Also when the validity period of a batch is over, mark it expired.
//    If a distributor wants to suspend giving coupons for some time from a batch, then add a state to suspend it, which can later be restarted.
//            Also if a distributor wants to terminate the giving coupons forever, then move the batch to terminated state.
//    We need a time bound batch where the batch will be active within its specified duration, and should get expired after the end date is over, and will become active only after the start date
//    Need to add support for both OPEN(i.e generic code for all users) and CLOSED(i.e unique codes for each user) coupon type.
//    Coupon: A notion entitling the user to a coupon off a particular batch. However, a batch of coupons always share the same characteristics.
//
//            Mandatory implementations
//
//    createBatch(Batch batch)
//    This function will validate if the batch object is valid, if yes then it will create a batch, else return INVALID_REQUEST errorCode.
//    Any merchant who wants to distribute their coupons will create a Batch. Input for batch creation should be taken as an input.
//    Coupon distribution will only happen when the batch is in ACTIVE state.
//    In case of OPEN coupon type, distribute maximum maxAllowedGrants coupons specified in the batch. Take maxAllowedGrants input for open batch.
//
//    updateState(String batchId, BatchState) - To update the state of the batch.
//    If the transition is invalid, return INVALID_TRANSITION
//
//    getBatch(String batchId) - To get the batch details
//
//    ingestCoupons(String batchId, Set couponCodes) - To store the coupon codes in the batch
//
//    grantCoupon(String batchId)
//    It will create the coupon using the coupons present in the batch and return the coupon object.
//    If batchId is invalid then return INVALID_BATCH error
//    If batch is not active, then return BATCH_NOT_ACTIVE error
//    If no coupons are present in the batch, then return BATCH_EXHAUSTED error
//
//    getCoupon(String couponId) - To get the coupon object
//return COUPON_NOT_FOUND in case of invalid couponId
//
//    getCouponsCount(String batchId) - To get the remaining coupons count in any batch.
//
//            Optional
//    Encrypt the coupon before ingesting the couponCode and decrypt it at the time of grant.
//            isBatchAvailable(String batch) - To check if batch has more coupons to distribute
//    Ingest coupons using file -> To ingest the coupon codes present in a file
//
//            Guidelines
//
//    You should store the data in-memory using a language-specific data-structure.
//    Implement clear separation between your data layers and service layers.
//    Simple and basic function are expected as entry point - no marks for providing fancy restful API or framework implementation
//    Because this is a machine coding round, heavy focus would be given on code quality, candidate should not focus too much time on algo which compromises with implementation time
//    Expectations:
//
//    Your code should cover all the mandatory functionalities explained above.
//    Your code should be executable and clean.
//    Your code should be properly refactored, and exceptions should be gracefully handled.
//    Appropriate errors should be displayed on the console
//    Handle any race condition while ingestion and granting of coupons, basically in case of multi-threading env
//    How will you be evaluated?
//
//    Code Should be working
//    Code readability and testability
//    Separation Of Concerns
//            Abstraction
//    Object-Oriented concepts.
//    Language proficiency.
//    Scalability
//    Test Coverage (Bonus Points)
//            [execution time limit] 1 seconds (cpp)
//}
