package EnigmaMachine;

import Util.CharUtil;

import java.util.Arrays;

import static Util.CharUtil.getLetter;

public class EnigmaMachine {
    private PlugBoard plugBoard;
    public EnigmaMachine() {
        plugBoard = new PlugBoard();
    }
    public String encode(String plainString) {
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
        return plugBoard.passChar(plainChar);
    }
}
