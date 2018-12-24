package EnigmaMachine;

import Exceptions.MaxPopulationException;

public class Debug {
    public static void main(String[] args) {
        PlugBoard pb = new PlugBoard("Custom");
        try {
            pb.addPlug(new Plug(3, 23));
        } catch (MaxPopulationException e) {
            System.out.println(e.getMessage());
        }
        // System.out.println(pb.passInt(6));
        // System.out.println(pb.toString());
    }
}
