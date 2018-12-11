import Logic.Util;
import Service.Cust_purchService;
import Service.CustomersService;
import Service.PurchasesService;
import Service.ShopsService;
import entity.Cust_purch;
import entity.Customers;
import entity.Purchases;
import entity.Shops;

public class Smart {
    public static void main(String[] args) {
      /*  Util util = new Util();
        util.getConnection();*/
        ShopsService sServ= new ShopsService();
        CustomersService cServ = new CustomersService();
        PurchasesService pServ = new PurchasesService();
        Cust_purchService cpServ = new Cust_purchService();

        Shops sh = new Shops();

        Purchases purch = new Purchases();

        Customers cust = new Customers();

        Cust_purch cp = new Cust_purch();

    }
}
