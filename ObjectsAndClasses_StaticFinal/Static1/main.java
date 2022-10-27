public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 50, 0.9);
        basket.add("Дыня", 100, 5);
        basket.add("Лопата", 300, 3, 10);
        Basket basket1 = new Basket();
        basket1.add("Хлеб", 20, 2, 0.8);
        basket.print("Содержимое корзины");
        basket1.print("\n" + "Содержимое корзины №2");
        System.out.println("\n" + "Общая цена:" + Basket.getTotalPrice() + "\n" + "Общее Кол-во товаров:" + Basket.getTotalCount()
                + "\n" + "Средняя цена товара:" + Basket.getAveragePrice() + "\n" + "Средняя стоимость корзины:" + Basket.getAverageBasket());
    }
}