package EnigmaMachine;

import Exceptions.MaxPopulationException;

public class Main {
    public static void main(String[] args) {
        EnigmaMachine em = new EnigmaMachine();
        System.out.println(em.encode("HELLO WORLD"));
    }
}