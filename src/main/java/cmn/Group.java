package cmn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumagai on 2017/04/25.
 */
public class Group {

    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
