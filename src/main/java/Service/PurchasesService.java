package Service;

import DAO.PurchasesDAO;
import Logic.Util;
import entity.Purchases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchasesService extends Util implements PurchasesDAO {

    private Connection con = getConnection();

    @Override
    public void add(Purchases purch) throws SQLException {
        PreparedStatement ps = null;

        String rq = "INSERT INTO purchases (id_purchases, id_shop, name, cost, date) " +
                "VALUES(?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(rq);

            ps.setInt(1, purch.getId_purchase());
            ps.setInt(2, purch.getId_shop());
            ps.setString(3, purch.getName());
            ps.setFloat(4, purch.getCost());
            ps.setDate(5, purch.getDate());

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
    public List<Purchases> getAll() throws SQLException {
        List<Purchases> plist = new ArrayList<>();

        String rq = "SELECT id_purchase, id_shop, name, cost, date " +
                // "FROM purchases";
                "FROM PUBLIC.purchases";

        Statement st = null;
        try {
            st = con.createStatement();

            ResultSet resultSet = st.executeQuery(rq);

            while (resultSet.next()) {
                Purchases purch = new Purchases();
                purch.setId_purchase(resultSet.getInt("id_purchases"));
                purch.setId_shop(resultSet.getInt("id_shop"));
                purch.setName(resultSet.getString("name"));
                purch.setCost(resultSet.getInt("cost"));
                purch.setDate(resultSet.getDate("date"));

                plist.add(purch);
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
        return plist;
    }

    @Override
    public Purchases getByID(int id) throws SQLException {
        PreparedStatement ps = null;

        String rq = "SELECT id_shop, name, address FROM shops WHERE id_shop=?";

        Purchases purch = new Purchases();
        try {
            ps = con.prepareStatement(rq);
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();

            purch.setId_purchase(resultSet.getInt("id_purchase"));
            purch.setId_shop(resultSet.getInt("id_shop"));
            purch.setName(resultSet.getString("name"));
            purch.setCost(resultSet.getFloat("cost"));
            purch.setDate(resultSet.getDate("date"));

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
        return purch;
    }



    @Override
    public void update(Purchases purch) throws SQLException {
        PreparedStatement ps = null;

        String rq = "UPDATE purchases SET name=?, cost=?, date=?, id_shop=? WHERE id_purchase=?";

        try {
            ps = con.prepareStatement(rq);

            ps.setString(1, purch.getName());
            ps.setFloat(2, purch.getCost());
            ps.setDate(3, purch.getDate());
            ps.setLong(4, purch.getId_shop());
            ps.setLong(5, purch.getId_purchase());

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
    public void delete(Purchases purch) throws SQLException {
        PreparedStatement ps = null;

        String rq = "DELETE FROM purchases WHERE ID=?";

        try {
            ps = con.prepareStatement(rq);

            ps.setInt(1, purch.getId_purchase());

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
