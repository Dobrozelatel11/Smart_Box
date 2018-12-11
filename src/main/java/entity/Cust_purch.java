package entity;

import java.util.Objects;

public class Cust_purch {
    private int id_customer;
    private int id_purchase;

    public Cust_purch() {
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_purchase() {
        return id_purchase;
    }

    public void setId_purchase(int id_purchase) {
        this.id_purchase = id_purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cust_purch that = (Cust_purch) o;
        return id_customer == that.id_customer &&
                id_purchase == that.id_purchase;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_customer, id_purchase);
    }

    @Override
    public String toString() {
        return "Cust_purch{" +
                "id_customer=" + id_customer +
                ", id_purchase=" + id_purchase +
                '}';
    }
}
