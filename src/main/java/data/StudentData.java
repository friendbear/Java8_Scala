package data;

import cmn.Group;
import cmn.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumagai on 2017/04/25.
 */
public class StudentData {

    public static List<Group> GROUPS;
    static {
        GROUPS = new ArrayList<>();
        Group group1 = new Group();
        group1.add(new Student("Murata", 100));
        group1.add(new Student("Tanimoto", 60));
        group1.add(new Student("Okada", 80));

        GROUPS.add(group1);

        Group group2 = new Group();
        group2.add(new Student("Akiba", 75));
        group2.add(new Student("Hayakawa", 85));
        group2.add(new Student("Sakamoto", 95));

        GROUPS.add(group2);

        Group group3 = new Group();
        group3.add(new Student("Kimura", 90));
        group3.add(new Student("Hayakawa", 65));
        group3.add(new Student("Sakamoto", 80));

        GROUPS.add(group3);
    }
}
