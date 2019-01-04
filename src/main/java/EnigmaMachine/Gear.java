package EnigmaMachine;

import Exceptions.IncorrectCypherbetException;
import Exceptions.MaxPopulationException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static Util.CharUtil.getLetter;
import static Util.CharUtil.getValue;

public class Gear {
    private ArrayList<Plug> mappings = new ArrayList<>();
    private String name;
    private int currentIndex;
    private int maxMappings = 26;
    private int ringSetting = 0;

    public Gear(String name, String cypherbet) {
        this(name, cypherbet, 0);
    }

    public Gear(String name, String cypherbet, int initialIndex) {

        try {
            this.name = name;
            this.setMappings(cypherbet);
        } catch (IncorrectCypherbetException e) {
            this.name = "Invalid";
        }

        this.setCurrentIndex(initialIndex);
    }

    public int passInputIntWithShifts(int input) {
        input = (input + this.currentIndex) % 26;
        int rtn = passInputInt(input);
        rtn = (rtn + this.currentIndex) % 26;
        return rtn;
    }

    public int passOutputIntWithShifts(int output) {
        output = (output - currentIndex) % 26;
        if (output < 0) output += 26;
        int rtn = passOutputInt(output);
        rtn = (rtn - this.currentIndex) % 26;
        if (rtn < 0) rtn += 26;
        return rtn;
    }

    public int passInputInt(int i) {
        int rtn;
        try {
            Plug plug = this.mappings.stream().filter(p -> p.getInputInt() == i).findAny().get();
            rtn = plug.getOutputInt();
        } catch (NoSuchElementException e) {
            rtn = i;
        }
        return rtn;
    }

    public int passOutputInt(int i) {
        int rtn;
        try {
            Plug plug = this.mappings.stream().filter(p -> p.getOutputInt() == i).findAny().get();
            rtn = plug.getInputInt();
        } catch (NoSuchElementException e) {
            rtn = i;
        }
        return rtn;
    }

    public char passInputChar(char c) {
        char rtn;
        try {
            Plug plug = this.mappings.stream().filter(p -> p.getInputChar() == c).findAny().get();
            rtn = plug.getOutputChar();
        } catch (NoSuchElementException e) {
            rtn = c;
        }
        return rtn;
    }

    public char passOutputChar(char c) {
        char rtn;
        try {
            Plug plug = this.mappings.stream().filter(p -> p.getOutputChar() == c).findAny().get();
            rtn = plug.getInputChar();
        } catch (NoSuchElementException e) {
            rtn = c;
        }
        return rtn;
    }

    public char passInputCharWithShifts(char c) {
        return getLetter(passInputIntWithShifts(getValue(c)));
    }

    public char passOutputCharWithShifts(char c) {
        return getLetter(passOutputIntWithShifts(getValue(c)));
    }



    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int index) {
        index %= 26;
        this.currentIndex = index;
    }

    public void updateCurrentIndex() {
        this.currentIndex++;
        this.currentIndex = this.currentIndex % 26;
    }

    public ArrayList<Plug> getMappings() {
        return this.mappings;
    }

    public void addMap(Plug p) throws MaxPopulationException {
        if (this.mappings.size() < maxMappings) {
            this.mappings.add(p);
        } else {
            throw new MaxPopulationException("Gear.mappings", this.mappings, this.maxMappings);
        }
    }

    public void setMappings(String cypherbet) throws IncorrectCypherbetException {
        if (cypherbet.length() != 26) {
            throw new IncorrectCypherbetException(cypherbet, name + "<Gear>.setMapping", "Incorrect Length");
        }
        char[] mapChars = cypherbet.toCharArray();
        for (char c : mapChars) {
            try {
                this.addMap(new Plug(this.mappings.size(), getValue(c)));
            } catch (MaxPopulationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public char passInputCharWithShiftsAndPrints(char c) {
        System.out.println("input char: " + c);
        System.out.println("input value: " + getValue(c));
        System.out.println("return value: " + passInputIntWithShifts(getValue(c)));
        System.out.println("return letter: " + getLetter(passInputIntWithShifts(getValue(c))));
        return getLetter(passInputIntWithShifts(getValue(c)));
    }

    public char passOutputCharWithShiftsAndPrints(char c) {
        System.out.println("output char: " + c);
        System.out.println("output value: " + getValue(c));
        System.out.println("return value: " + passOutputIntWithShifts(getValue(c)));
        System.out.println("return letter: " + getLetter(passOutputIntWithShifts(getValue(c))));
        return getLetter(passOutputIntWithShifts(getValue(c)));
    }

    public int passInputIntWithShiftsAndPrints(int input) {
        System.out.println("Gear " + name + " Passing Input");
        System.out.println("Pre Rotation Input: " + getLetter(input));
        input = (input + this.currentIndex) % 26;
        System.out.println("Rotated Input [" + currentIndex + "]: " + getLetter(input));
        int rtn = passInputInt(input);
        System.out.println("Pre Rotation Return: " + getLetter(rtn));
        rtn = (rtn + this.currentIndex) % 26;
        System.out.println("Rotated Return [" + currentIndex + "]: " + getLetter(rtn));
        return rtn;
    }

    public int passOutputIntWithShiftsAndPrints(int output) {
        System.out.println("Gear " + name + " Passing Output");
        System.out.println("Pre Rotation Output: " + getLetter(output));
        output = (output - currentIndex) % 26;
        if (output < 0) output += 26;
        System.out.println("Rotated Output[" + currentIndex + "]: " + getLetter(output));
        int rtn = passOutputInt(output);
        System.out.println("Pre Rotation Return: " + getLetter(rtn));
        rtn = (rtn - this.currentIndex) % 26;
        if (rtn < 0) rtn += 26;
        System.out.println("Rotated Return [" + currentIndex + "]: " + getLetter(rtn));
        return rtn;
    }

    public String toString() {
        String string = "Gear '" + this.name + "' mappings:\n";
        for (Plug p : mappings) {
            string += "    " + p.toString() + "\n";
        }
        string += "    Current Index: " + this.currentIndex;
        return string;
    }
}