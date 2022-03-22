package samples;

import java.util.Date;

public class TimeSample {

    public static void main(String[] args) {

        long millisStart;
        long millisStop;
        Date date = new Date();

        millisStart = date.getTime();
        System.out.println(millisStart);

        millisStop = date.getTime();
        System.out.println(millisStop);
    }
}
