package com.akropon.projectEuler.problem17;

public class Problem17 {

    static String[] unitsNames = {"zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"};
    static String[] tensNames = {null, null, "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"};
    static String[] teensNames = {"ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String AND = "and";
    static String ONE_THOUSAND = "one thousand";
    static String HUNDRED = "hundred";

    public static void main(String[] args) {
        long answer = solve(1000);
        System.out.println(answer);
    }

    public static long solve(int maxInt) {
        int sum = 0;
        for (int i = 1; i <= maxInt; i++) {
            sum += getLettersAmount(getFullNumberName(i));
        }
        return sum;
    }

    private static int getLettersAmount(String _string) {
        int lettersAmount = 0;
        for (int i = 0; i < _string.length(); i++) {
            char _char = _string.charAt(i);
            if (Character.isLetter(_char))
                lettersAmount++;
        }
        return lettersAmount;
    }

    private static String getFullNumberName(int number) {
        if (number < 0 || number > 1000)
            throw new IllegalArgumentException("the number should be more then -1 and less then 1001, but number=" + number);

        if (number == 1000)
            return ONE_THOUSAND;

        if (number == 0)
            return unitsNames[0];

        StringBuilder numberName = new StringBuilder();
        int units = number % 10;
        number /= 10;
        int tens = number % 10;
        int hundreds = number / 10;

        if (hundreds > 0) {
            numberName.append(unitsNames[hundreds]).append(" ").append(HUNDRED);
            if (tens == 0 && units == 0)
                return numberName.toString();
            else
                numberName.append(" ").append(AND);
        }

        if (tens == 1) {
            if (numberName.length() > 0)
                numberName.append(" ");
            numberName.append(teensNames[units]);
            return numberName.toString();
        }

        if (tens > 1) {
            if (numberName.length() > 0)
                numberName.append(" ");
            numberName.append(tensNames[tens]);
        }

        if (units > 0) {
            if (numberName.length() > 0)
                numberName.append(" ");
            numberName.append(unitsNames[units]);
        }

        return numberName.toString();
    }


}
