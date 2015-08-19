package ninja.eivind.birthdaysorter;

import java.io.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Collector implements AutoCloseable {

    private final BufferedReader bufferedReader;

    public Collector(InputStream inputStream) throws UnsupportedEncodingException {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    }

    public void close() throws Exception {
        bufferedReader.close();
    }

    public Person read() throws IOException {
        System.out.print("Please enter name: ");
        String name = bufferedReader.readLine();
        LocalDate localDate = readDate();

        return new Person(name, localDate);
    }

    private LocalDate readDate() {
        MonthDay monthDay = readMonthDay();
        Year year = readYear();

        try {
            return LocalDate.of(year.getValue(), monthDay.getMonthValue(), monthDay.getDayOfMonth());
        } catch(DateTimeException e) {
            System.out.println("Sorry, that date just isn't possible. Try again.");
            return readDate();
        }
    }

    private MonthDay readMonthDay() {
        int day = readDay();
        Month month = readMonth();

        try {
            return MonthDay.of(month, day);
        } catch(DateTimeException e) {
            System.out.println(month.name() + " does not have a day " + day + ". Please try again.");
            return readMonthDay();
        }
    }

    private Month readMonth() {
        final int min = 1;
        final int max = 12;

        int input;
        do {
            input = readInteger("month", min, max);
        } while (!checkInput(input, min, max));
        return Month.of(input);
    }

    private int readDay() {
        final int min = 1;
        final int max = 31;

        int input;
        do {
            input = readInteger("day of month", min, max);
        } while (!checkInput(input, min, max));
        return input;
    }

    private Year readYear() {
        final int min = 1950;
        final int max = Year.now().minus(18, ChronoUnit.YEARS).getValue();
        int input;
        do {

            input = readInteger("year", min, max);
        } while (!checkInput(input, min, max));
        return Year.of(input);
    }

    private boolean checkInput(final int input, int min, int max) {
        if (input < min || input > max) {
            System.out.println("I doubt it. Try again");
            return false;
        } else {
            return true;
        }
    }

    private Integer readInteger(String kind, int min, int max) {
        String input;
        try {
            System.out.print("Please input " + kind + " between " + min + " and " + max + ": ");
            input = bufferedReader.readLine();
            return Integer.parseInt(input);
        } catch (IOException e) {
            System.out.println("Could not understand answer!");
            return readInteger(kind, min, max);
        }
    }

    public boolean hasMore() throws IOException {
        System.out.print("Do you want to continue? (yes/no): ");
        String input = bufferedReader.readLine();
        switch (input) {
            case "y":
            case "yes":
                return true;
            case "n":
            case "no":
                return false;
            default:
                System.out.println("Could not understand reply. Please type yes or no.");
                return hasMore();
        }
    }
}
