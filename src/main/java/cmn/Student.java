package cmn;

import lombok.*;

/**
 * Created by kumagai on 2017/04/24.
 */
@Data
public class Student extends Person{

    public Student(String name, Integer age, int score) {
        super(name, age);
        this.score = score;
    }

    @Getter
    @Setter
    private int score;
}
