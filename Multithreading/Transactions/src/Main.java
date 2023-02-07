package src;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;


public class Main {


    private static final String someClientAccount = RandomStringUtils.randomNumeric(15);

    private static final long amount = (long)(Math.random() * (99999 - 10000) + 10000) + 50000;
    private static final long transferMoney = (long)(Math.random() * (99999 - 10000) + 10000);

    public static void main(String[] args) {

        Bank bank = new Bank();
        Account client = new Account(someClientAccount, amount);
        Account client2 = new Account(someClientAccount, amount);

        Bank bank2 = new Bank();
        Account client3 = new Account(someClientAccount, amount);
        Account client4 = new Account(someClientAccount, amount);

        Bank bank3 = new Bank();
        Account client5 = new Account(someClientAccount, amount);
        Account client6 = new Account(someClientAccount, amount);

        bank.addAccount(client);
        bank.addAccount(client2);
        bank2.addAccount(client3);
        bank2.addAccount(client4);
        bank3.addAccount(client5);
        bank3.addAccount(client6);

        System.out.println("Сумма всех счетов: " + bank.getSumAllAccounts() + " руб.");
        System.out.println("Сумма всех счетов: " + bank2.getSumAllAccounts() + " руб.");

        ArrayList<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(
                    new Thread(() -> {
                        System.out.println("Старт поток перевода");
                        for (int t = 0; t < 50; t++) {
                            try {
                                bank.transfer(client.getAccNumber(), client2.getAccNumber(), transferMoney);
                                bank2.transfer(client3.getAccNumber(), client4.getAccNumber(), transferMoney);
                                bank3.transfer(client5.getAccNumber(), client6.getAccNumber(), transferMoney);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Стоп поток перевода ");
                        System.out.println("Сумма всех счетов: " + bank.getSumAllAccounts() + " руб.");
                        System.out.println("Сумма всех счетов: " + bank2.getSumAllAccounts() + " руб.");
                        System.out.println("Сумма всех счетов: " + bank3.getSumAllAccounts() + " руб.");

                    })
            );
        }

        threadList.forEach(Thread::start);
    }

}
