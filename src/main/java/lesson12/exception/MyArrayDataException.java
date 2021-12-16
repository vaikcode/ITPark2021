package lesson12.exception;

public class MyArrayDataException extends RuntimeException {

    private int m;
    private int n;
    private String string;
    String[][] strings;

    public MyArrayDataException(String[][] strings) {
        this.strings = strings;
    }

    public MyArrayDataException(String[][] strings, String message) {
        super(message);
        this.strings = strings;
    }

    public MyArrayDataException(String[][] strings, int m, int n, String message) {
        super(message);
        this.strings = strings;
        this.string = strings[m][n];
        this.m = m;
        this.n = n;
    }

    public int getLengthM(){
        return strings.length;
    }

    public int getLengthN(){
        return strings[0].length;
    }

    public int getM(){
        return this.m;
    }

    public int getN(){
        return this.n;
    }

    public String getString() {
        return this.string;
    }
}
