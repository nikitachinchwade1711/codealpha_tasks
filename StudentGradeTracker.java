import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Requirement: Use ArrayList to manage data
        ArrayList<Double> grades = new ArrayList<Double>();
        
        System.out.println("--- CodeAlpha Student Grade Tracker ---");
        System.out.println("Enter student grades (Enter -1 to finish):");

        // Requirement: Input and manage student grades
        while (true) {
            System.out.print("Enter grade: ");
            if (scanner.hasNextDouble()) {
                double grade = scanner.nextDouble();
                if (grade == -1) break;
                
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Invalid input. Please enter a grade between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            displayReport(grades);
        }
        scanner.close();
    }

    // Requirement: Calculate average, highest, and lowest scores
    public static void displayReport(ArrayList<Double> grades) {
        double sum = 0;
        double highest = Collections.max(grades);
        double lowest = Collections.min(grades);

        for (double g : grades) {
            sum += g;
        }
        double average = sum / grades.size();

        // Requirement: Display a summary report
        System.out.println("\n--- Grade Summary Report ---");
        System.out.println("Total Students: " + grades.size());
        System.out.printf("Average Score:  %.2f\n", average);
        System.out.println("Highest Grade:  " + highest);
        System.out.println("Lowest Grade:   " + lowest);
    }
}