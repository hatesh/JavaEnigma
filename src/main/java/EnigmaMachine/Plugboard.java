package EnigmaMachine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class Plugboard {
    private ArrayList<Plug> plugs = new ArrayList<>();
    private ArrayList<Integer> plugged = new ArrayList<>();
    public Plugboard() {
        this("Random");
    }
    public Plugboard(String config) {
        if (config.equals("Random")) {
            Random random = new Random();
            int input = random.nextInt(25);
            int output = random.nextInt(25);
            for (int i = 0; i < 10; i++) {
                while (plugged.contains(input) || plugged.contains(output) || input == output) {
                    input = random.nextInt(25);
                    output = random.nextInt(25);
                }
                plugs.add(new Plug(input, output));
                plugged.add(input);
                plugged.add(output);
            }
        } else {
            // TODO
        }
    }

    public int passInt(int i) {
        int rtn;
        try {
            Plug plug = this.plugs.stream().filter(p -> p.getInputInt() == i).findAny().get();
            rtn = plug.getOutputInt();
        } catch (NoSuchElementException e) {
            rtn = i;
        }
        return rtn;
    }

    public int passChar(char c) {
        char rtn;
        try {
            Plug plug = this.plugs.stream().filter(p -> p.getInputChar() == c).findAny().get();
            rtn = plug.getOutputChar();
        } catch (NoSuchElementException e) {
            rtn = c;
        }
        return rtn;
    }

    public void addPlug(Plug p) { this.plugs.add(p); }

    public ArrayList<Plug> getPlugs() {
        return plugs;
    }

    public void setPlugs(ArrayList<Plug> plugs) {
        this.plugs = plugs;
    }

    public ArrayList<Integer> getPlugged() {
        return plugged;
    }

    public void setPlugged(ArrayList<Integer> plugged) {
        this.plugged = plugged;
    }

    public String toString() {
        String string = "Current Plugboard status:\n";
        for (Plug p : plugs) {
            string += p.toString() + "\n";
        }
        string += "Plugged arraylist: " + this.plugged.toString();
        return string;
    }
}
