package EnigmaMachine;

import java.util.ArrayList;

import static Util.CharUtil.getLetter;
import static Util.CharUtil.getValue;

public class GearBox {
    private ArrayList<Gear> gears = new ArrayList<>();
    private int inputCount;
    public GearBox() {
        gears.add(new Gear("IC", "DMTWSILRUYQNKFEJCAZBPGXOHV"));
        gears.add(new Gear("IIC", "HQZGPJTMOBLNCIFDYAWVEUSRKX"));
        gears.add(new Gear("IIIC", "UQNTLSZFMREHDPXKIBVYGJCWOA"));
        inputCount = 0;
    }
    public char passChar(char input) {
        updateRotations();
        char temp = input;
        for (Gear g : gears) {
            temp = g.shiftAndPassChar(temp);
        }
        this.inputCount++;
        return temp;
    }
    public int passInt(int input) {
        return getValue(this.passChar(getLetter(input)));
    }
    public void updateRotations() {
        this.inputCount++;
        for(int gearNumber = 0; gearNumber < gears.size(); gearNumber++) {
            if (gearNumber == 0) {
                gears.get(gearNumber).setCurrentIndex(this.inputCount);
            } else if (this.inputCount % (26 * gearNumber) == 0) {
                gears.get(gearNumber).updateCurrentIndex();
            }
            System.out.println(gears.get(gearNumber).toString());
        }

    }
}
