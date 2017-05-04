package lambda;

import cmn.Person;
import cmn.Student;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;
import data.Persons;
import data.StudentData;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by kumagai on 2017/05/03.
 */
public class Compare {

    public static void main(String... args) {
        Comparator<Person> personComparatorAsc = (person1, person2) -> person1.getAge() - person2.getAge();
        Comparator<Person> personComparatorDsc = personComparatorAsc.reversed();

        List<Person> ascendingAge =
                Persons.PERSONS.stream()
                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .collect(Collectors.toList());
        printPeople("Sorted in ascending order by age: ", ascendingAge);
        List<Person> descendingAge =
                Persons.PERSONS.stream()
                        .sorted(personComparatorDsc)
                        .collect(Collectors.toList());
        printPeople("Sorted in descending order by age: ", descendingAge);


        printPeople("Sorted in ascending order by name",
                Persons.PERSONS.stream()
                        .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                        .collect(Collectors.toList()));
        printPeople("Sorted in ascending order by Student Name",
                StudentData.GROUPS.stream().flatMap(group -> group.getStudents().stream())
                        .sorted(Comparator.comparing(Student::getName))
                        .collect(Collectors.toList()));

        //
        Persons.PERSONS.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println("Youngest: " + youngest.toString()));
        Persons.PERSONS.stream()
                .max(Person::ageDifference)
                .ifPresent(eldest -> System.out.println("Eldest: " + eldest.toString()));


        // 2つ以上のプロパティでのソート
        final Function<Person, String> byName = p -> p.getName();
        final Function<Person, Integer> byAge = p -> p.getAge();

        printPeople("Sorted in ascending order by name and age",
                Persons.PERSONS.stream()
                .sorted(Comparator.comparing(byName).thenComparing(byAge))
                .collect(Collectors.toList()));

    }


    public static <T extends Person> void printPeople(
            final String message, final List<T> persons) {
        System.out.println(message);
        persons.forEach(p -> {
//            System.out.println(p.toString());
            System.out.println(p.getName() + ":" + p.toString());

        });
    }
}
