package app;

import service.LoggerService;
import service.SummaryService;
import model.ElectricityRecord;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoggerService logger = new LoggerService(50);
        SummaryService summary = new SummaryService();

        int choice;

        do {

            System.out.println("\n===== Electricity Consumption Logger =====");
            System.out.println("1. Add Record");
            System.out.println("2. View Records");
            System.out.println("3. Total Consumption");
            System.out.println("4. Average Consumption");
            System.out.println("5. Highest Consumption");
            System.out.println("6. Exit");

            // handle invalid input for menu choice
            try {
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // clear buffer
                choice = 0;
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter House ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Month (1-12): ");
                    String month = sc.nextLine();

                    // validate month input
                    if (!month.matches("1[0-2]|[1-9]")) {
                        System.out.println("Invalid month! Please enter 1 to 12.");
                        break;
                    }

                    int units;

                    // handle invalid input for units
                    try {
                        System.out.print("Enter Units Consumed: ");
                        units = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter a number.");
                        sc.nextLine(); // clear buffer
                        break;
                    }

                    ElectricityRecord record =
                            new ElectricityRecord(id, units, month);

                    logger.addRecord(record);

                    System.out.println("Record added successfully!");
                    break;

                case 2:
                    logger.displayRecords();
                    break;

                case 3:
                    System.out.println("Total Consumption: "
                            + summary.totalConsumption(logger.getRecords(), logger.getCount()));
                    break;

                case 4:
                    System.out.println("Average Consumption: "
                            + summary.averageConsumption(logger.getRecords(), logger.getCount()));
                    break;

                case 5:
                    System.out.println("Highest Consumption: "
                            + summary.highestConsumption(logger.getRecords(), logger.getCount()));
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}