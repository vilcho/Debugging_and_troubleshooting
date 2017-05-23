

import java.text.DecimalFormat;

import java.text.NumberFormat;

import java.text.ParseException;

import java.util.Scanner;


/**
 * Created by Vilcho on 5/22/2017.
 */

public class Lab_p03_PriceChangeAlert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double significanceThreshold = Double.parseDouble(scanner.nextLine());

        double temporaryPreviousPrice = Double.parseDouble(scanner.nextLine());
        double newPrice = 0;
        String changeAlert = "";

        for (int i = 0; i < n-1; i++) {
            newPrice = Double.parseDouble(scanner.nextLine());
            double percentage = percentageChange(temporaryPreviousPrice, newPrice);
            double percentageBy100 = percentage * 100.0;
            boolean eitherTrueOrFalse = isEnoughDiff(significanceThreshold, percentage);
            changeAlert += changeSignificance(percentage, significanceThreshold, newPrice, temporaryPreviousPrice, eitherTrueOrFalse) + calcDetails(temporaryPreviousPrice, newPrice, percentage);
            if (newPrice - temporaryPreviousPrice != 0) {
                changeAlert += String.format(" (%.2f%%)%n", percentageBy100);
            }
// else {
//                changeAlert += System.lineSeparator();
//            }
            temporaryPreviousPrice = newPrice;
        }
        System.out.println(changeAlert);
    }

    static String calcDetails(double temporaryPreviousPrice, double newPrice, double percentage) {
        String details = "";
        NumberFormat formatter = new DecimalFormat("###########.##");
        if (percentage != 0 && !String.valueOf(percentage).equals("NaN")) {
            details = formatter.format(temporaryPreviousPrice) + " to " + formatter.format(newPrice);
        } else {
            details = formatter.format(temporaryPreviousPrice) + System.lineSeparator();
        }
        return details;
    }

    static String changeSignificance(double percentage, double significanceThreshold, double newPrice, double temporaryPreviousPrice, boolean eitherTrueOfFalse) {
        String priceSignificanceChange = "";
        boolean eitherTrueOrFalse = isEnoughDiff(significanceThreshold, percentage);
        if (percentage == 0 || String.valueOf(percentage).equals("NaN")) {
            priceSignificanceChange = "NO CHANGE: ";
        } else if (!eitherTrueOrFalse) {
            priceSignificanceChange = "MINOR CHANGE: ";
        } else if (eitherTrueOfFalse && (percentage > 0)) {
            priceSignificanceChange = "PRICE UP: ";
        } else if (eitherTrueOfFalse && (percentage < 0)) {
            priceSignificanceChange = "PRICE DOWN: ";
        }
        return priceSignificanceChange;
}


    static boolean isEnoughDiff(double significanceThreshold, double percentage) {
        boolean eitherTrueOrFalse = false;
        if (Math.abs(significanceThreshold) <= Math.abs(percentage)) {
            eitherTrueOrFalse = true;
        } else {
            eitherTrueOrFalse = false;
        }
        return eitherTrueOrFalse;
    }

    static double percentageChange(double temporaryPreviousPrice, double newPrice) {
        double changeInPrice = newPrice - temporaryPreviousPrice;
        double percentage = changeInPrice / temporaryPreviousPrice;
        return percentage;
    }
}
