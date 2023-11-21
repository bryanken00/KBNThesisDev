package testingForecasting;

public class ValuePrediction {
    public static void main(String[] args) {
        double octoberValue = 80;
        double novemberValue = 71;

        // Calculate the growth rate
        double growthRate = (novemberValue - octoberValue) / octoberValue;

        // Predict the December value
        double predictedDecemberValue = novemberValue + (novemberValue * growthRate);

        System.out.println(growthRate);
        System.out.println("October Value: " + octoberValue);
        System.out.println("November Value: " + novemberValue);
        System.out.println("Predicted December Value: " + predictedDecemberValue);
    }
}