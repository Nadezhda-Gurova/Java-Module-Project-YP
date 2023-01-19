import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Basket {
    List<String> products = new ArrayList<>();
    double sum = 0.0;

    String inclineRubleEnding(int ruble) {
        int remainder = ruble % 100;
        if (remainder >= 11 && remainder <= 14) {
            return "рублей";
        }
        remainder %= 10;
        if (remainder == 1) {
            return "рубль";
        } else if (remainder >= 2 && remainder <= 4) {
            return "рубля";
        }
        return "рублей";
    }

    void showProducts(int numberOfPersons) {
        System.out.println("Добавленные товары:");
        for (String product : products) {
            System.out.println(product);
        }
        System.out.println(String.format(Locale.US, "%.2f", sum / numberOfPersons)
                + " " + inclineRubleEnding((int) Math.floor(sum / numberOfPersons)));
    }

    void add(Product product) {
        products.add(product.name);
        sum += product.price;
    }
}
