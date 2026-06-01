package service;

import model.ElectricityRecord;

// Parent class for inheritance
class BaseService {
    // can hold common methods in future
}

public class SummaryService extends BaseService {

    public int totalConsumption(ElectricityRecord[] records, int count) {
        int total = 0;

        try {
            for (int i = 0; i < count; i++) {
                total += records[i].getUnitsConsumed();
            }
        } catch (Exception e) {
            System.out.println("Error in totalConsumption: " + e.getMessage());
        }

        return total;
    }

    public double averageConsumption(ElectricityRecord[] records, int count) {
        try {
            if (count == 0) return 0;

            return (double) totalConsumption(records, count) / count;
        } catch (Exception e) {
            System.out.println("Error in averageConsumption: " + e.getMessage());
            return 0;
        }
    }

    public int highestConsumption(ElectricityRecord[] records, int count) {
        int max = 0;

        try {
            for (int i = 0; i < count; i++) {
                if (records[i].getUnitsConsumed() > max) {
                    max = records[i].getUnitsConsumed();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in highestConsumption: " + e.getMessage());
        }

        return max;
    }
}