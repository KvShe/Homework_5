package Homeworks.Homework_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Написать метод, который переведет число из римского формата записи в арабский. Например, MMXXII = 2022
 */
public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        String number = scanner.nextLine();
        System.out.println(number + " -> " + romanToInt(number));
    }

    private static int romanToInt(String romanNumber) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int arabNumber = map.get(romanNumber.charAt(romanNumber.length() - 1));

        for (int i = romanNumber.length() - 2; i >= 0; i--) {
            int currentValue = map.get(romanNumber.charAt(i));
            int nextValue = map.get(romanNumber.charAt(i + 1));

            if (currentValue < nextValue) arabNumber -= currentValue;
            else arabNumber += currentValue;
        }
        return arabNumber;
    }
}
