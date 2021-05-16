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

}
