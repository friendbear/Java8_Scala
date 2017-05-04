package j4;

import cmn.Student;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kumagai on 2017/04/24.
 */
public class J4_1JavaMain {


    static {
    }
    public static void main(String... args) {
        Student[] students = {
                new Student("Ken", 18, 100),
                new Student("Shin", 18, 60),
                new Student("Takuya", 18, 90),
                new Student("taku", 18, 84),

        };
        Arrays.stream(students)
                .forEach(s-> {
//                    System.out.println(s.toString());
                });

        Arrays.sort(students, comparator);

        //
        Arrays.sort(students, Comparator.comparing(Student::getScore));

        for (Student student: students) {
            System.out.println(student.toString());

        }
        // 配列のバイナリサーチ
        final int result = Arrays.binarySearch(students, new Student("taku", 17, 84), comparator);
        if (result >= 0) {
            System.out.println(students[result].toString());
        }
    }

    static Comparator<Student> comparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.getScore(), o2.getScore());
        }
    };
}
