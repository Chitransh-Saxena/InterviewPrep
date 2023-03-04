package com.DSA.LLD;

public class LoggingFramework {

    /*
        Requirements
            -> Should be able to log in more than 1 place
            -> Should have log levels, INFO, ERROR, DEBUG etc.

        Components involved
            -> Logger
            -> Category
            -> Sink



        Application -> Logger -> Category{ERROR, INFO, DEBUG} -> SINK{Console, File, DB}

        Creational
            -> Singleton
                -> For Logger
                -> Saves us during serialization

            -> Abstract Factory
                -> For Sink
                -> Category could also be done like this if we want to provide behaviour to each category
                    -> Else, just take it as enum and use it in SINK
        Structural
            -> Used when we try to create connection between two components in a system
                -> Like if we want to have some connection between Category or Sink etc.
                    -> Don't see anything like that so far, but if needed, will code
                -> Notification service was using bridge pattern for NotificationSender type implementation and NotificationType abstraction
                -> Composite is used when we want to include another object with us in tree-subtree type of format
                    -> Like a File Directory heirarchy
                    -> Based on OCP
                -> Flyweight
                    -> RAM
                    -> Let's us fit more of relevant data into memory
                        -> Cache
                -> Facade
                    -> Basically creates a layer of implementation between two components
                        -> Example: If we are fetching some data from somewhere, and it needs to be digested by some API
                            -> And if we need to do filter, then instead of adding filter as a functionality to the system API
                                -> We can implement it as a stand alone filter used by the API
                                -> This way, it is easy to grow in future an decoupled
                        -> OCP, SRP

        Behavioural
            -> In the log category
                -> INFO, ERROR, DEBUG
                -> We know it follows a once instance at a time hierarchial structure
                -> If we are at level info, and we encounter error, we move log level to error
                    -> What does it mean by moving Log Level to error?
                        -> They sort the logs based on urgency and alertness
                        -> So, any logging level will capture logs of current level and above
                    -> This means, if we are ERROR, INFO logs would be ignored from now on.
                    -> If we had the log level set to ALL or TRACE, you would see both integers in the log file. If we changed the log level to, say, WARN, then we would only see y.
                    -> And if we turned the log level all the way down to FATAL, we would see nothing.
                -> This can be related to chain of command behaviour
                    -> Chain of Responsibility
                        -> Instead of adding functionalities to current system
                        -> We can extend the work to other APIs and let the chain continue.
                        -> This is on the basis of OCP and SRP principle, but it can increase network latency sometimes.


            -> In the Sink
                -> We have several types of sinks which are independent of each other
                -> They are dependent on the what the before part of logging framework did
                    -> So, if error log is coming, we don't know to which sink it would go
                -> So, SINK is basically OBSERVING the log and category and would be enabled accordingly
                    -> So, SINK will be implemented based on Observer Pattern

                -> If above part seems complicated, there is no harm in implementing logger like a standard instance being used by the class
                    -> Just tell you know observer pattern would be useful here
                    -> Pattern implementation is not clear as such


            -> Other behaviour design patterns
                -> Command
                    -> Turns request into a stand-alone object that contains all the informations.
                    -> Example - RequestBody param in endpoints.
                -> Iterator
                    -> Used for iterating over objects
                -> Mediator
                    -> @Controller
                        -> Takes care of how communication happens
                -> Momento
                    -> Let's use restore previous state
                        -> ctrl + z
                -> Observer
                    -> Kind of like MQ (Publish Subscribe)


            Classes

            AbstractLogger
                -> This will create InfoLogger, ErrorLogger etc.
                -> will log the current message
                -> will setNextLogging level when needed
                    -> Because of this, we need to define a level in this class
                    -> Each subclass will have it's own level and that can be used for log level identification

                -> void setNextLoggingLevel(AbstractLogger nextlogger) {}

                void logMessage(int level, String msg) {

                       if(this.level <= level) {
                        display(msg);
                       }

                       else {
                        nextLoggingLevel.logMessage();
                       }
                }

                public abstract void display(); // Becuase each level will display this accordingly and with it's own functionality like notification etc.


     */
}
