package rvt;
import java.util.*;

public class Connecticut100 {
    // instance fields removed; use local variables in main
    public static void main(String[] args) {
        while (true) {
            String numeratorStart = "";
            int divisor = 0;
            int numerator = 0;

            try {
                Scanner reader = new Scanner(System.in);

                System.out.print("Enter the numerator: ");
                numeratorStart = reader.nextLine().trim();
                char firstNumeratorChar = numeratorStart.charAt(0);
                if (firstNumeratorChar == 'q') {
                    break;
                }
                if (firstNumeratorChar == 'Q') {
                    break;
                }
                numerator = Integer.parseInt(numeratorStart);

                System.out.print("Enter the divisor: ");
                divisor = reader.nextInt();

                System.out.println(numerator + " / " + divisor + " is " + numerator / divisor);
            } catch (ArithmeticException a) {
                System.out.println("you cant divide " + numerator + " by " + divisor);
                System.out.println();
            } catch (NumberFormatException c) {
                System.out.println("you entered bad data.");
                System.out.println("Please try again.");
                System.out.println();
            }
        }
    
    }
}
