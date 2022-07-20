import java.sql.*;

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

            while (rs.next()) {
                System.out.println(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateCustomer(int customerId, String name) {
        System.out.println("Updating customer");
    }
}
