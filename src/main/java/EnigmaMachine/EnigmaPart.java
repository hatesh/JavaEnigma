package EnigmaMachine;

public class EnigmaPart {
    public char inputChar;
    public char outputChar;
    public int inputInt;
    public int outputInt;

    public EnigmaPart() {
        inputChar = 'A';
        outputChar = 'N';
        inputInt = 0;
        outputInt = 13;
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
    public int getValue(char c) { return Character.getNumericValue(c) - 65; }
    public char getLetter(int i) { return (char) (i + 65); }
}
