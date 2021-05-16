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

    public void updateAddressBookContact(String firstName, String phoneNumber) {
        int result = AddressBookDB.getInstance().updateAddressBookData(firstName, phoneNumber);
        if (result == 0) return;
        AdderessBookData addressbookdata = this.getAddressBookData(firstName);
        if (addressbookdata != null) addressbookdata.phoneNumber = phoneNumber;
    }

    private AdderessBookData getAddressBookData(String firstName) {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<AdderessBookData> addressbookDataList = addressBookDB.getInstance().readAddressBookData();
        return addressbookDataList.stream()
                .filter(adderessBookDataItem -> adderessBookDataItem.firstName.equalsIgnoreCase(firstName) )
                .findFirst()
                .orElse(null);
    }


    private int updateAddressBookData(String firstName, String phoneNumber) {
        return this.updateAddressbookDataUsingSatement(firstName, phoneNumber);
    }

    private int updateAddressbookDataUsingSatement(String firstName, String phoneNumber) {
        String sql = String.format("UPDATE address_book_table set firstName = '%s' WHERE phoneNumber = '%s';", firstName,phoneNumber);
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public boolean checkAdderessBooksyncwithDB(String firstName) {
        AddressBookDB addressBookDB = new AddressBookDB();
        List<AdderessBookData> addressbookDataList = (List<AdderessBookData>) addressBookDB.getInstance().getAddressBookData(firstName);
        return addressbookDataList.get(0).equals(getAddressBookData(firstName));
    }
}



