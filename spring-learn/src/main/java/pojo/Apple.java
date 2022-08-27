package pojo;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
public class Apple {


    private String title;

    private String origin;

    private String color;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "title='" + title + '\'' +
                ", origin='" + origin + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
