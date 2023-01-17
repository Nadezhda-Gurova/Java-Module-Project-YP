import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }


    static void inputProduct(Scanner scanner, Basket basket) {
        while (true) {
            System.out.println("Введите название товара");
            String name = scanner.nextLine();
            System.out.println("Введите стоимость товара");
            double price = Double.parseDouble(scanner.nextLine());
            basket.add(new Product(name, price));
            System.out.println(
                    "Товар добавлен в корзину\n" +
                            "Хотите ли добавить еще один товар?\n" +
                            "Чтоб завершить процесс добавления товаров введите - завершить");
            if (scanner.nextLine().equalsIgnoreCase("завершить")) {
                break;
            }
        }
    }


    static class Basket {
        List<String> products = new ArrayList<>();
        double sum = 0.0;

        String inclineRubEnding(String rub) {
            int indexOf = rub.indexOf(".");
            char lastChar = rub.charAt(indexOf - 1);
            if (lastChar == '1') {
                return "рубль";
            } else if ("234".indexOf(lastChar) != -1) {
                return "рубль";
            } else return "рублей";

        }

        void showProducts(int numberOfPersons) {
            System.out.println("Добавленные товары:");
            for (String product : products) {
                System.out.println(product);
            }
            String sumPerPerson = String.format("%.2f", (sum / numberOfPersons));
            System.out.println(sumPerPerson + " " + inclineRubEnding(sumPerPerson));
        }

        void add(Product product) {
            products.add(product.name);
            sum += product.price;
        }
    }


    public static int checkNumberOfPeopleIsValid(Scanner scanner) {
        while (true) {
            System.out.println("На сколько человек необходимо разделить счёт?");
            int num = 0;
            try {
                num = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {

            }
            if (num > 1) {
                return num;
            } else {
                System.out.println("Значение некорректное, ввести корректное количество гостей");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = checkNumberOfPeopleIsValid(scanner);
        Basket goods = new Basket();
        inputProduct(scanner, goods);
        goods.showProducts(numberOfPersons);
    }
}
