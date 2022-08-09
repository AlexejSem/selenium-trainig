import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {

    private JsonParser jsonParser;
    private static final String EXPECTED_FILE_CONTENT = "{\"cartName\":\"alex-cart\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";

    @BeforeEach
    public void createData() {
        jsonParser = new JsonParser();
    }

    @Test
    void testWriteToFile() throws IOException {
        jsonParser.writeToFile(new Cart("alex-cart"));
        final String actualFileContent = Files.readString(Path.of("src/main/resources/alex-cart.json"));
        Assertions.assertEquals(EXPECTED_FILE_CONTENT, actualFileContent);
    }

    @Test
    void testReadFromFile() {
        final Cart cart = jsonParser.readFromFile(new File("src/main/resources/andrew-cart.json"));
        Assertions.assertAll(
                () -> Assertions.assertEquals("andrew-cart", cart.getCartName()),
                () -> Assertions.assertEquals(38445.479999999996, cart.getTotalPrice())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "  ",
            "src/main/resources/alexey-cart.json",
            "src/main/resources/andrey-cart.json",
            "src/main/resources/evgen-cart.json",
            "test"})
    void testThrowingNoSuchFileException(String path) {
        Assertions.assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(new File(path)));
    }

    @AfterEach
    public void deleteData() throws IOException {
        Files.deleteIfExists(Path.of("src/main/resources/alex-cart.json"));
    }
}
