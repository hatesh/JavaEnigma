package EnigmaMachine;

import Exceptions.MaxPopulationException;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

import static Util.CharUtil.getValue;

public class PlugBoard {
    private ArrayList<Plug> plugs = new ArrayList<>();
    private ArrayList<Integer> plugged = new ArrayList<>();
    private int maxPairs = 20;
    public PlugBoard() {
        this("Default");
    }
    public PlugBoard(String config) {
        if (config.equals("Random")) {
            Random random = new Random();
            int input = random.nextInt(25);
            int output = random.nextInt(25);
            for (int i = 0; i < this.maxPairs / 2; i++) {
                while (plugged.contains(input) || plugged.contains(output) || input == output) {
                    input = random.nextInt(25);
                    output = random.nextInt(25);
                }
                try {
                    this.addPlug(new Plug(input, output));
                    plugged.add(input);
                    plugged.add(output);
                } catch (MaxPopulationException e) {
                    System.out.println(e.getMessage());
                }

            }
        } else if (config.equals("Default")) {
            try {
                this.setPlugs(this.mapPlugBoard("AF,DE,GC,QW,VB,TH,KL,JM,XO,US"));
            } catch (MaxPopulationException e) {
                System.out.println(e.getMessage());
            }
        } else if (config.equals("Empty")) {
            this.plugs.clear();
            this.plugged.clear();
        } else {
            try {
                this.setPlugs(this.mapPlugBoard(config));
            } catch (MaxPopulationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ArrayList<Plug> mapPlugBoard(String cypherbet) {
        String[] wires = cypherbet.split(",");
        ArrayList<Plug> plugLayout = new ArrayList<>();
        for (String wire : wires) {
            char[] values = wire.toCharArray();
            plugLayout.add(new Plug(values[0], values[1]));
            plugLayout.add(new Plug(values[1], values[0]));
            plugged.add(getValue(values[0]));
            plugged.add(getValue(values[1]));
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

//    public int passInt(int i) {
//        int rtn;
//        try {
//            Plug plug = this.plugs.stream().filter(p -> p.getInputInt() == i).findAny().get();
//            rtn = plug.getOutputInt();
//        } catch (NoSuchElementException e) {
//            rtn = i;
//        }
//        return rtn;
//    }
//
//    public char passChar(char c) {
//        char rtn;
//        try {
//            Plug plug = this.plugs.stream().filter(p -> p.getInputChar() == c).findAny().get();
//            rtn = plug.getOutputChar();
//        } catch (NoSuchElementException e) {
//            rtn = c;
//        }
//        return rtn;
//    }
//
//    public char passOutputChar(char c) {
//        char rtn;
//        try {
//            Plug plug = this.plugs.stream().filter(p -> p.getOutputChar() == c).findAny().get();
//            rtn = plug.getInputChar();
//        } catch (NoSuchElementException e) {
//            rtn = c;
//        }
//        return rtn;
//    }

    public void addPlug(Plug p) throws MaxPopulationException {
        if (this.plugs.size() < maxPairs - 1) {
            this.plugs.add(p);
            this.plugs.add(new Plug(p.getOutputInt(), p.getInputInt()));
        } else {
            throw new MaxPopulationException("PlugBoard.plugs", this.plugs, this.maxPairs);
        }
    }

    public ArrayList<Plug> getPlugs() {
        return plugs;
    }

    public void setPlugs(ArrayList<Plug> plugs) throws MaxPopulationException {
        if (plugs.size() > maxPairs) {
            throw new MaxPopulationException("PlugBoard.setPlugs(<plugs>)", plugs, this.maxPairs);
        } else {
            this.plugs = plugs;
        }
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
            string += "    " + p.toString() + "\n";
        }
        string += "    Plugged ArrayList: " + this.plugged.toString();
        return string;
    }
}
