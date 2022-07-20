public class ManageCustomers {

    public void run () {
        DBUtils dbUtils = new MySqlDBUtils();

        dbUtils.printCustomers();
        dbUtils.updateCustomer(80, "New Customer Name");
        dbUtils.printCustomers();

    }

}
