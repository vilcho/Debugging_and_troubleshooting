import java.util.Scanner;

/**
 * Created by Vilcho on 5/18/2017.
 */
public class Lab_p01_MultiplyEvenByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int result = getMultipleOfEvenAndOdds(n);
        System.out.println(result);

    }

    static int getMultipleOfEvenAndOdds(int n) {
        int sumEvens = getSumOfEvenDigits(n);
        int sumOdds = getSumOfOddDigits(n);
        int multipleOfEvenAndOdds = sumEvens * sumOdds;
        return multipleOfEvenAndOdds;

    }

    static int getSumOfEvenDigits(int n) {
        if (n < 0) {
            n = Math.abs(n);
        }
        int sumEvenDigits = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            boolean isLastDigitEven = lastDigit % 2 == 0;

            if (isLastDigitEven) {
                sumEvenDigits += lastDigit;
            }
            n /= 10;
        }

        return sumEvenDigits;
    }

    static int getSumOfOddDigits(int n) {
        if (n < 0) {
            n = Math.abs(n);
        }
        int sumOddDigits = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            boolean isLastDigitOdd = lastDigit % 2 != 0;
            if (isLastDigitOdd) {
                sumOddDigits += lastDigit;
            }
            n /= 10;
        }
        return sumOddDigits;
    }
}
