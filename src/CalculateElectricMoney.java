
public class CalculateElectricMoney {

    private static int getElectricMoney(int totalPowerConsumptionIndicator) {
        int[] tierCost = {1728, 1786, 2074, 2612, 2919, 3015};

        int electricMoney;

        if (totalPowerConsumptionIndicator <= 50) {
            electricMoney = totalPowerConsumptionIndicator * tierCost[0];
        } else if (totalPowerConsumptionIndicator <= 100) {
            electricMoney = (totalPowerConsumptionIndicator - 50) * tierCost[1] + 50 * tierCost[1];
        } else if (totalPowerConsumptionIndicator <= 200) {
            electricMoney = (totalPowerConsumptionIndicator - 100) * tierCost[2] + 50 * tierCost[1] + 50 * tierCost[0];
        } else if (totalPowerConsumptionIndicator <= 300) {
            electricMoney = (totalPowerConsumptionIndicator - 200) * tierCost[3] + 100 * tierCost[2]
                    + 50 * tierCost[1] + 50 * tierCost[0];
        } else if (totalPowerConsumptionIndicator <= 400) {
            electricMoney = (totalPowerConsumptionIndicator - 300) * tierCost[4] + 100 * tierCost[3] + 100 * tierCost[2]
                    + 50 * tierCost[1] + 50 * tierCost[0];
        } else {
            electricMoney = (totalPowerConsumptionIndicator - 400) * tierCost[5] + 100 * tierCost[4]
                    + 100 * tierCost[3] + 100 * tierCost[2] + 50 * tierCost[1] + 50 * tierCost[0];
        }
        return electricMoney;
    }

    public static int getTotalMoney(int oldPowerConsumptionIndicator, int newPowerConsumptionIndicator) {

        int totalPowerConsumptionIndicator = newPowerConsumptionIndicator - oldPowerConsumptionIndicator;

        int electricMoney = getElectricMoney(totalPowerConsumptionIndicator);

        return (int) (electricMoney + Math.ceil(electricMoney * 0.1));
    }
}