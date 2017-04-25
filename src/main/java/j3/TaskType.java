package j3;

/**
 * Created by kumagai on 2017/04/23.
 */
public enum TaskType {
    PRIVATE("プライベート"),
    WORK("仕事なう"),
    SLEEP("睡眠");

    TaskType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private final String value; // emunのコンストラクタはprivate
};
