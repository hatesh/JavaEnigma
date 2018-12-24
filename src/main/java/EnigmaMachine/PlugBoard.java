package EnigmaMachine;

import Exceptions.MaxPopulationException;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class PlugBoard {
    private ArrayList<Plug> plugs = new ArrayList<>();
    private ArrayList<Integer> plugged = new ArrayList<>();
    private int maxPairs = 10;
    public PlugBoard() {
        this("Random");
    }
    public PlugBoard(String config) {
        if (config.equals("Random")) {
            Random random = new Random();
            int input = random.nextInt(25);
            int output = random.nextInt(25);
            for (int i = 0; i < this.maxPairs; i++) {
                while (plugged.contains(input) || plugged.contains(output) || input == output) {
                    input = random.nextInt(25);
                    output = random.nextInt(25);
                }
                plugs.add(new Plug(input, output));
                plugged.add(input);
                plugged.add(output);
            }
        } else if(config.equals("Default")) {
            this.setPlugs(this.mapPlugBoard("AF,DE,FC,QW,VB,TH,KL,JM,XO,US"));
        } else {
            // TODO
        }
    }

    public ArrayList<Plug> mapPlugBoard(String cypherbet) {
        String[] wires = cypherbet.split(",");
        ArrayList<Plug> plugLayout = new ArrayList<>();
        for (String wire : wires) {
            char[] values = wire.toCharArray();
            plugLayout.add(new Plug(values[0], values[1]));
        }
        return plugLayout;
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

    public char passChar(char c) {
        char rtn;
        try {
            Plug plug = this.plugs.stream().filter(p -> p.getInputChar() == c).findAny().get();
            rtn = plug.getOutputChar();
        } catch (NoSuchElementException e) {
            rtn = c;
        }
        return rtn;
    }

    public void addPlug(Plug p) throws MaxPopulationException {
        if (this.plugs.size() < maxPairs) {
            this.plugs.add(p);
        } else {
            throw new MaxPopulationException("PlugBoard.plugs", this.plugs, this.maxPairs);
        }
    }

    public ArrayList<Plug> getPlugs() {
        return plugs;
    }

    public void setPlugs(ArrayList<Plug> plugs) {
        this.plugs = plugs;
    }

    public ArrayList<Integer> getPlugged() {
        return plugged;
    }

    public void setPlugged(ArrayList<Integer> plugged) { this.plugged = plugged; }

    public void setMaxPairs(int pairs) { this.maxPairs = pairs; }

    public int getMaxPairs() { return this.getMaxPairs(); }

    public String toString() {
        String string = "Current PlugBoard status:\n";
        for (Plug p : plugs) {
            string += p.toString() + "\n";
        }
        string += "Plugged ArrayList: " + this.plugged.toString();
        return string;
    }
}
