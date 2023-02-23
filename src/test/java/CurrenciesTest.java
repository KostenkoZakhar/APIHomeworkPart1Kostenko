import models.exchanges.Currencies;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.RestGet;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CurrenciesTest {
    static JSONArray jsonArray;
    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(Currencies.values());
    }

    public CurrenciesTest(Currencies currencies){
        String response = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=" + currencies.getNationalCurrency() + "&json");
        jsonArray=new JSONArray(response);
    }
    @Test
    public void test1(){
        for(int i=0;i< jsonArray.length();i++){
            Assert.assertNotNull("Field is empty",jsonArray.getJSONObject(i).get("cc"));
            System.out.println("cc = " + jsonArray.getJSONObject(i).get("cc"));
        }
    }
}
