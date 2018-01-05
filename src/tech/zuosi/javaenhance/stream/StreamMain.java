package tech.zuosi.javaenhance.stream;

import tech.zuosi.javaenhance.stream.sample.Album;
import tech.zuosi.javaenhance.stream.sample.Track;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Created by iwar on 2017/6/7.
 */
public class StreamMain {
    public static void main(String[] args) {
        /*BinaryOperator<Integer> accumulator = (acc, elem) -> acc+elem;
        int count = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1), 2
                ), 3
        );
        assertEquals(6, count);*/
    }
    public Set<String> findLongTracks(List<Album> albums) {
        return albums.stream()
                .flatMap(Album::getTracks)
                .filter(track -> track.getLength() > 60)
                .map(Track::getName)
                .collect(toSet());
    }
}