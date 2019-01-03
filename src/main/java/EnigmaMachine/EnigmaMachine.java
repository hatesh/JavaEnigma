package EnigmaMachine;

import Util.CharUtil;
import Util.StringUtil;
import java.util.Arrays;

import static Util.StringUtil.spaceSeperatedConcatenate;

public class EnigmaMachine {
    private PlugBoard plugBoard;
    private GearBox gearBox;
    public EnigmaMachine() {
        this(new PlugBoard("Default"), new GearBox());
    }
    public EnigmaMachine(PlugBoard plugBoard) {
        this(plugBoard, new GearBox());
    }
    public EnigmaMachine(GearBox gearBox) {
        this(new PlugBoard("Default"), gearBox);
    }
    public EnigmaMachine(PlugBoard plugBoard, GearBox gearBox) {
        this.setPlugBoard(plugBoard);
        this.setGearBox(gearBox);
    }
    public String[] encode(String[] plainSentence) {
        String head = plainSentence[0];
        if (plainSentence.length > 1 ) {
            String[] tail =  Arrays.copyOfRange(plainSentence, 1, plainSentence.length);
            return StringUtil.arrayPrefix(this.encode(tail), this.encode(head));
        } else {
            return new String[] { this.encode(head) };
        }
    }
    public String encode(String plainString) {
        if(plainString.contains(" ")) return spaceSeperatedConcatenate(encode(plainString.split(" ")));
//         System.out.println("plainString: " + plainString);
        return new String (encode(plainString.toUpperCase().toCharArray()));
    }
    public char[] encode(char[] plainCharArray) {
//         System.out.println("plainCharArray: " + new String(plainCharArray));
        char head = plainCharArray[0];
        if (plainCharArray.length > 1 ) {
            char[] tail =  Arrays.copyOfRange(plainCharArray, 1, plainCharArray.length);
            return CharUtil.arrayPrefix(this.encode(tail), this.encode(head));
        } else {
            return new char[] { this.encode(head) };
        }
    }
    public char encode(char plainChar) {
//         System.out.println("plainChar: " + plainChar);
//        return plugBoard.passOutputChar(gearBox.encodeCharWithShift(plugBoard.passChar(plainChar)));
        char intoPlugBoard = plugBoard.passChar(plainChar);
        char outGearBox = gearBox.encodeCharWithShift(intoPlugBoard);
        char outPlugBoard = plugBoard.passChar(outGearBox);
//        System.out.println(">" + plainChar + ">" + intoPlugBoard + ">" + outGearBox + ">" + outPlugBoard);
        return outPlugBoard;
    }

    public PlugBoard getPlugBoard() { return this.plugBoard; }

    public void setPlugBoard(PlugBoard plugBoard) { this.plugBoard = plugBoard; }

    public GearBox getGearBox() { return this.gearBox; }

    public void setGearBox(GearBox gearBox) { this.gearBox = gearBox; }

    public String toString() {
        return plugBoard.toString()  + "\n" + gearBox.toString() + "\n";
    }
}
