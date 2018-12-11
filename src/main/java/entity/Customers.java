package entity;

import java.util.Objects;

public class Customers {
    private int id_customer;
    private String name;

    public Customers() {
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return id_customer == customers.id_customer &&
                Objects.equals(name, customers.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_customer, name);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id_customer=" + id_customer +
                ", name='" + name + '\'' +
                '}';
    }
}
