package EnigmaMachine;

import Util.CharUtil;
import Util.StringUtil;
import java.util.Arrays;

import static Util.StringUtil.spaceSeperatedConcatenate;

public class EnigmaMachine {
    private PlugBoard plugBoard;
    private GearBox gearBox;
    public EnigmaMachine() {
        plugBoard = new PlugBoard("Default");
        gearBox = new GearBox();
    }
    public String[] encodeSentence(String[] plainSentence) {
        String head = plainSentence[0];
        if (plainSentence.length > 1 ) {
            String[] tail =  Arrays.copyOfRange(plainSentence, 1, plainSentence.length);
            return StringUtil.arrayPrefix(this.encodeSentence(tail), this.encode(head));
        } else {
            return new String[] { this.encode(head) };
        }
    }
    public String encode(String plainString) {
        if(plainString.contains(" ")) {
            // return encodeSentence(plainString.split(" "));
            return spaceSeperatedConcatenate(encodeSentence(plainString.split(" ")));
        }
        // System.out.println("plainString: " + plainString);
        return new String (encode(plainString.toUpperCase().toCharArray()));
    }
    public char[] encode(char[] plainCharArray) {
        // System.out.println("plainCharArray: " + new String(plainCharArray));
        char head = plainCharArray[0];
        if (plainCharArray.length > 1 ) {
            char[] tail =  Arrays.copyOfRange(plainCharArray, 1, plainCharArray.length);
            return CharUtil.arrayPrefix(this.encode(tail), this.encode(head));
        } else {
            return new char[] { this.encode(head) };
        }
    }
    public char encode(char plainChar) {
        // System.out.println("plainChar: " + plainChar);
        // return plugBoard.passInputChar(plainChar);
        // return gearBox.passChar(plugBoard.passInputChar(plainChar));
        return plugBoard.passOutputChar(gearBox.encodeChar(plugBoard.passInputChar(plainChar)));
    }
}
