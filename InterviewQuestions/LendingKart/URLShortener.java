package com.DSA.InterviewQuestions.LendingKart;


/*
    Standard URL shortener. My design was perfect, only the cross question related to hashing and write concurrency on database side was a place I felt I am lacking knowledge

    Things to get in depth of
        -> Multiple Hashing Algorithms
            -> Knowing name is not enough, some understanding of functionality is required
        -> Question has to be asked
            -> How many character of unique hash are we talking about once we are given a URL
        -> Considering if two people are requesting for a Unique url of a website, they both should receive different URLs
            -> Sticky session is the way to go, because increasing the transaction locking level will slow down the process. I was unaware of how to handle the trade-off
                -> But this can lead to DDOS attack, need to understand rate limiter.
            -> Did not know this in interview
        -> Caching
            -> LRU and LFU on code level.
        -> HTTP code 303
            -> I knew this is for re-direction
            -> Question, who is doing the re-direction?
                -> Your API? Your FE?
                -> No, the code returns to browser, it sees 303, and knows it has to re-direct the request to the mentioned resource
            -> Understand it with one practical example
*/
public class URLShortener {
}
