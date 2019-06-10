package domain.bean;

public class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "domain.bean.Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
