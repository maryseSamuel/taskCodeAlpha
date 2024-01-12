import java.util.Arrays;
import java.util.Scanner;

public class GradingSystem {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the  total number of students in class : ");
        int studentsCount = scanner.nextInt();

        int[] grades = new int[studentsCount];
        int sum = 0;

        for (int i = 1; i <= studentsCount; i++) {
            int grade;
            do {
                System.out.print("Enter grade for student " + (i) + ": ");
                grade = scanner.nextInt();

                if (grade < 0) {
                    System.out.println("Please enter a non-negative grade!");
                }
            } while (grade < 0);

            grades[i-1] = grade;
            sum+=grade;
        }


        int highest = Arrays.stream(grades).max().orElseThrow();;
        int lowest = Arrays.stream(grades).min().orElseThrow();
        double average = (double) sum / studentsCount;

        System.out.println("\n***Final Results***:");
        System.out.println("Highest Grade in class is : " + highest);
        System.out.println("Average Grade in class is : " + average);
        System.out.println("Lowest Grade in class is : " + lowest);

        scanner.close();
    }
}

