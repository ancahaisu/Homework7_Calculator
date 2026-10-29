package ro.ScoalaInformala.AncaHaisu;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CalculatorApp {
  public void run() {
    System.out.println("This is a simple calculator that can add and subtract values with different units of length.");
    System.out.println("You will need to input the first value and its unit, then you can add or subtract more values with their units.");
    System.out.println("The calculator will automatically convert all values to the smallest unit and display the result in that unit.");
    System.out.println("The result will be displayed in the smallest unit used in the calculations when you press 'R'.");
    System.out.println("Available units: mm, cm, dm, m, km");
    System.out.println("Let's start!");
    Scanner scanner = new Scanner(System.in);
    Calculator calculator = new Calculator();
    System.out.print("First value: ");
    double first = scanner.nextDouble();
    System.out.print("First unit (mm, cm, dm, m, km): ");
    String firstUnit = scanner.next();
    double result = calculator.convertToMm(first, firstUnit);
    // 1 = mm, 2 = cm, 3 = dm, 4 = m, 5 = km
    int smallestUnit = calculator.getUnitRank(firstUnit);
    while (true) {
      System.out.print("Operator (+, - or R for result): ");
      String operator = scanner.next();
      if (operator.equalsIgnoreCase("R")) {
        break;
      }
      if (!operator.equals("+") && !operator.equals("-")) {
        System.out.println("Invalid operator!");
        continue;
      }
      System.out.print("Next value: ");
      double nextValue = scanner.nextDouble();
      System.out.print("Unit (mm, cm, dm, m, km): ");
      String nextUnit = scanner.next();
      int nextUnitRank = calculator.getUnitRank(nextUnit);
      if (nextUnitRank < smallestUnit) {
        smallestUnit = nextUnitRank;
      }
      double valueInMm = calculator.convertToMm(nextValue, nextUnit);
      if (operator.equals("+")) {
        result += valueInMm;
      } else {
        result -= valueInMm;
      }
    }
    String outputUnit = calculator.getUnitName(smallestUnit);
    double convertedResult = calculator.convertFromMm(result, outputUnit);
    System.out.println("You press R, so you want to see the result in the smallest unit used in the calculations.");
    System.out.println("The result is: " + convertedResult + " " + outputUnit);

    scanner.close();
  }
}
