package j3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumagai on 2017/04/23.
 */
public class GenericStack <E> {
    private List<E> list;

    public GenericStack() {
        this.list = new ArrayList<>();
    }

    public boolean push(E task) {
        return list.add(task);
    }

    public E pop() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.size() -1);
    }
}
