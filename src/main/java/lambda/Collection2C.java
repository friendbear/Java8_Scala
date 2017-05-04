package lambda;

import data.Friends;

import java.util.Optional;

import static java.util.stream.Collectors.joining;

/**
 * Created by kumagai on 2017/05/03.
 */
public class Collection2C {

    public static void main(String... args) {

        for (String name :
             Friends.FRIENDS) {
            System.out.print(name + ", ");
        }
        System.out.print(System.lineSeparator());

        for (int i = 0; i < Friends.FRIENDS.size() -1; i++) {
            System.out.print(Friends.FRIENDS.get(i) + ", ");
        }
        if (Friends.FRIENDS.size() > 0) {
            System.out.println(Friends.FRIENDS.get(Friends.FRIENDS.size() -1) );
        }

        System.out.println(String.join(", ", Friends.FRIENDS));

        System.out.println(
                Friends.FRIENDS.stream()
                        .map(String::toUpperCase)
                        .collect(joining(", ")));
        String j = Friends.FRIENDS.stream()
                .map(String::toUpperCase)
                .collect(joining(", "));

    }
}
