package Service;

import DAO.CustomersDAO;
import Logic.Util;
import entity.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersService extends  Util implements  CustomersDAO{

    private Connection con = getConnection();
    @Override
    public void add(Customers cust) throws SQLException {
        PreparedStatement ps = null;

        String rq = "INSERT INTO customers (id_customer, name) VALUES(?, ?)";

        try {
            ps = con.prepareStatement(rq);

            ps.setLong(1, cust.getId_customer());
            ps.setString(2, cust.getName());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                ps.close();
            }
        }

    }

    @Override
    public List<Customers> getAll() throws SQLException {
        List<Customers> clist = new ArrayList<>();

        String rq = "SELECT id_customer, name FROM customers";

        Statement st = null;
        try {
            st = con.createStatement();

            ResultSet resultSet = st.executeQuery(rq);

            while (resultSet.next()) {
                Customers cust = new Customers();
                cust.setId_customer(resultSet.getInt("id_customer"));
                cust.setName(resultSet.getString("name"));

                clist.add(cust);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return clist;
    }

    @Override
    public Customers getByID(int id) throws SQLException {
        PreparedStatement ps = null;

        String rq = "SELECT id_customer, name FROM customers WHERE id_customer=?";

        Customers cust = new Customers();
        try {
            ps = con.prepareStatement(rq);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();

            cust.setId_customer(resultSet.getInt("id_customer"));
            cust.setName(resultSet.getString("name"));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return cust;
    }

    @Override
    public void update(Customers cust) throws SQLException {
        PreparedStatement ps = null;

        String rq = "UPDATE customers SET name=? WHERE id_customer=?";

        try {
            ps = con.prepareStatement(rq);

            ps.setString(1, cust.getName());
            ps.setInt(2, cust.getId_customer());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    @Override
    public void delete(Customers cust) throws SQLException {
        PreparedStatement ps = null;

        String rq = "DELETE FROM customers WHERE id_customer=?";

        try {
            ps = con.prepareStatement(rq);

            ps.setLong(1, cust.getId_customer());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }
}
