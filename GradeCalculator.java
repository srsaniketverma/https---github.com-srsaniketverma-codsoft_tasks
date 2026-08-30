import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== STUDENT GRADE CALCULATOR ===");

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        if (subjects <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            sc.close();
            return;
        }

        double total = 0;

        for (int i = 1; i <= subjects; i++) {

            double marks;

            while (true) {
                System.out.print("Enter marks for subject " + i + " (0-100): ");
                marks = sc.nextDouble();

                if (marks >= 0 && marks <= 100) {
                    break;
                }

                System.out.println("Invalid marks. Enter marks between 0 and 100.");
            }

            total += marks;
        }

        double percentage = total / subjects;

        String grade;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n=== RESULT ===");
        System.out.println("Total Marks: " + total + " / " + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%%n", percentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}