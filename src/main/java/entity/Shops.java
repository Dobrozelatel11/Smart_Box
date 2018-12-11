package entity;

import java.util.Objects;

public class Shops {
    private int id_shop;
    private String name;
    private String address;

    public Shops() {
    }

    public int getId() {
        return id_shop;
    }

    public void setId(int id) {
        this.id_shop = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shops shops = (Shops) o;
        return id_shop == shops.id_shop &&
                Objects.equals(name, shops.name) &&
                Objects.equals(address, shops.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_shop, name, address);
    }

    @Override
    public String toString() {
        return "Shops{" +
                "id=" + id_shop +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
