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
            double changeInPrice = priceChange(temporaryPreviousPrice, newPrice);
            changeAlert += changeSignificance(percentage(temporaryPreviousPrice, newPrice), significanceThreshold) + priceChangePercentage(temporaryPreviousPrice, newPrice);
            temporaryPreviousPrice = newPrice;
        }
        System.out.println(changeAlert);
    }

    private static String priceChangePercentage(double temporaryPreviousPrice, double newPrice) {
        double percentageOfChangeInPrice = (newPrice - temporaryPreviousPrice) / temporaryPreviousPrice * 100;
        NumberFormat formatter = new DecimalFormat("###########.##");
        String displayDetails = "";
        if (percentageOfChangeInPrice != 0) {
            displayDetails = formatter.format(temporaryPreviousPrice) + " to " + formatter.format(newPrice) + String.format(" (%.2f%%)%n", percentageOfChangeInPrice);
        } else {
            displayDetails = formatter.format(temporaryPreviousPrice) + System.lineSeparator();
        }
        return displayDetails;
    }
    static double percentage (double temporaryPreviousPrice, double newPrice){
        double percentage = 0;
        if (newPrice > temporaryPreviousPrice) {
            percentage = (newPrice - temporaryPreviousPrice) / temporaryPreviousPrice * 100;
        } else if (newPrice < temporaryPreviousPrice){
            percentage = (temporaryPreviousPrice - newPrice) / newPrice * 100;
        }
        return percentage;
    }

    private static String changeSignificance(double percentage, double significanceThreshold) {
        String priceSignificanceChange = "";
        significanceThreshold *= 100;
        if (percentage == 0){
            priceSignificanceChange = "NO CHANGE: ";
        } else if ((percentage < significanceThreshold && percentage > 0) || (percentage < significanceThreshold && (!((Math.abs(percentage) > significanceThreshold)))) ){
            priceSignificanceChange = "MINOR CHANGE: ";
        } else if (percentage >= significanceThreshold && percentage > 0){
            priceSignificanceChange = "PRICE UP: ";
        } else if (percentage >= significanceThreshold && percentage <0){
            priceSignificanceChange = "PRICE DOWN: ";
        }
        return priceSignificanceChange;
    }

    static double priceChange (double temporaryPreviousPrice, double newPrice){
        double changeInPrice = newPrice - temporaryPreviousPrice;
        return changeInPrice;
    }
}
