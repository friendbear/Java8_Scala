package J8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by kumagai on 2017/04/27.
 */
public class J8_File {

    public static void main(String... args) {

        Path path = Paths.get("/tmp/data.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            reader.lines()
                    .map(s -> s.split(" ")[0]).distinct()
                    .forEach(System.out::println);

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
