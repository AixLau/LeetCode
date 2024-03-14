package com.greed;

public class _860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int money : bills)
            if (money == 10) {
                if (five < 1) return false;
                ten++;
                five--;
            } else if (money == 20)
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five > 2) five -= 3;
                else return false;
            else five++;
        return true;
    }
}
