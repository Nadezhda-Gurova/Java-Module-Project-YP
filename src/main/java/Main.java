import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = NumberOfPeopleChecker.check(scanner);
        Basket goods = new Basket();
        ProductAdder.input(scanner, goods);
        goods.showProducts(numberOfPersons);
    }
}
