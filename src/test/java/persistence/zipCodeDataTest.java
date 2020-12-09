package persistence;

import com.zipcodeapi.ZipCodesItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class zipCodeDataTest {


    //@Test
    void getResponseSuccess() {
        zipCodeDataDao dao = new zipCodeDataDao();
        List<String> myZips = new ArrayList<String>();
        myZips.add("53701");
        myZips.add("53702");
        myZips.add("53707");
        myZips.add("53708");
        myZips.add("53725");
        myZips.add("53744");
        myZips.add("53777");
        myZips.add("53778");
        myZips.add("53779");
        myZips.add("53782");
        myZips.add("53783");
        myZips.add("53784");
        myZips.add("53785");
        myZips.add("53786");
        myZips.add("53788");
        myZips.add("53789");
        myZips.add("53790");
        myZips.add("53791");
        myZips.add("53793");
        myZips.add("53794");
        myZips.add("53703");
        myZips.add("53718");
        myZips.add("53714");
        myZips.add("53704");
        List<ZipCodesItem> apiZipCodes = dao.getResponses("/53704/5/mile").getZipCodes();
        for (int i=0; i < apiZipCodes.size(); i++) {
            String myZip = myZips.get(i);
            String apiZip = apiZipCodes.get(i).getZipCode();
            assertEquals(myZip,apiZip); //picked a small radius here so all of these are inside Madison

        }

    }

}
