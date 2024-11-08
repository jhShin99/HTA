package ex09.enum_method;

public class EnumExample {

    public static void main(String[] args) {
        Day[] days = Day.values();

        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i] + " : " + days[i].ordinal());
        }

        System.out.println("====================");

        for (Day day : days) {
            System.out.println(day + " : " + day.ordinal());
        }
    }
}
