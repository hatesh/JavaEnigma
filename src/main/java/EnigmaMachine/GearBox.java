package EnigmaMachine;

import java.util.ArrayList;

import static Util.CharUtil.getLetter;
import static Util.CharUtil.getValue;

public class GearBox {
    private ArrayList<Gear> gears = new ArrayList<>();
    private Gear reflector;
    private int inputCount;
    public GearBox() {
        gears.add(new Gear("IC", "DMTWSILRUYQNKFEJCAZBPGXOHV"));
        gears.add(new Gear("IIC", "HQZGPJTMOBLNCIFDYAWVEUSRKX"));
        gears.add(new Gear("IIIC", "UQNTLSZFMREHDPXKIBVYGJCWOA"));
        reflector = new Gear("Reflector A","EJMZALYXVBWFCRQUONTSPIKHGD");
        inputCount = 0;
    }
    public GearBox(Gear gear1, Gear gear2, Gear gear3, Gear reflector) {
        this.gears.clear();
        this.gears.add(gear1);
        this.gears.add(gear2);
        this.gears.add(gear3);
        this.reflector = reflector;
        inputCount = 0;
    }
    public int passInputInt(int input) {
        return getValue(this.passInputChar(getLetter(input)));
    }

    public char passInputChar(char input) {
        char temp = input;
        for (Gear g : gears) temp = g.passInputCharWithShifts(temp);
        return temp;
    }

    public char reflectInputChar(char input) {
        // return reflector.passInputChar(input);
        return reflector.passInputCharWithShifts(input);
    }

    public char passOutputChar(char output) {
        char temp = output;
        for (int i = gears.size(); i > 0; i--) temp = gears.get(i - 1).passOutputCharWithShifts(temp);
        return temp;
    }

    public char encodeChar(char input) {
        return ( passOutputChar( reflectInputChar( passInputChar( input ))));
    }

    public char encodeCharWithShift(char input) {
        updateRotations();
//         System.out.println(this.toString());
        return encodeChar(input);
    }

    public int encodeInt(int input) {
        return getValue(encodeChar(getLetter(input)));
    }

    public void updateRotations() {
        this.inputCount++;
        for(int gearNumber = 0; gearNumber < gears.size(); gearNumber++) {
            if (gearNumber == 0) {
                gears.get(gearNumber).setCurrentIndex(this.inputCount);
            } else if (this.inputCount % (26 * gearNumber) == 0) {
                gears.get(gearNumber).updateCurrentIndex();
            }
        }
    }

    public void clearGears() { this.gears.clear(); }

    public void addGear(Gear gear) { this.gears.add(gear); }

    public String toString() {
        String str = "Geabox Gears:\n";
        for (Gear g : gears) str += "    " + g.toString() + "\n";
        str += "     " + reflector.toString() + "\n";
        str += "     Input Count: " + inputCount;
        return str;
    }
}
