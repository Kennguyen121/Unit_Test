package CalculateElectricMoneyTest.src.main.iuh.fit.se;

import java.util.InputMismatchException;

public class CalculateElectricMoney {

    public static int getElectricMoney(int total) {
        int[] tierCost = {1728, 1786, 2074, 2612, 2919, 3015};

        int money;

        if (total <= 50) {
            money = total * tierCost[0];
        } else if (total <= 100) {
            money = (total - 50) * tierCost[1] + 50 * tierCost[1];
        } else if (total <= 200) {
            money = (total - 100) * tierCost[2] + 50 * tierCost[1] + 50 * tierCost[0];
        } else if (total <= 300) {
            money = (total - 200) * tierCost[3] + 100 * tierCost[2]
                    + 50 * tierCost[1] + 50 * tierCost[0];
        } else if (total <= 400) {
            money = (total - 300) * tierCost[4] + 100 * tierCost[3] + 100 * tierCost[2]
                    + 50 * tierCost[1] + 50 * tierCost[0];
        } else {
            money = (total - 400) * tierCost[5] + 100 * tierCost[4]
                    + 100 * tierCost[3] + 100 * tierCost[2] + 50 * tierCost[1] + 50 * tierCost[0];
        }
        return money;
    }

    public static int getTotalMoney(int oldElec, int newElec) {

        if (newElec < oldElec || newElec < 0 || oldElec < 0)
            throw new InputMismatchException("Cannot calculate the electric money!");

        int total = newElec - oldElec;

        int money = getElectricMoney(total);

        return (int) (money + Math.ceil(money * 0.1));
    }
}