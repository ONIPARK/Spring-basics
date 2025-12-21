package hello.core.singleton;

public class StatefulService {

    private int price; //状態を維持するフィールド

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //ここが問題
    }

    public int getPrice() {
        return price;
    }
}
