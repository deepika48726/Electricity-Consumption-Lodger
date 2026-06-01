package model;

public class ElectricityRecord {

    private String houseId;
    private int unitsConsumed;
    private String month;

    public ElectricityRecord(String houseId, int unitsConsumed, String month) {
        this.houseId = houseId;
        this.unitsConsumed = unitsConsumed;
        this.month = month;
    }

    public String getHouseId() {
        return houseId;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public String getMonth() {
        return month;
    }

    public void displayRecord() {
        System.out.println("House ID: " + houseId +
                " | Month: " + month +
                " | Units Consumed: " + unitsConsumed);
    }
}