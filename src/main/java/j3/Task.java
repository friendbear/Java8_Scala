package j3;

import java.util.UUID;

/**
 * Created by kumagai on 2017/04/23.
 */
public class Task {
    private String id;
    private TaskType type; // enum型のTaskTypeとして宣言

    private String body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Task(TaskType type, String body) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.body = body;
    }
}
