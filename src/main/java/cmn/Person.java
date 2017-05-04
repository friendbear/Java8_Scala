package cmn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Optional;

/**
 * Created by kumagai on 2017/05/03.
 */
//@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Getter
    private final String name;
    @Getter
    private final Integer age;

    // Comparators
    public int ageDifference(final Person other) {
        return this.age - other.age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
