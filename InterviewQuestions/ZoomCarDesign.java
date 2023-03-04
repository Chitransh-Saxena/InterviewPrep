package com.DSA.InterviewQuestions;

public class ZoomCarDesign {

    /*


Design Car Rental System like ZoomCar:
Users should be able to create an account for them to book vehicles of the below types.
HATCHBACK
SUV
SEDAN
THREE WHEELER
TRUCK
VAN
MOTORCYCLE
BICYCLE
Admin should be able to add vehicle to inventory.
Users should be able to book an available vehicle.
Availability
Nearby stores
Users should be able to scan qrCode of the vehicle and book (walkin booking).
Users can pick booked vehicle from the available from the designated places.
Users should be able to cancel the booking.
Users should be able to return the vehicle post usage.
Users get invoice for payment post returning the vehicle. (Class level)
Users Should get reminder notification a day before their booking.
System should be provide APIs to search for vechicles booked by users by user id and for a particular interval.

Database schema
Entity design etc
Class level design
Creation
How are they going to interact with each other (Behaviour)


Database Schema
Request for some car
CarInfo Table
Category (SUV, SEDAN, HB)
Car name
Unique Id for each car
Store Location (arguable, not sure right now)
QR or ID
Store ID
Nearby location or Store for the vehicles
City
State
Country
What cars does it have
Count of the cars
Store owner
Store ID
Car
Category
Car id
Plate
Necessary info about cars
Brand Name
Rental Price
Customer
Users (which are asking / renting the car)
Email
Name
Number
Address
Admin
ID
Name
Store / HQ
Access Rights Level
Booking
Booking Id
User ID
Car ID
Scheduled Pick up Time
Pick up Time
Pick up location
Scheduled Drop Time
Drop time
Drop Location
Store to which the car last belonged


-> Logged in (Bangalore) -> City Selected (bglr) -> Book SUV -> time duration


Select CAR NAME, CAR_ID FROM CAR as C WHERE C.COUNT > 0 AND STORE_ID IN (SELECT STORE_ID FROM STORE AS S WHERE CITY = ‘BLR’) AND CAR_ID IN (SELECT CAR_ID FROM BOOKING WHERE PICK_UP_TIME > SCHEDULED_PICK_UP_TIME && DROP_TIME < SCHEDULED_DROP_TIME);
SELECT CAR_ID FROM BOOKING WHERE PICK_UP_TIME > SCHEDULED_PICK_UP_TIME && DROP_TIME < SCHEDULED_DROP_TIME. (Get the cars which are not booked in the range of given input pick up and drop time)



Class Design
Flow
-> User -> Search -> Cars or anything -> Booking -> Store ->
-> Notification -> Text/email -> Check bookings for this
-> Admin is adding (1 time thing)

Creation
-> User, Admin, System (Handles the process)
-> Enum for Categories
-> Vehicle
	-> CategoryEnum
	-> Number
	-> All info that we wrote in DB design
-> Search (API in some dashboard Class
-> System / Dashboard
	-> This will be aggregation of objects and communication between them will happen here
-> Booking
-> Notification
	-> NotificationService
		-> NotificationType

		-> sendNotification();
	-> NotificationType
		-> Email
		-> Text
		-> Whatsapp
	-> Creation of above can be like Abstract Factory
	-> The classes interaction (behavioural design pattern)
		-> Bridge Pattern
-> Payment

// List<Car> getInfo(User user) {
	// Query the booking table with the user id;
	List<Car> = DAO.getBookingInfo(user.getUserId());
}


createBooking()
modifyBooking()
cancelBooking()



Create a new booking
User
Car
Scheduled pick up time
Location

createBooking(User user, Car,  InputTime time, Location location)
modifyBooking(User user, Booking booking, Booking updatedBookingObject);
cancelBooking(User user, Booking booking);

     */
}
