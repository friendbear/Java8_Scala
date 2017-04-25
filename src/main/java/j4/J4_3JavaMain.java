package j4;


import cmn.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kumagai on 2017/04/24.
 */
public class J4_3JavaMain {

    public static void main(String... args) {
        List<Student> studentList = Arrays.asList(
                new Student("Ken", 100),
                new Student("Shin", 60),
                new Student("Takuya", 90),
                new Student("taku", 84)
            );
        final List studentScoreList = studentList.stream()
                .map(s -> s.getName() + ":" + s.getScore())
                .collect(Collectors.toList());

        studentScoreList.stream().sorted().forEach(System.out::println);

    }

}
