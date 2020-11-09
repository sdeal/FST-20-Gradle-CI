import de.unitrier.st.core.CountryDataPoint;
import de.unitrier.st.core.DataLoader;
import de.unitrier.st.core.DataParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DataTest {

    private String json;
    private Map<String, List<CountryDataPoint>> countries;

    @Before
    public void setUp() {
        DataLoader dataLoader = new DataLoader();
        DataParser dataParser = new DataParser();
        json = dataLoader.loadJsonFile("countries-aggregated_json.json");
        countries = dataParser.parseJsonData(json);
    }

    @Test
    public void fileLoadingTest() {
        Assert.assertEquals(json.length(), 5373232);
    }

    @Test
    public void dataParsingTest() {
        Assert.assertEquals(190 ,countries.size());
    }

    @Test
    public void germanyParsingTest() {
        Assert.assertEquals(291, countries.get("Germany").size());
    }
}
