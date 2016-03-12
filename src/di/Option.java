package di;

/**
 * Created by sa on 11.03.16.
 */
public class Option {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Option{" +
                "name='" + name + '\'' +
                "}\n";
    }
}
