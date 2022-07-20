import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlDBUtils implements DBUtils {

    @Override
    public void printCustomers() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoice_manager?user=root&password=c0nygre");
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM customer");
        ) {

            List<Customer> customers = new ArrayList<>();

            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setAddress1(rs.getString("address1"));
                c.setAddress2(rs.getString("address2"));
                c.setAddress3(rs.getString("address3"));
                c.setAddress4(rs.getString("address4"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setCountry(rs.getString("country"));
                customers.add(c);
            }

            customers.stream().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateCustomer(int customerId, String name) {
        System.out.println("Updating customer");
    }
}
