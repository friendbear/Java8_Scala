package lambda;

import cmn.Student;
import data.Friends;
import data.StudentData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by kumagai on 2017/05/02.
 */
public class Collection2A {


    public static void main(String... args) {
        // Consumer
        Friends.FRIENDS.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });
        Friends.FRIENDS.forEach((final String name) -> System.out.println(name));
        Friends.FRIENDS.forEach(name -> System.out.println(name));
        Friends.FRIENDS.forEach(System.out::println);
        long friendsNameBytesSize = Friends.FRIENDS.stream().mapToInt(s-> s.length()).sum();
        System.out.println(friendsNameBytesSize);

        // リストの変換
        List<String> uppercaseNames = new ArrayList<>();
        Friends.FRIENDS.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        // ラムダ式を使うと
        Friends.FRIENDS.stream()
                .map(name -> name.toUpperCase())
                .forEach(uppercaseNames::add);
        Friends.FRIENDS.stream()
                .map(String::toUpperCase)
                .forEach(uppercaseNames::add);


        final Function<Student,String> byName1 = student -> student.getName();
        final Function<Student,String> byName2 = student -> student.getName();

        StudentData.GROUPS.stream().flatMap(group -> group.getStudents().stream())
                .sorted(Comparator.comparing(byName1))
                .forEach(student -> System.out.println(student.toString()));

        //
        final Predicate<String> startWithN = name -> name.startsWith("N");
        final Predicate<String> startWithB = name -> name.startsWith("B");
        final long countFriendsStartN = Friends.FRIENDS.stream().filter(startWithN).count();
        final long countFriendsStartB = Friends.FRIENDS.stream().filter(startWithB).count();

        //
        final long countFriendStartN_1 = Friends.FRIENDS.stream()
                .filter(checkIfStartsWith("N"))
                .count();
        final long countFriendStartB_1 = Friends.FRIENDS.stream()
                .filter(checkIfStartsWith("B"))
                .count();
        final Function<String, Predicate<String>> startsWithLetter =
            (String letter) -> {
            Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
            return checkStarts;
        };
        final long countFriendStartN_2 = Friends.FRIENDS.stream()
                .filter(startsWithLetter.apply("N"))
                .count();
        final long countFriendStartB_2 = Friends.FRIENDS.stream()
                .filter(startsWithLetter.apply("B"))
                .count();

    }
    //
    public static Predicate<String> checkIfStartsWith(final String letter) {
        return string -> string.startsWith(letter);
    }
}
