public class Basket {

    private static int count = 0;
    private String items = "";
    private int limit;
    private double totalWeight = 0;
    private static int totalPrice = 0;
    private static int totalCount = 0;
    private static double averagePrice = 0;
    private static double averageBasket = 0;


    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }


    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price, double weight) {
        add(name, price, 1, weight);
    }


    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }
        if (totalPrice + count * price >= limit) {
            error = true;
        }
        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        totalCount = totalCount + count;
        totalPrice = totalPrice + count * price;

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " руб. - " + weight + " кг.";

    }


}

    public static int getTotalPrice() {
        return totalPrice;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public static double getAveragePrice() {
        averagePrice = totalPrice / totalCount;
        return averagePrice;
    }

    public static double getAverageBasket() {
        averageBasket = totalPrice / Basket.count;
        return averageBasket;
    }


    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }


}