package j5;

import cmn.Student;
import data.StudentData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by kumagai on 2017/04/25.
 */
public class J5_LambdaMiddle {

    public static void main(String... args) {

        Stream<List<Student>> mappedStream = StudentData.GROUPS.stream().map(g -> g.getStudents());
        Stream<Student> flatMappedStream = StudentData.GROUPS.stream().flatMap(g -> g.getStudents().stream());

        List<Student> allStudent = new ArrayList<>();
        StudentData.GROUPS.stream().forEach(g -> allStudent.addAll(g.getStudents()));
        allStudent.stream()
                .sorted((s1, s2) -> s2.getScore() - s1.getScore())
                .forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));


        StudentData.GROUPS.stream().flatMap(g -> g.getStudents().stream())
                .sorted(Comparator.comparing(Student::getScore))
                .forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));

    }



}
