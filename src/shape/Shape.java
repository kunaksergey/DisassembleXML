package shape;

import java.util.List;

/**
 * Created by sa on 11.03.16.
 */
public abstract class Shape {
    protected int angle;
    protected List<Point> points;
    protected String name;

    public Shape() {
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    public int getAngle() {
        return angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "points=" + points +
                ", angle=" + angle +
                ", name='" + name + '\'' +
                '}';
    }
}
