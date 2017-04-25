package j5;

import data.StudentData;
import org.apache.commons.lang3.StringUtils;

import javax.print.attribute.IntegerSyntax;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kumagai on 2017/04/25.
 */
public class J5_LambdaPoint {

    public static void main(String... args) {

        // 合格リスト
        List<String> passedList = StudentData.GROUPS.stream().flatMap(g -> g.getStudents().stream())
                .filter(student -> student.getScore() > 70)
                .map(student -> "<" + student.getName() + "> ○" )
                .collect(Collectors.toList());

        passedList.stream().forEach(System.out::println);


    }

    public static void intStreamSample() {
        // n回の繰り返しをするIntStream
        int count = 5;

        // 無駄1
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i != 0) {
                builder.append(", ");
            }
            builder.append("?");
        }
        System.out.println(builder.toString());

        // 無駄2
        String[] array = new String[count];
        Arrays.fill(array, "?");
        String query = StringUtils.join(", ");
        System.out.println(query);

        // IntStream
        String query2 = IntStream.range(0, count)
                .mapToObj(i -> "?")
                .collect(Collectors.joining(", "));

    }
}
