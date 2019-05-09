package com.muszkin.bmianalyzer;

public class BmiCalculator {

    public static float calculateBmi(float height,float weight) {
        return (float)Math.round((weight/Math.pow(height,2))*100) /100;
    }

    public static float calcualteWeight(float height,float bmi) {
        return (float)Math.round((bmi * Math.pow(height,2))*100) /100;
    }
}
