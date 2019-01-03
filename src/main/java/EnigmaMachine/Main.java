package EnigmaMachine;

public class Main {
    public static void main(String[] args) {
        EnigmaMachine em1 = new EnigmaMachine();
        EnigmaMachine em2 = new EnigmaMachine();
        em1.setPlugBoard(new PlugBoard("Empty"));
        em2.setPlugBoard(new PlugBoard("Empty"));
        String plain = "HELLO WORLD";
        String cipher = em1.encode(plain);
        String decrypt = em2.encode(cipher);
        System.out.println(plain);
        System.out.println(cipher);
        System.out.println(decrypt);
    }
}
