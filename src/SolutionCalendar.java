import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar cal =  Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1); // MALDITO MES ZERO!!!!
        cal.set(Calendar.DAY_OF_MONTH, day);
        System.out.println(cal.toString());
        String d = "";
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY: d = "SUNDAY"; break;
            case Calendar.MONDAY: d = "MONDAY"; break;
            case Calendar.TUESDAY: d = "TUESDAY"; break;
            case Calendar.WEDNESDAY: d = "WEDNESDAY"; break;
            case Calendar.THURSDAY: d = "THURSDAY"; break;
            case Calendar.FRIDAY: d = "FRIDAY"; break;
            case Calendar.SATURDAY: d = "SATURDAY"; break;
        }
        return d;
    }

}

public class SolutionCalendar {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

//        bufferedWriter.write(res);
//        bufferedWriter.newLine();
        System.out.println(res);

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
