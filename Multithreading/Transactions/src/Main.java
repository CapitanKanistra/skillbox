package src;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;


public class Main {


    private static final String someClientAccount = RandomStringUtils.randomNumeric(15);

    private static final long amount = (long)(Math.random() * (99999 - 10000) + 10000) + 50000;
    private static final long transferMoney = (long)(Math.random() * (99999 - 10000) + 10000);

    public static void main(String[] args) {

        Bank bank = new Bank();
        Account client = new Account(someClientAccount, amount);
        Account client2 = new Account(someClientAccount, amount);

        bank.addAccount(client);
        bank.addAccount(client2);

        System.out.println("Сумма всех счетов: " + bank.getSumAllAccounts() + " руб.");

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(
                    new Thread(() -> {
                        System.out.println("Старт поток перевода");
                        for (int t = 0; t < 1000; t++) {
                            try {
                                bank.transfer(client.getAccNumber(), client2.getAccNumber(), transferMoney);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Стоп поток перевода ");
                        System.out.println("Сумма всех счетов: " + bank.getSumAllAccounts() + " руб.");

                    })
            );
        }

        threadList.forEach(Thread::start);
    }

}
