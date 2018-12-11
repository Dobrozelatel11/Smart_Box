package entity;

import java.sql.Date;
import java.util.Objects;

public class Purchases {
    private int id_purchase;
    private int id_shop;
    private  String name;
    private float cost;
    private Date date;

    public Purchases() {
    }

    public int getId_purchase() {
        return id_purchase;
    }

    public void setId_purchase(int id_purchase) {
        this.id_purchase = id_purchase;
    }

    public int getId_shop() {
        return id_shop;
    }

    public void setId_shop(int id_shop) {
        this.id_shop = id_shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchases purchases = (Purchases) o;
        return id_purchase == purchases.id_purchase &&
                id_shop == purchases.id_shop &&
                Float.compare(purchases.cost, cost) == 0 &&
                Objects.equals(name, purchases.name) &&
                Objects.equals(date, purchases.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_purchase, id_shop, name, cost, date);
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "id_purchase=" + id_purchase +
                ", id_shop=" + id_shop +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                '}';
    }
}
