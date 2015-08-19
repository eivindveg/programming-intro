package ninja.eivind.birthdaysorter;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {

    public static void main(String[] args) throws UnsupportedEncodingException {
        List<Person> list = getPersons();
        printUpcomingBirthdays(list);
    }

    private static List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        try(Collector collector = new Collector(System.in)) {
            do {
                Person person = collector.read();
                list.add(person);
            } while(collector.hasMore());
        } catch (Exception e) {
            System.out.println("We've encountered a problem: " + e.getMessage());
            System.out.println("The application will now exit after printing the values we successfully collected.");
        }
        return list;
    }

    private static void printUpcomingBirthdays(final List<Person> list) {
        list.stream()
                .sorted(getPersonComparator())
                .forEach(person -> {
                    LocalDate birthday = person.getBirthday();
                    LocalDate now = LocalDate.now();
                    LocalDate nextBirthDay = getNextBirthday(birthday, now);
                    long months = ChronoUnit.MONTHS.between(now, nextBirthDay);
                    long days = ChronoUnit.DAYS.between(now, nextBirthDay.minus(months, ChronoUnit.MONTHS));
                    System.out.println(person.getName() + "'s birthday is in " + months + " months and " + days + " days");
                });
    }

    private static LocalDate getNextBirthday(final LocalDate birthday, final LocalDate after) {
        LocalDate nextBirthDay = LocalDate.of(
                Year.now().getValue(), birthday.getMonth(), birthday.getDayOfMonth()
        );
        if(nextBirthDay.isBefore(after)) {
            nextBirthDay = nextBirthDay.plus(1, ChronoUnit.YEARS);
        }
        return nextBirthDay;
    }

    private static Comparator<Person> getPersonComparator() {
        LocalDate now = LocalDate.now();
        return (o1, o2) -> getNextBirthday(o1.getBirthday(), now)
                .compareTo(getNextBirthday(o2.getBirthday(), now));
    }
}
