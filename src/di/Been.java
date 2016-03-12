package di;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 11.03.16.
 */
public class Been {
    private String name;
    private String className;
    private List<Option> options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Been{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", options=" + options +
                "}\n";
    }
}
