package j4;


import cmn.Person;
import cmn.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kumagai on 2017/04/24.
 */
public class J4_3JavaMain {

    public static void main(String... args) {
        List<Person> studentList = Arrays.asList(
                new Person("Ken", 100),
                new Person("Shin", 60),
                new Person("Takuya", 90),
                new Person("taku", 84)
            );
        final List studentScoreList = studentList.stream()
                .map(s -> s.getName() + ":" + s.getAge())
                .collect(Collectors.toList());

        studentScoreList.stream().sorted().forEach(System.out::println);

    }

}
