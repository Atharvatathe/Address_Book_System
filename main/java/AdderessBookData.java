import java.io.Serializable;

public class AdderessBookData implements Serializable {
    Integer srNo;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;
    String email;

    public AdderessBookData(Integer srNo,String firstName,String lastName,String address,String city,String state,String zip,
                            String phone,String email){
        this.srNo = srNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "SrNo: " +srNo+ "FirstName: " +firstName+ "LastName: " +lastName+ "Adderess: " +address+
                "city: " +city+ "state: " +state+ "zip: " +zip+ "phone: " +phone+ "email" +email ;
    }

}

