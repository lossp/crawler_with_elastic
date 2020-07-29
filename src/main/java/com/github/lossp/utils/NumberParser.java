package com.github.lossp.utils;

public class NumberParser {
    // this function only deals things like 2,400. number split with comma
    public static Integer parseStringIntoInteger(String number) {
        if (number == null) throw new IllegalArgumentException("number cannot be null");
        String[] numbers = number.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (String item:numbers) {
            stringBuilder.append(item);
        }
        String result = stringBuilder.toString();
        return Integer.valueOf(result);
    }
}
