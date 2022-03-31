package com.scd.exercise.y2022.m3;

/**
 * @author James
 */
public class Code2043 {

    class Bank {

        private long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (!isAccountExists(account1) || !isAccountExists(account2)) {
                return false;
            }
            long account1Money = balance[account1 - 1];
            if (account1Money >= money) {
                balance[account1 - 1] = balance[account1 - 1] - money;
                balance[account2 - 1] = balance[account2 - 1] + money;
                return true;
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if (!isAccountExists(account)) {
                return false;
            }
            balance[account - 1] = balance[account - 1]  + money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (!isAccountExists(account)) {
                return false;
            }
            if (balance[account - 1] >= money) {
                balance[account - 1] = balance[account - 1]  - money;
                return true;
            }
            return false;
        }

        private boolean isAccountExists(int account) {
            if (account > balance.length) {
                return false;
            }
            return true;
        }
    }
}
