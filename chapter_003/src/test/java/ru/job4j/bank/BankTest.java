package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Bank.
 */
public class BankTest {
    @Test
    public void whenTransferMoneySuccessful() {
        Bank bank = new Bank();
        bank.addUser(new User("Иванов", "паспорт 001001"));
        bank.addAccountToUser("паспорт 001001", new Account(100, "р/с Иванов 00001"));
        bank.addUser(new User("Петров", "паспорт 002002"));
        bank.addAccountToUser("паспорт 002002", new Account(888, "р/с Петров 00002"));
        bank.transferMoney("паспорт 001001", "р/с Иванов 00001", "паспорт 002002", "р/с Петров 00002", 99);
        double srcResult = bank.findAccountByRequisite(bank.getUserAccounts("паспорт 001001"), "р/с Иванов 00001").getValue();
        double dstResult = bank.findAccountByRequisite(bank.getUserAccounts("паспорт 002002"), "р/с Петров 00002").getValue();
        double srcExpected = 1;
        double dstExpected = 987;
        assertThat(true, is((srcResult == srcExpected) && (dstResult == dstExpected)));
    }

    @Test
    public void whenTransferMoneyFail() {
        Bank bank = new Bank();
        bank.addUser(new User("Иванов", "паспорт 001001"));
        bank.addAccountToUser("паспорт 001001", new Account(100, "р/с Иванов 00001"));
        bank.addUser(new User("Петров", "паспорт 002002"));
        bank.addAccountToUser("паспорт 002002", new Account(888, "р/с Петров 00002"));
        boolean result = bank.transferMoney("паспорт 001001", "левый счет", "паспорт 002002", "р/с Петров 00002", 99);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddAccountToUserFail() {
        Bank bank = new Bank();
        bank.addUser(new User("Иванов", "паспорт 001001"));
        bank.addAccountToUser("неправильный паспорт", new Account(100, "р/с Иванов 00001"));
        int result = bank.getUserAccounts("паспорт 001001").size();
        int expected = 0;
        assertThat(result, is(expected));
    }
}