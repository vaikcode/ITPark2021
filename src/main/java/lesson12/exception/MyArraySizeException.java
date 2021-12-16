package lesson12.exception;

public class MyArraySizeException extends RuntimeException {

    String[][] strings;

    public MyArraySizeException(String[][] strings) {
        this.strings = strings;
    }

    public MyArraySizeException(String[][] strings, String message) {
        super(message);
        this.strings = strings;
    }

    public int getLengthM(){
        return strings.length;
    }

    public int getLengthN(){
        return strings[0].length;
    }
}
