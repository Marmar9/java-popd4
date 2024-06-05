package ex1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextAnalysis {

    public static long getWordCount(String text) {
        return Arrays.stream(text.split("\\s+")).count();
    }

    public static long getUniqueWordCount(String text) {
        return Arrays.stream(text.split("\\s+")).distinct().count();
    }

    public static double getAverageWordLength(String text) {
        return Arrays.stream(text.replace(".", "").split("\\s+")).mapToInt(String::length).average().orElse(0);
    }

    public static String getLongestWord(String text) {
        return Arrays.stream(text.split("\\s+")).max(Comparator.comparingInt(String::length)).orElse("");
    }

    public static String getMostFrequentWord(String text) {
        return Arrays.stream(text.replace(".", "").split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).orElseThrow().getKey();
    }

    public static Map<String, Long> getWordFrequency(String text) {
        return Arrays.stream(text.replace(".", "").split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
