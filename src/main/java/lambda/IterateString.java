package lambda;

/**
 * Created by kumagai on 2017/05/03.
 */
public class IterateString {
    final static String str = "w00t";
    public static void main(String... args) {

        str.chars().forEach(ch -> System.out.println(ch));
        str.chars().forEach(System.out::println);

        str.chars().forEach(IterateString::printChars);

        str.chars().mapToObj(ch -> Character.valueOf((char)ch))
                .forEach(System.out::println);

        str.chars()
                .filter(ch -> Character.isDigit(ch))
                .forEach(ch -> System.out.println((char)ch));

        str.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChars);
    }

    private static void printChars(int aChar) {
        System.out.println((char)aChar);
    }
}
