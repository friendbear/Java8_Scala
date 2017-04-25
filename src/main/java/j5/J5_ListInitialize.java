package j5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by kumagai on 2017/04/25.
 */
public class J5_ListInitialize {

    public static void main(String... args) {

        // プリミティブ型をInteger型に変換して返却
        List<Integer> integerList = IntStream.of(1, 62,31, 1, 54, 31).boxed()
                .collect(Collectors.toList());
        // ボクシングがいらないものの初期化
        List<String> stringList = Stream.of("Tokyo", "Chiba", "Kyoto")
                .collect(Collectors.toList());
    }
}
