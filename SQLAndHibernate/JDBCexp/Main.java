import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "Rex9zxuu5r";

        try {

            java.sql.Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name," +
                    " COUNT(DISTINCT subscription_date) / (MAX(MONTH(subscription_date)) - min(MONTH(subscription_date)))" +
                    "as `per_month`\n" +
                    "FROM PurchaseList\n" +
                    "group by course_name");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String per_month = resultSet.getString("per_month");
                System.out.println(courseName + " - " + per_month);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
