package j5;

import cmn.Student;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    private static Map<Optional<String>, String> map = new HashMap<>();
    static {
        map.put(Optional.of("1"), "Murata");
        map.put(Optional.of("2"), "Okada");
        map.put(Optional.of("3"), "Kumagai");
        map.put(Optional.of("4"), "Matsumoto");
        map.put(Optional.of("5"), "Andou");

    }

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

        int rangeMax = 20;
        String delimiter = IntStream.range(0, rangeMax).mapToObj(i -> "-").collect(Collectors.joining("+"));
        System.out.println(delimiter);
        IntStream.range(0, rangeMax).forEach((i) -> {
            if (rangeMax == i) System.out.print('-');
        });
        J5_LambdaBasic.mapSort();
        J5_LambdaBasic.intStreamSample();
        IntStream.range(0, rangeMax).forEach((i) -> System.out.print('-'));

    }

    public static int compare(Student s1, Student s2) {
        return Integer.compare(s1.getScore(), s2.getScore());
    }

    /** マップのvalueをソートしてみる
     *
     */
    public static void mapSort() {

        List<String> firstNameList1 = map.values().stream().sorted((name1, name2) -> {
            return name1.compareTo(name2);
        }).collect(Collectors.toList());

/* 上記をもっとシンプルに */
        List<String> firstNameList2 = map.values().stream()
                .sorted(Comparator.reverseOrder()) // naturalOrder() との使い分け
                .collect(Collectors.toList());

        firstNameList2.forEach(System.out::println);
        firstNameList1.forEach(System.out::println);
    }

    public static void intStreamSample(){
        IntStream stream = IntStream.rangeClosed(0, 10);

        IntStream.range(0, 10).forEach(i -> {
            if (map.containsKey(Optional.of(String.valueOf(i)))) {
                System.out.println(map.get(Optional.of(String.valueOf(i))));

            } else {
                System.out.println(i);
            }
        });
        //stream.forEach(System.out::println);
    }
}
