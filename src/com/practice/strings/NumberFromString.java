package com.practice.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberFromString {

    public static class Response {
        private String input;
        private List<String> output;

        public Response(final String input, final List<String> output) {
            this.input = input;
            this.output = output;
        }

        public String toString() {
            return "Input: " + this.input + " Output: " + this.output;
        }
    }

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<String>();
        inputList.add("a3b2d");
        inputList.add("a123b1d");
        inputList.add("as1db2");


        inputList.stream()
                .map(NumberFromString::findNumbers)
                .forEach(System.out::println);
    }

    //    input = a33bd2d23
//    result = []
//    tempStr = ""
//    from i = 0 to len(input)
//        if(isNumber(input[i]))
//            tempStr = tempStr + input[i]
//         else
//            if(notBlank(tempStr))
//               result.add(tempStr)
//            tempStr = ""
//            if(notBlank(tempStr))
//               result.add(tempStr)
//    return result
    private static Response findNumbers(final String input) {
        if (input == null) {
            return new Response(input, Collections.emptyList());
        }

        List<String> result = new ArrayList<>();
        String tempStr = "";

        char[] inputCharArray = input.toCharArray();

        for (final char currentChar : inputCharArray) {
            if (isNumber(currentChar)) {
                tempStr = tempStr + currentChar;
            } else {
                if (!tempStr.isEmpty()) {
                    result.add(tempStr);
                }
                tempStr = "";
            }
        }

        if (!tempStr.isEmpty()) {
            result.add(tempStr);
        }

        return new Response(input, result);
    }

    private static boolean isNumber(final char currentChar) {
        try {
            Integer.parseInt("" + currentChar);
            return true;
        } catch (final Exception exception) {
            return false;
        }
    }

}
