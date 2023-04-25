package com.DSA.Design_Patterns.Structural;

/*
    Decorator means decorating an existing item with an added accessory
    In Software terms, this means, adding some property to an existing object

    Consider, we are having a Pizza Object
    -> We might have to use multiple objects that we do not know about
    -> In the future, some new toppings may come.
        -> Builder pattern might be too complex in this case
            -> Also, builder is a creation design pattern which comes in place while creating object
            -> Right now, Pizza is there, we want to decorate it with added items.

*/
public class Decorator {

    public interface Pizza {

        String getDescription();
        int getCost();
    }


    // Concrete "Pizza" class. This will be our first original Object

    public static class PlainPizza implements Pizza {


        @Override
        public String getDescription() {
            return "Plain Pizza";
        }

        @Override
        public int getCost() {
            return 100;
        }
    }


    // Now, if we want to decorate it with further items, we need to add to the properties of Pizza
    // So, either based on conditions, we can edit the properties via getter and setter. This is might not be suitable for a big code base

    // What we do here, we create an abstractFactory class of Decorator items
    // So, any decorator that we want, can be created from this factory class
    // Once that decorator object is created, we will give that property to current Item

    public static abstract class DecoratorFactory implements Pizza {

        protected Pizza pizza;


        // We provide interface reference, and during object creation (when constructor is called), 'pizza' will hold reference to an object which implements the Pizza class
        // So, basically, we will have an object of a class which implements Pizza interface
        public DecoratorFactory(Pizza pizza) {
            this.pizza = pizza;
        }

        // Since this is abstract class, it need not implement the methods of the interface

        @Override
        public String getDescription() {
            return pizza.getDescription();
        }

        @Override
        public int getCost() {
            return pizza.getCost();
        }
    }


    // We create decorator objects from the DecoratorFactory

    public static class CheeseTopping extends DecoratorFactory {

        public CheeseTopping(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + ", Cheese";
        }

        @Override
        public int getCost() {
            return pizza.getCost() + 25;
        }
    }

    public static class TomatoTopping extends DecoratorFactory {

        public TomatoTopping(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + ", Tomato";
        }

        @Override
        public int getCost() {
            return pizza.getCost() + 15;
        }

    }

    // Client Side Code
    public class Main {
        public static void main(String[] args) {

            Pizza pizza = new PlainPizza();
            pizza = new CheeseTopping(pizza);
            pizza = new TomatoTopping(pizza);


            System.out.println(pizza.getDescription());
            System.out.println(pizza.getCost());
        }
    }


}
