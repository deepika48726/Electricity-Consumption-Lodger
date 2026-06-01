package service;

import model.ElectricityRecord;

// Interface
interface LoggerInterface {
    void addRecord(ElectricityRecord record);
    void displayRecords();
    ElectricityRecord[] getRecords();
    int getCount();
}

public class LoggerService implements LoggerInterface {

    private ElectricityRecord[] records;
    private int count;

    public LoggerService(int size) {
        records = new ElectricityRecord[size];
        count = 0;
    }

    public void addRecord(ElectricityRecord record) {
        try {
            if (count < records.length) {
                records[count] = record;
                count++;
            } else {
                System.out.println("Storage full!");
            }
        } catch (Exception e) {
            System.out.println("Error in addRecord: " + e.getMessage());
        }
    }

    public void displayRecords() {
        try {
            if (count == 0) {
                System.out.println("No records available.");
                return;
            }

            for (int i = 0; i < count; i++) {
                records[i].displayRecord();
            }
        } catch (Exception e) {
            System.out.println("Error in displayRecords: " + e.getMessage());
        }
    }

    public ElectricityRecord[] getRecords() {
        try {
            return records;
        } catch (Exception e) {
            System.out.println("Error in getRecords: " + e.getMessage());
            return null;
        }
    }

    public int getCount() {
        try {
            return count;
        } catch (Exception e) {
            System.out.println("Error in getCount: " + e.getMessage());
            return 0;
        }
    }
}