package ro.ScoalaInformala.AncaHaisu;

public class Calculator {

  public double convertToMm(double value, String unit) {
    switch (unit.toLowerCase()) {
      case "mm":
        return value;
      case "cm":
        return value * 10;
      case "dm":
        return value * 100;
      case "m":
        return value * 1000;
      case "km":
        return value * 1000000;
      default:
        throw new IllegalArgumentException("Invalid unit: " + unit);
    }
  }

  public double convertFromMm(double value, String unit) {
    switch (unit.toLowerCase()) {
      case "mm":
        return value;
      case "cm":
        return value / 10;
      case "dm":
        return value / 100;
      case "m":
        return value / 1000;
      case "km":
        return value / 1000000;
      default:
        throw new IllegalArgumentException("Invalid unit: " + unit);
    }
  }

  public int getUnitRank(String unit) {
    switch (unit.toLowerCase()) {
      case "mm":
        return 1;
      case "cm":
        return 2;
      case "dm":
        return 3;
      case "m":
        return 4;
      case "km":
        return 5;
      default:
        throw new IllegalArgumentException("Invalid unit: " + unit);
    }
  }

  public String getUnitName(int rank) {
    switch (rank) {
      case 1:
        return "mm";
      case 2:
        return "cm";
      case 3:
        return "dm";
      case 4:
        return "m";
      case 5:
        return "km";
      default:
        throw new IllegalArgumentException("Invalid unit rank: " + rank);
    }
  }
}
