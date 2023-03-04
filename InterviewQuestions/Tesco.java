package com.DSA.InterviewQuestions;

public class Tesco {

    /*
        -> HLD

        Design URL shortner system

What?
	-> generic, more of a API where we send original URL, and get a shortned one
	-> Some kind of stats on the hits of the URL


Functional
	-> generic, more of a API where we send original URL, and get a shortned one
	-> Some kind of stats on the hits of the URL
	-> Should not be guessable in nature
		-> We need a good algorithm to generate unique keys for the URLs
	-> TTL

Non-Functional
	-> Available
		-> Fault tolerant
	-> Consistency
		-> sending 1 URL -> same shortened URL for that

Scale
	-> 1 day = 1,00,000 hits
	-> 1 month = 500 million
	-> 1 day = 500 million / 30;
		-> Pretty huge, we have to be prepared for a huge scale

	-> How many URLs are we hitting
		-> All the GET, POST and everything that we have
		-> 500 million unique URLs
	-> 1 URL created - 117 unique hits average
	-> Latency
		-> We need good latency
		-> How?
		-> From 1 URL, shortened URL has to be created -> Redirection to the proper IP (server)


Design

API Signature

-> To reach the target IP with shortened URL

	@GetMapping(value = "/{shortnedURL}")
	public ResponseEntity method(@PathVariable("shortnerURL"), Token) {

		// Service to get required URL
		// 302 -> new URL -> browser opens
		// 404 - Not found
		// 500 - internal error.

	}

-> To generate the shortened URL from original

	@PostMapping(value = "/{originalURL}")
	public ResponseEntity method(@PathVariable("originalURL"), Token) {

		// respond with shortened URL
	}


-----


URL (www.something.com/someOtherThing) -> We want a shortened URL to store in DB or for our UI application, this will redirect to proper DNS -> Server

How do we generate the shortened URL?

H.L.D


URL Shortner API -----> Servers that are gonna run the algorithm ----> Store the mapped URL in DB ----> Respond with the shortened URL









    */
}
