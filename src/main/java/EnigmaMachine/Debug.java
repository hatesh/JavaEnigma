package EnigmaMachine;

public class Debug {
    public static void main(String[] args) {
        Plugboard pb = new Plugboard("Custom");
        pb.addPlug(new Plug(3, 23));
        // System.out.println(pb.passInt(6));
        // System.out.println(pb.toString());
    }
}
