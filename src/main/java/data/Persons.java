package data;

import cmn.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kumagai on 2017/05/03.
 */
public class Persons {
    public final static List<Person> PERSONS = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("クマガイ", 43),
            new Person("Greg", 35)
    );
}
