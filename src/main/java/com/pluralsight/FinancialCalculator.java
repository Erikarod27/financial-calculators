package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculator {

    //Main Method
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        float principal;
        float interestRate;
        float deposit;
        float monthlyPayout;
        int loanLength;
        boolean runningCalculator = true;

        while (runningCalculator) {
            System.out.println("Financial Calculator");
            System.out.println("(1): Mortgage Calculator");
            System.out.println("(2): CD Calculator");
            System.out.println("(3): Annuity Calculator");
            System.out.println("(0): Quit calculator");
            System.out.println("Type 1, 2, or 3 to pick calculator or 0 to quit");
            int calculator = scanner.nextInt();

            switch (calculator) {
                case 0:
                    System.out.println("Quitting financial calculator");
                    runningCalculator = false;
                    break;
                case 1:
                    System.out.print("Enter principal: ");
                    principal = scanner.nextFloat();
                    System.out.print("Enter interest rate: ");
                    interestRate = scanner.nextFloat();
                    System.out.print("Enter loan length (in years): ");
                    loanLength = scanner.nextInt();
                    mortgageCalculator(principal, interestRate, loanLength);
                    Thread.sleep(3000);
                    break;
                case 2:
                    System.out.print("Enter deposit: ");
                    deposit = scanner.nextFloat();
                    System.out.print("Enter interest rate: ");
                    interestRate = scanner.nextFloat();
                    System.out.print("Enter loan length (in years): ");
                    loanLength = scanner.nextInt();
                    cdCalculator(deposit, interestRate, loanLength);
                    Thread.sleep(3000);
                    break;
                case 3:
                    System.out.print("Enter monthly payout: ");
                    monthlyPayout = scanner.nextFloat();
                    System.out.print("Enter interest rate: ");
                    interestRate = scanner.nextFloat();
                    System.out.print("Enter loan length (in years): ");
                    loanLength = scanner.nextInt();
                    annuityCalculator(monthlyPayout, interestRate, loanLength);
                    Thread.sleep(3000);
                    break;
                default:
                    System.out.println("Invalid calculator option");

            }
        }

    }

    //Calculator 1 Method
    public static void mortgageCalculator(float principal, float interestRate, int loanLength) {
        int months = loanLength * 12;
        double monthlyInterestRate = interestRate / 100 / 12;
        double monthlyPayment = principal * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -months));
        double totalInterest = monthlyPayment * months - principal;
        System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f%n", totalInterest);
    }

    //Calculator 2 Method
    public static void cdCalculator(float deposit, float interestRate, int loanLength) {
        int months = loanLength * 12;
        double monthlyInterestRate = interestRate / 100 / 12;
        double futureValue = deposit * Math.pow(1 + monthlyInterestRate, months);
        double totalInterest = futureValue - deposit; // Corrected calculation
        System.out.printf("Future Value: $%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterest);
    }

    //Calculator 3 Method
    public static void annuityCalculator(float monthlyPayout, float interestRate, int loanLength) {
        int months = loanLength * 12;
        double monthlyInterestRate = interestRate / 100 / 12;
        double presentValue = monthlyPayout * (1 - Math.pow(1 + monthlyInterestRate, -months)) / monthlyInterestRate;
        System.out.printf("Present Value of Annuity: $%.2f%n", presentValue);
    }

}
