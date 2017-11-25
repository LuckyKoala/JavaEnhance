package tech.zuosi.javaenhance.stream.exercise;

import tech.zuosi.javaenhance.stream.sample.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by iwar on 2017/6/14.
 */
public class StreamQuestion {
    public static void main(String[] args) {
        //getNameAndNationality(SampleData.getThreeArtists()).stream().forEach(System.out::println);
    }
    static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, elem) -> acc+elem);
    }
    static List<String> getNameAndNationality(List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(toList());
    }
    static long countLowercaseLetters(String str) {
        return str.chars()
                .filter(Character::isLowerCase)
                .count();
    }
    static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(StreamQuestion::countLowercaseLetters));
    }
}
