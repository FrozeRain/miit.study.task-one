package com.miit.study.frozerain.service;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.Random;

/**
 * A service that performs common operations of strings array.
 */
public abstract class StringArrayService {

    private static int minWordsCount = 5;
    private static int maxWordsCount = 20;

    /**
     * The external framework that allows to generate
     * the sequences of words with different lengths.
     */
    private static Lorem generator = LoremIpsum.getInstance();

    /**
     * Generate strings with random length, which bounds manually defined in
     * {@link #minWordsCount} and {@link #maxWordsCount}.
     * @param strings - array of strings.
     * @return strings array with generated strings.
     */
    public static String[] generateTestData(String... strings) {
        Random wordsCount = new Random();
        for (int i = 0; i < strings.length; i++) {
            strings[i] = generator.getWords(
                    wordsCount.nextInt(maxWordsCount) + minWordsCount);
        }
        return strings;
    }

    /**
     * Previews existing strings array as one formatted string.
     * @param strings - array of strings.
     * @return formatted string as concatenation of strings array.
     */
    public static String toFormattedString(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String str: strings) {
            sb.append(str).append("\n> ");
        }
        return sb.toString();
    }

    /**
     * Searching string with minimum value of length.
     * Method searching the first strings array's index of string with minimum value of length.
     * @param strings - array of strings.
     * @return string at the index to be found.
     */
    public static String getMinStringLength(String... strings) {
        int minLengthIndex = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[minLengthIndex].length() > strings[i].length()) {
                minLengthIndex = i;
            }
        }
        return strings[minLengthIndex];
    }
}
