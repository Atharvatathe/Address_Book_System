import java.io.Serializable;
import java.util.Objects;

public class AdderessBookData implements Serializable {
    Integer srNo;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;

    public AdderessBookData(Integer srNo,String firstName,String lastName,String address,String city,String state,String zip,
                            String phoneNumber,String email){
        this.srNo = srNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "SrNo: " +srNo+ "FirstName: " +firstName+ "LastName: " +lastName+ "Adderess: " +address+
                "city: " +city+ "state: " +state+ "zip: " +zip+ "phone: " +phoneNumber+ "email" +email ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdderessBookData that = (AdderessBookData) o;
        return Objects.equals(srNo, that.srNo) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) &&
                Objects.equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(srNo, firstName, lastName, address, phoneNumber, email);
    }
}

