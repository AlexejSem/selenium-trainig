import org.testng.Assert;
import org.testng.annotations.*;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class JsonParserTest {

    private JsonParser jsonParser;
    private static final String EXPECTED_FILE_CONTENT = "{\"cartName\":\"alex-cart\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";

    @BeforeMethod
    public void createData() {
        jsonParser = new JsonParser();
    }

    @Test
    void testWriteToFile() throws IOException {
        jsonParser.writeToFile(new Cart("alex-cart"));
        final String actualFileContent = Files.readString(Path.of("src/main/resources/alex-cart.json"));
        Assert.assertEquals(actualFileContent, EXPECTED_FILE_CONTENT);
    }

    @Test(enabled = true)
    void testReadFromFile() {
        final Cart cart = jsonParser.readFromFile(new File("src/main/resources/andrew-cart.json"));
        List<String> actualResult = Arrays.asList(String.valueOf(cart.getCartName()), String.valueOf(cart.getTotalPrice()));
        List<String> expectedResult = Arrays.asList("andrew-cart", String.valueOf(38445.479999999996));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "path", dataProviderClass = StaticProvider.class)
    void testThrowingNoSuchFileException(String path) {
        Assert.assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(new File(path)));
    }

    @AfterMethod
    public void deleteData() throws IOException {
        Files.deleteIfExists(Path.of("src/main/resources/alex-cart.json"));
    }
}
