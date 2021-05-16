import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBoolDBTest {
   //UC16
    @Test
    public void givenAddressBookInDB_WhenRetribed_ShouldMatchEmployeeCount(){
        AddressBookDB addressBookDB = new AddressBookDB();
        List<AdderessBookData> addressbookData = addressBookDB.getInstance().readAddressBookData();
        Assertions.assertEquals(2,addressbookData.size());
    }

    //Uc17
    @Test
    public void givennewContact_WhenUpdate_ShouldSyncWithDB(){
        AddressBookDB addressBookDB = new AddressBookDB();
        List<AdderessBookData> addressbookData = addressBookDB.getInstance().readAddressBookData();
        addressBookDB.updateAddressBookContact("Atharva,","8989898989");
        boolean check = addressBookDB.checkAdderessBooksyncwithDB("Atharva");
        Assertions.assertTrue(check);

    }

}
