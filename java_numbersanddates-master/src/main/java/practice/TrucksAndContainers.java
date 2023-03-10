package practice;

import java.util.Scanner;

public class TrucksAndContainers {
    public static void main(String[] args) {
        int truck = 0;
        int container = 0;
        int boxesInContainer = 27;
        int containersInTruck = 12;
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();

        if (boxes == 0) {

        } else if (boxes < boxesInContainer) {
            container++;
            truck++;
            System.out.println("Грузовик: " + truck + System.lineSeparator() +
                    "\tКонтейнер: " + container);
        } else if (boxes >= boxesInContainer) {
            container++;
            truck++;
            System.out.println("Грузовик: " + truck + System.lineSeparator() +
                    "\tКонтейнер: " + container);
        }

        for (int i = 1; i <= boxes; i++) {
            System.out.println("\t\tЯщик: " + i);

            if (i % (boxesInContainer * containersInTruck) == 0) {
                truck++;
                System.out.println("Грузовик: " + truck);
            }
            if (i % boxesInContainer == 0) {
                if (i != boxes) {
                    container++;
                    System.out.println("\tКонтейнер: " + container);
                }
            }
        }
        System.out.println("Необходимо:" + System.lineSeparator() +
                "грузовиков - " + truck + " шт." + System.lineSeparator() +
                "контейнеров - " + container + " шт.");

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t


        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
