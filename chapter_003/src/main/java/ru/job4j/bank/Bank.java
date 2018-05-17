package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Банк.
 */

public class Bank {
    /**
     * Коллекция пользователей с банковскими счетами.
     */
    private HashMap<User, List<Account>> accounts = new HashMap<>();

    /**
     * Добавить пользователя.
     *
     * @param user - пользователь.
     */
    public void addUser(User user) {
        this.accounts.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удалить пользователя.
     *
     * @param user - пользователь.
     */
    public void deleteUser(User user) {
        this.accounts.remove(user);
    }

    /**
     * Добавить счёт пользователю.
     *
     * @param passport - данные паспорта.
     * @param account  - счет.
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> list = this.getUserAccounts(passport);
        if (list.indexOf(account) < 0) {
            list.add(account);
        }
    }

    /**
     * Удалить счет у пользователя.
     *
     * @param passport - паспортные данные пользователя.
     * @param account - удаляемый счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.getUserAccounts(passport).remove(account);
    }

    /**
     * Получить список счетов для пользователя.
     *
     * @param passport - данные паспорта пользователя.
     * @return - список счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> pair : this.accounts.entrySet()) {
            if (passport.equals(pair.getKey().getPassport())) {
                result = pair.getValue();
                break;
            }
        }
        return result;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
     *
     * @param srcPassport - паспорт кто перечисляет деньги.
     * @param srcRequisite - реквизиты счета откуда перечисляются деньги.
     * @param dstPassport - паспорт кому перечисляются деньги.
     * @param dstRequisite - реквизиты счета куда перечисляются деньги.
     * @param amount - сумма денег.
     * @return - Истина, если перевод осуществлен, Ложь - если не нашли счета или денег на счете-источнике не хватает для перечисления.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = true;
        Account srcAccount = this.findAccountByRequisite(this.getUserAccounts(srcPassport), srcRequisite);
        Account dstAccount = this.findAccountByRequisite(this.getUserAccounts(dstPassport), dstRequisite);
        if (srcAccount == null || dstAccount == null || (srcAccount.getValue() - amount) < 0) {
            result = false;
        } else {
            srcAccount.setValue(srcAccount.getValue() - amount);
            dstAccount.setValue(dstAccount.getValue() + amount);
        }
        return result;
    }

    /**
     * Метод находит банковский счет пользователя реквизитам банковского счета.
     * @param list - список банковских счетов пользователя.
     * @param requisite - реквизиты банковского счета.
     * @return - счет, или null, если счет не найден.
     */
    public Account findAccountByRequisite(List<Account> list, String requisite) {
        Account result = null;
        for (Account account : list) {
            if (requisite.equals(account.getRequisites())) {
                result = account;
                break;
            }
        }
        return result;
    }
}
