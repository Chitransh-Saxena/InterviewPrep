package com.DSA.Design_Patterns.Behavioural;



/*
    Strategy design pattern allows us to modify the behaviour of an object at runtime
    Basically, apart from a constructor to set an initial state, we also use a setter, to change that state at runtime

    Example:
        A fighting game, where each character has a fighting strategy, which can be changed at will of character

        A character is there, who has a fighting strategy
            -> Composition (fighting strategy object alone has no meaning, until used by a Character)
            -> FightingStrategy needs to be changed at runtime

*/
public class Strategy {


    public interface FightingStrategy {

        String fight();
    }

    public static class SwordFight implements FightingStrategy {

        @Override
        public String fight() {
            return "Swings Sword";
        }
    }


    public static class GunFight implements FightingStrategy {

        @Override
        public String fight() {
            return "HeadShot!!";
        }
    }


    public static class Fighter {

        protected FightingStrategy fightingStrategy;

        public Fighter(FightingStrategy fightingStrategy) {

            this.fightingStrategy = fightingStrategy;
        }

        public void setFightingStrategy(FightingStrategy fightingStrategy) {
            this.fightingStrategy = fightingStrategy;
        }

        public String fight() {
            return this.fightingStrategy.fight();
        }
    }

    // Client side code

    public class Main {

        public static void main(String[] args) {

            Fighter f1 = new Fighter(new SwordFight());
            Fighter f2 = new Fighter(new SwordFight());

            f1.fight();
            f2.fight();

            f1.setFightingStrategy(new GunFight());
            f1.fight();
        }
    }

}
