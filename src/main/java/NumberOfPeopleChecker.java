import java.util.Scanner;

class NumberOfPeopleChecker {
    public static int check(Scanner scanner) {
        while (true) {
            System.out.println("На сколько человек необходимо разделить счёт?");
            int num = 0;
            try {
                num = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите количество гостей");
            }
            if (num > 1) {
                return num;
            } else {
                System.out.println("Значение некорректное, ввести корректное количество гостей");
            }
        }
    }
}