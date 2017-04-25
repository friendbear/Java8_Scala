package j4;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

/**
 * Created by kumagai on 2017/04/25.
 */
public class J5_LambdaBasic {

    private static List<Student> studentList = Arrays.asList(
            new Student("Ken", 100),
            new Student("Shin", 60),
            new Student("Takuya", 90),
            new Student("taku", 84)
    );

    public static void main(String... args) throws RuntimeException {

        try {
            Runnable runnable;
            runnable = () -> {
                System.out.println("ラムダ式のテストです。");
                Collections.sort(studentList, (s1, s2) -> J5_LambdaBasic.compare(s1, s2));
                System.out.println("ラムダ式のテストです。");
            };
            TimeUnit.SECONDS.sleep(1);
            runnable.run();

            studentList.stream().forEach(System.out::println);
        } catch (InterruptedException e) {
            System.out.println("割り込みが入りました");
        }

    }

    public static int compare(Student s1, Student s2) {
        return Integer.compare(s1.getScore(), s2.getScore());
    }
}
