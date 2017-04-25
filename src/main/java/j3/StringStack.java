package j3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by kumagai on 2017/04/23.
 */
public class StringStack {
    private List<String> taskList;

    public StringStack() {
        this.taskList = new ArrayList<>();
    }
    public boolean push(String task) {
        return taskList.add(task);
    }

    public Optional<String> pop() {
        if(taskList.isEmpty())
            return Optional.empty();
        else
            return Optional.ofNullable(
                taskList.remove(taskList.size() -1)
        );
    }
}
