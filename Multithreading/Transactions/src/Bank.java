package src;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank {

    private ConcurrentMap<String, Account> accounts = new ConcurrentHashMap<>();
    private final Random random = new Random();


    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public synchronized void addAccount(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    public synchronized boolean isEnoughMoney(long fromAccountMoney, long amount) {
        return fromAccountMoney >= amount;
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        long fraudLimit = 50000;
        boolean check = false;
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        synchronized (toAccount) {
            synchronized (fromAccount) {
                if (isEnoughMoney(fromAccount.getMoney(), amount)) {
                    toAccount.setMoney(toAccount.getMoney() + amount);
                    fromAccount.setMoney(fromAccount.getMoney() - amount);
                    if (amount > fraudLimit) {
                        try {
                            check = isFraud(fromAccountNum, toAccountNum, amount);
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                        if (check) {
                            fromAccount.blockedAccount();
                            toAccount.blockedAccount();
                        } else {
                            toAccount.setMoney(toAccount.getMoney() + amount);
                            fromAccount.setMoney(fromAccount.getMoney() - amount);
                        }
                    }

                        }
                    }
                }
            }

            /**
             * TODO: реализовать метод. Возвращает остаток на счёте.
             */
            public long getBalance (String accountNum){
                return accounts.get(accountNum).getMoney();
            }

            public synchronized long getSumAllAccounts () {
                long SumAllAccounts = 0;
                for (ConcurrentMap.Entry<String, Account> item : accounts.entrySet()) {
                    SumAllAccounts += item.getValue().getMoney();
                }

                return SumAllAccounts;
            }
            public synchronized void setAccounts (ConcurrentHashMap < String, Account > accounts){
                this.accounts = accounts;
            }
        }