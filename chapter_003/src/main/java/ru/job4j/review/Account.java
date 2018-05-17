//package com;
//
///**
// * Ревью:
// * 1. В методе public boolean equals(Object o)  - множественные return.
// * 2. В методе public boolean equals(Object o)  - пустые строчки. Убрать.
// * 3. if (o == null || getClass() != o.getClass()) - может, заменить на if (o instanceof Account) - действия делает те же, но короче.
// * 4. Насколько надо избавляться от сложения строк - через StringBuilder например - я не знаю... Нет у меня опыта в этом вопросе.
// */
//
//public class Account {
//
//    double values;
//    String reqs;
//
//    public Account(double values, String requisites) {
//        this.values = values;
//        this.reqs = requisites;
//    }
//
//    public double getValues() {
//        return this.values;
//    }
//
//
//    public String getReqs () {
//        return this.reqs;
//    }
//
//    boolean transfer(Account destination, double amount) {
//        boolean success = false;
//        if (amount > 0 && amount < this.values && destination != null) {
//            success = true;
//            this.values -= amount;
//            destination.values += amount;
//        }
//        return success;
//    }
//
//    public String toString() {
//        String otvet;
//        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
//        return otvet;
//    }
//
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//
//        Account account = (Account) o;
//
//        return this.reqs.equals(account.reqs);
//    }
//
//    public int hashCode() {
//        return this.reqs.hashCode();
//    }
//}