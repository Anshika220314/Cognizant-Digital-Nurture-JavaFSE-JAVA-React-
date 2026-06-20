public class ForecastingTool {

    /**
     * Recursive method to predict future asset values.
     * @param presentValue Current evaluation baseline
     * @param growthRate Growth rate percentage in decimal form (e.g., 0.05 for 5%)
     * @param years Number of years to forecast into the future
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base Case: No more years remaining to forecast
        if (years <= 0) {
            return presentValue;
        }
        
        // Recursive Case: Calculate the value for the next year
        double nextYearValue = presentValue * (1 + growthRate);
        return calculateFutureValue(nextYearValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.0; // $10,000 initial baseline
        double rate = 0.05;                // 5% compound growth rate
        int forecastYears = 5;             // Period calculation depth
        
        double projectedValue = calculateFutureValue(initialInvestment, rate, forecastYears);
        
        System.out.println("--- Financial Forecasting Analysis ---");
        System.out.printf("Initial Principal: $%.2f%n", initialInvestment);
        System.out.printf("Annual Compound Interest: %.1f%%%n", (rate * 100));
        System.out.printf("Projected Portfolio Value after %d years: $%.2f%n", forecastYears, projectedValue);
    }
}