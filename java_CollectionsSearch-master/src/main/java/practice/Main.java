package practice;

import java.util.*;

public class Main {
    private static String number = "Х666НХ159";
    private static List list = CoolNumbers.generateCoolNumbers();

    public static void main(String[] args) {
        list();
        arrayList();
        hasSet();
        treeSet();
    }

    static void list() {
        long time1 = System.nanoTime();
        String search = CoolNumbers.bruteForceSearchInList(list, number) ? "Номер найден" : "Номер не найден";
        long time2 = System.nanoTime();
        long time = time2 - time1;
        System.out.println("Поиск перебором: " + search + ", поиск занял: " + time);
    }

    static void arrayList() {

        List<String> sortingNumbers = new ArrayList<>(list);
        Collections.sort(sortingNumbers);
        long time1 = System.nanoTime();
        String search1 = CoolNumbers.binarySearchInList(sortingNumbers, number) ? "Номер найден" : "Номер не найден";
        long time2 = System.nanoTime();
        long time = time2 - time1;
        System.out.println("Бинарный поиск: " + search1 + ", поиск занял: " + time);
    }

    static void hasSet() {
        HashSet<String> hashSet = new HashSet<>(list);
        long time1 = System.nanoTime();
        String search2 = CoolNumbers.searchInHashSet(hashSet, number) ? "Номер найден" : "Номер не найден";
        long time2 = System.nanoTime();
        long time = time2 - time1;
        System.out.println("Поиск в HasSet: " + search2 + ", поиск занял: " + time);

    }

    static void treeSet() {
        TreeSet<String> treeSet = new TreeSet<>(list);
        long time1 = System.nanoTime();
        String search3 = CoolNumbers.searchInTreeSet(treeSet, number) ? "Номер найден" : "Номер не найден";
        long time2 = System.nanoTime();
        long time = time2 - time1;
        System.out.println("Поиск в TreeSet: " + search3 + ", поиск занял: " + time);

    }
}
