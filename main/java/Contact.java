import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Contact {
    protected static Map<String,AddressBook> multipleBooks = new HashMap<String,AddressBook>();

    protected static ArrayList<String> first_name = new ArrayList<String>();
    protected static ArrayList<String> last_Name = new ArrayList<String>();
    protected static ArrayList<String> address = new ArrayList<String>();
    protected static ArrayList<String> city = new ArrayList<String>();
    protected static ArrayList<String> state = new ArrayList<String>();
    protected static ArrayList<String> zip = new ArrayList<String>();
    protected static ArrayList<String> phone = new ArrayList<String>();
    protected static ArrayList<String> email = new ArrayList<String>();

    @Override
    public String toString() {
        return "FirstName: " +first_name+ "LastName: " +last_Name+ "Adderess: " +address+
                "city: " +city+ "state: " +state+ "zip: " +zip+ "phone: " +phone+ "email" +email ;
    }
}
