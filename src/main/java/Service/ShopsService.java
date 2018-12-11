package Service;

import DAO.ShopsDAO;
import Logic.Util;
import entity.Shops;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopsService extends Util implements ShopsDAO {

    Connection con = getConnection();

    @Override
    public void add(Shops shop) throws SQLException {

        PreparedStatement ps = null;
        String rq = "INSERT  INTO SHOPS (id_shop, name, address) VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(rq);
            ps.setInt(1, shop.getId());
            ps.setString(2, shop.getName());
            ps.setString(3, shop.getAddress());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }

    }

    @Override
    public List<Shops> getAll() throws SQLException {
        List<Shops> slist = new ArrayList<>();

        String rq = "SELECT id_shop, name, address FROM Shops";

        Statement st = null;
        try {
            st = con.createStatement();

            ResultSet resultSet = st.executeQuery(rq);

            while (resultSet.next()) {
                Shops shop = new Shops();
                shop.setId(resultSet.getInt("id_shop"));
                shop.setAddress(resultSet.getString("address"));
                shop.setName(resultSet.getString("name"));

                slist.add(shop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                st.close();
            }
        }
        return slist;
    }

    @Override
    public Shops getByID(int id) throws SQLException {
        PreparedStatement ps = null;

        String rq = "SELECT id_shop, name, address FROM shops WHERE ID=?";

        Shops shop = new Shops();
        try {
            ps = con.prepareStatement(rq);
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();

            shop.setId(resultSet.getInt("ID"));
            shop.setName(resultSet.getString("name"));
            shop.setAddress(resultSet.getString("address"));

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
        return shop;
    }

    @Override
    public void update(Shops shop) throws SQLException {
        PreparedStatement ps = null;

        String rq = "UPDATE shops SET name=?, address=?WHERE ID=?";

        try {
            ps = con.prepareStatement(rq);

            ps.setString(1, shop.getName());
            ps.setString(2, shop.getAddress());

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
    public void delete(Shops shop) throws SQLException {
        PreparedStatement ps = null;

        String rq = "DELETE FROM shops WHERE ID=?";

        try {
            ps = con.prepareStatement(rq);

            ps.setLong(1, shop.getId());

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
