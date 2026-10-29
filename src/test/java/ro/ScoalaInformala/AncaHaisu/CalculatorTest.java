package ro.ScoalaInformala.AncaHaisu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

  Calculator calculator = new Calculator();

  @Test
  void convertToMmTest() {
    assertEquals(1000, calculator.convertToMm(1, "m"));
  }

  @Test
  void convertFromMmTest() {
    assertEquals(100, calculator.convertFromMm(1000, "cm"));
  }

  @Test
  void getUnitRankTest() {
    assertEquals(2, calculator.getUnitRank("cm"));
  }

  @Test
  void getUnitNameTest() {
    assertEquals("cm", calculator.getUnitName(2));
  }

  @ParameterizedTest
  @CsvSource({"1, m, 1000", "2, cm, 20", "3, dm, 300", "4, mm, 4", "1, km, 1000000"})
  void convertToMmParameterizedTest(double value, String unit, double expected) {
    assertEquals(expected, calculator.convertToMm(value, unit));
  }
}
