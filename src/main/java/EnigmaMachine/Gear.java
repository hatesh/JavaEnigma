package EnigmaMachine;

import Exceptions.MaxPopulationException;

import static Util.CharUtil.getValue;
import static Util.CharUtil.getLetter;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Gear {
    private ArrayList<Plug> mappings = new ArrayList<>();
    private String name;
    private int currentIndex;
    private int maxMappings = 26;

    public Gear(String name, String cypherbet) {
        this.name = name;
        this.setMappings(cypherbet);
        currentIndex = 0;
    }
    public Gear(String name, String cypherbet, int initialIndex) {
        this(name, cypherbet);
        this.setCurrentIndex(initialIndex);
    }

    public int shiftAndPassInt(int i) {
        int shiftedInput = this.currentIndex + i;
        shiftedInput %= 26;
        return passInt(shiftedInput);
    }

    public char shiftAndPassChar(char c) {
        // this.updateCurrentIndex();
        // return passChar(c);
        return getLetter(shiftAndPassInt(getValue(c)));
    }

    public int passInt(int i) {
        int rtn;
        try {
            Plug plug = this.mappings.stream().filter(p -> p.getInputInt() == i).findAny().get();
            rtn = plug.getOutputInt();
        } catch (NoSuchElementException e) {
            rtn = i;
        }
        return rtn;
    }

    public char passChar(char c) {
        char rtn;
        try {
            Plug plug = this.mappings.stream().filter(p -> p.getInputChar() == c).findAny().get();
            rtn = plug.getOutputChar();
        } catch (NoSuchElementException e) {
            rtn = c;
        }
        return rtn;
    }

    public void addMapping(Plug p) throws MaxPopulationException {
        if (this.mappings.size() < maxMappings) {
            this.mappings.add(p);
        } else {
            throw new MaxPopulationException("Gear.mappings", this.mappings, this.maxMappings);
        }
    }

    public void setMappings(String cypherbet) {
        char[] mapChars = cypherbet.toCharArray();
        for (char c: mapChars) {
            try {
                this.addMapping(new Plug (this.mappings.size(), getValue(c)));
            } catch (MaxPopulationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getCurrentIndex() { return this.currentIndex; }

    public void setCurrentIndex(int index) {
        index %= 26;
        this.currentIndex = index;
    }

    public void updateCurrentIndex() {
        this.currentIndex++;
        this.currentIndex = this.currentIndex % 26;
    }

    public ArrayList<Plug> getMappings() { return this.mappings; }

    public String toString() {
        String string = "Gear '" + this.name + "' mappings:\n";
        for (Plug p : mappings) {
            string += p.toString() + "\n";
        }
        string += "Current Index: " + Integer.toString(this.currentIndex);
        return string;
    }
}