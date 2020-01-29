package edu.wpi.teamname.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A model for a mortgage
 *
 * @author Nick McMahon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mortgage {
  private double amount;
  private double rate;
  private int years;
  /**
   * Calculates the monthly payment according to the amount, rate, and years of the loan
   *
   * @return The montly payment for this mortgage
   */
  public double calculateMonthlyPayment() {
    double monthlyRate = rate / 12;
    int n = years * 12;
    double compound = Math.pow(1 + monthlyRate, n);

    return amount * (monthlyRate * compound) / (compound - 1);
  }
}
