package ex2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class UserAnalyzer {
    private List<User> users;

    public UserAnalyzer(List<User> users) {
        this.users = users;
    }

    public double calculateAverageAge() {
        return users.stream().mapToInt(u -> u.getAge()).average().orElse(0);
    }

    public List<String> findCountriesWithMostUsers() {
        Map<String, Long> countryCounts = users.stream()
                .collect(Collectors.groupingBy(User::getCountry, Collectors.counting()));

    return countryCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .stream()
                .flatMap(maxEntry -> countryCounts.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(maxEntry.getValue()))
                        .map(Map.Entry::getKey))
                .collect(Collectors.toList());
    }

    public String findMostCommonFirstName() {
        Map<String, Long> firstNameCounts = users.stream()
                .collect(Collectors.groupingBy(User::getFirstName, Collectors.counting()));

        return firstNameCounts.entrySet().stream().max(Entry.comparingByValue()).orElseThrow().getKey();
    }

    public String findMostCommonLastName() {
        Map<String, Long> lastNameCounts = users.stream()
                .collect(Collectors.groupingBy(User::getLastName, Collectors.counting()));

        return lastNameCounts.entrySet().stream().max(Entry.comparingByValue()).orElseThrow().getKey();
    }

    public User findOldestUser() {
        return users.stream().max(Comparator.comparingInt(User::getAge)).orElse(null);
    }

    public User findYoungestUser() {
        return users.stream().min(Comparator.comparingInt(User::getAge)).orElse(null);
    }

    public List<String> findUniqueCountries() {
        return users.stream().map(u -> u.getCountry()).collect(Collectors.toSet()).stream()
                .collect(Collectors.toList());
    }
}
