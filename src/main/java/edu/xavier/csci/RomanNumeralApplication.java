package edu.xavier.csci;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumeralApplication {

    private static String encode(int num) {
        TreeMap<Integer, Character> encodeMap = new TreeMap<>();
        encodeMap.put(1, 'I');
        encodeMap.put(5, 'V');
        encodeMap.put(10, 'X');
        encodeMap.put(50, 'L');
        encodeMap.put(100, 'C');
        encodeMap.put(500, 'D');
        encodeMap.put(1000, 'M');
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            int firstDig = Integer.parseInt(String.valueOf(num).substring(0,1));
            if(firstDig % 5 == 4 && num < 4000) {
                int prev;
                if (firstDig <= 5) {
                    prev = encodeMap.lowerKey(num);
                } else {
                    int temp = encodeMap.lowerKey(num);
                    prev = encodeMap.lowerKey(temp -1);
                }
                builder.append(encodeMap.get(prev));
                int l = encodeMap.higherKey(num);
                builder.append(encodeMap.get(l));
                num -= l - prev;

            } else {
                int k = encodeMap.floorKey(num);
                if (num == k) {
                    builder.append(encodeMap.get(num));
                    break;
                }
                builder.append(encodeMap.get(k));
                num -= k;
            }
        }
        return builder.toString();
    }

    private static int decode(String romanNum) {
        Map<Character, Integer> decodeMap = new HashMap<>();
        decodeMap.put('I', 1);
        decodeMap.put('V', 5);
        decodeMap.put('X', 10);
        decodeMap.put('L', 50);
        decodeMap.put('C', 100);
        decodeMap.put('D', 500);
        decodeMap.put('M', 1000);

        int num = 0;
        int prev = 0;
        for (int i = romanNum.length() -1; i >= 0; i--) {
            int temp = decodeMap.get(romanNum.charAt(i));
            if(temp < prev)
                num-=temp;
            else
                num+=temp;
            prev = temp;
        }
        return  num;
    }
    public static void main(String[] args) {
        switch (args[0]) {
            case "encode":
                int num = Integer.parseInt(args[1]);
                try {
                    System.out.printf(args[0] + " %d output: %s \n", num, encode(num));
                } catch (NullPointerException e) {
                    System.out.println("Wrong argument");
                }
                break;
            case "decode":
                try {
                    System.out.printf(args[0] + " %s output: %d \n", args[1], decode(args[1]));
                } catch (NullPointerException e) {
                    System.out.println("Wrong argument");
                }
                break;
            default:
                System.out.println("Wrong argument");
        }
    }
}