package apap.tutorial.hitungbmi.model;

import java.io.Serializable;

public class BMI implements Serializable {
    private double weight;
    private double height;

    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double countBMI() {
        return weight / (Math.pow((height/100), 2));
    }

    public String getInterpretation() {
        double bmi = countBMI();

        if (bmi < 18.5) {
            return "underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public double getWeight() { return weight; }

    public double getHeight() { return height; }

}
