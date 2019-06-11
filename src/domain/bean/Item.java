package domain.bean;

import java.util.Objects;

public class Item {

    private int id;
    private String name;
    private double unitPrice;
    private int categoryId;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name, double unitPrice, int categoryId) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "domain.bean.Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", categoryId=" + categoryId +
                '}';
    }
}
