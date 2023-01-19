import java.util.Scanner;

public class ProductAdder {
    static void input(Scanner scanner, Basket basket) {
        while (true) {
            System.out.println("Введите название товара");
            String name = inputName(scanner);
            System.out.println("Введите стоимость товара");
            inputPrice(scanner, basket, name);

            System.out.println(
                    "Товар добавлен в корзину\n" +
                            "Хотите ли добавить еще один товар?\n" +
                            "Чтоб завершить процесс добавления товаров введите - завершить");
            if (scanner.nextLine().equalsIgnoreCase("завершить")) {
                break;
            }
        }
    }

    private static String inputName(Scanner scanner) {
        String name;
        while ((name = scanner.nextLine().trim()).isEmpty()) {
            System.out.println("Название введено неверно. Введите название товара");
        }
        return name;
    }

    private static void inputPrice(Scanner scanner, Basket basket, String name) {
        while (true) {
            try {
                double price = Double.parseDouble(scanner.nextLine());
                if (price > 0) {
                    basket.add(new Product(name, price));
                    break;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "Стоимость товара введена некорректно. " +
                                "Введите стоимость товара в формате: 10.45"
                );
            }
        }
    }
}