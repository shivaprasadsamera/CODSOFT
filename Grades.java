package CODSOFT;
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfSubjects = 6;
        int totalMarks = 0;
        int[] marks = new int[numOfSubjects];
        String[] subjects = { "Java", "Angular", "NodeJS", "SpringBoot", "JavaScript", "Web Technologies" };
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Enter marks obtained in " + subjects[i] + ": ");
            marks[i] = input.nextInt();
            totalMarks += marks[i];
        }
        double averagePercentage = (double) totalMarks / numOfSubjects;

        // For taking only 4 digits after decimal point
        String avgPercentage = String.format("%.4f", averagePercentage);
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage);
        System.out.println("Grade: " + grade);
    }
}
