import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDB {

    public static AddressBookDB adderessbookDBservice;

    public static AddressBookDB getInstance(){
        if(adderessbookDBservice == null)
            adderessbookDBservice = new AddressBookDB();
        return adderessbookDBservice;
    }

    public List<AdderessBookData> readAddressBookData() {
        String sql = "SELECT * FROM address_book_table; ";
        List<AdderessBookData> contactlist = new ArrayList<>();
        try {
            Connection con = this.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Integer srNo = resultSet.getInt("srNo");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zip = resultSet.getString("zip");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                contactlist.add(new AdderessBookData(srNo,firstName,lastName,address,city,state,zip,phoneNumber,email));
                }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactlist;
    }


    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book?useSSL=false";
        String userName = "root";
        String password = "atharva55";
        System.out.println("Connection to database:" + jdbcURL);
        Connection con;
        con = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is Successfull!!!" +con);
        return con;
    }
}
