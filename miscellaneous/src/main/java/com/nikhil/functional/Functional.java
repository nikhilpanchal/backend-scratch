package com.nikhil.functional;

import java.util.function.*;

public class Functional {
    private Predicate<String> strLengthPredicate;
    private Predicate<String> strEmptyPredicate;

    private Predicate<String> combinedStringPredicate;

    private Function<Double, Double> celciusConvertor;
    private UnaryOperator<Double> unaryCelciusConvertor;

    private BinaryOperator<Double> summer;

    private CustomFunctional<String, Double> convertStringToDouble;

    public Functional() {
        strEmptyPredicate = s -> s.isEmpty();
        strLengthPredicate = s -> s.length() > 0;

        combinedStringPredicate = strEmptyPredicate.and(strLengthPredicate);

        celciusConvertor = f -> (f - 32) * 5/9;
        unaryCelciusConvertor = f -> (f - 32) * 5/9;

        summer = (a, b) -> a+b;

        convertStringToDouble = s -> Double.parseDouble(s);
    }

    public boolean checkStringEmpty(String str) {
        return strEmptyPredicate.test(str);
    }

    public boolean checkStringCombined(String str) {
        return combinedStringPredicate.test(str);
    }

    public double convertToCelcius(double farenheit) {
        return celciusConvertor.apply(farenheit);
    }

    public double convertToCelciusUsingUnary(double farenheit) {
        return unaryCelciusConvertor.apply(farenheit);
    }

    public double sumNumbers(double first, double second) {
        return summer.apply(first, second);
    }

    public double convertToDouble(String s) {
        return convertStringToDouble.doIt(s);
    }
}
