package j3;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

/**
 * Created by kumagai on 2017/04/23.
 */
public class Point {
    private final int x;
    private final int y;
    private final InnerPoint point = new InnerPoint(0, 0);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {

        // HOWTO: StringBuilderをメソッドチェイン形式で利用する方法
        StringBuilder builder = new StringBuilder();
        builder.append("Point [x=").append(x).append(", y=").append(y).append("]");

        return builder.toString() + this.point.toString();
    }

    class InnerPoint {
        private final int x;
        private final int y;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        InnerPoint(int x, int y) {
            this.x = x;

            this.y = y;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    /** Objects.hashを使ってハッシュコードを生成するトレーニング
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

}
