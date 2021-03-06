package EnigmaMachine;

import static Util.CharUtil.getLetter;
import static Util.CharUtil.getValue;

public class EnigmaPart {
    public char inputChar;
    public char outputChar;
    public int inputInt;
    public int outputInt;

    public EnigmaPart() {
        setInput('A');
        setOutput('N');
    }

    public EnigmaPart(int input, int output) {
        setInput(input);
        setOutput(output);
    }
    public EnigmaPart(char input, char output) {
        setInput(input);
        setOutput(output);
    }
    public void setInput(int input) {
        this.inputInt = input;
        this.inputChar = getLetter(input);
    }
    public void setInput(char input) {
        this.inputChar = input;
        this.inputInt = getValue(input);
    }
    public void setOutput(int output) {
        this.outputInt = output;
        this.outputChar = getLetter(output);
    }
    public void setOutput(char output) {
        this.outputChar = output;
        this.outputInt = getValue(output);
    }
    public int getInputInt() { return this.inputInt; }
    public int getOutputInt() { return this.outputInt; }
    public char getInputChar() { return this.inputChar; }
    public char getOutputChar() { return  this.outputChar; }


//    public String toString() {
//        return "Input Char " + getInputInt() + " '" + getInputChar() + "' Output Char " + getOutputInt() + " '" + getOutputChar() + "'";
//    }

    public String toString() {
        return getInputChar() + ">" + getOutputChar();
    }
}
