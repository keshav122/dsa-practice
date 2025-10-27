package com.leetcode_practice.problems.medium;

class Bank {
    private long[] bal;
    private int len;

    public Bank(long[] balance) {
        this.len = balance.length;
        this.bal = balance.clone();
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 <= 0 || account2 <= 0 || account1 > len || account2 > len) {
            return false;
        }

        if (bal[account1 - 1] < money) {
            return false;
        } else {
            bal[account1 - 1] -= money;
            bal[account2 - 1] += money;
            return true;
        }
    }

    public boolean deposit(int account, long money) {
        if (account <= 0 || account > len)
            return false;
        bal[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account <= 0 || account > len || bal[account - 1] < money) {
            return false;
        } else {
            bal[account - 1] -= money;
            return true;
        }
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
public class SimpleBankSystem_2043 {

}
