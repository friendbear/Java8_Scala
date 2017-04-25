package j4;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kumagai on 2017/04/24.
 */
@Data
public class Student {

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int score;
}
