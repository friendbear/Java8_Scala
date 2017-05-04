package lambda;

import data.Friends;

import java.util.List;
import java.util.Optional;

/**
 * Created by kumagai on 2017/05/02.
 */
public class Collection2B {

    public static void main(String... args) {
        pickName(Friends.FRIENDS, "N");
        pickName2(Friends.FRIENDS, "N");
        pickName2(Friends.FRIENDS, "Z");

        // MapReduce
        final Optional<String> aLongName = Friends.FRIENDS.stream().reduce((name1, name2) ->
            name1.length() >= name2.length() ? name1 : name2);
        aLongName.ifPresent(name ->
            System.out.println(String.format("A longest name: %s", name)));
    }

    public static void pickName(final List<String> names, final String startingLetter) {
        String foundName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }
        if (foundName != null) {
            System.out.println(foundName);
        }
        else {
            System.out.println("No name found");
        }
    }
    public static void pickName2(final List<String> names, final String startingLetter) {
        Optional<String> foundName =
                names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();
        System.out.println(String.format("A name starting with %s: %s",
                startingLetter, foundName.orElse("No name found")));
    }
}
