import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest implements TestLifecycleLogger {

    @Test
    void jsonParserWritingToFile_FileCreated() {
        JsonParser jsonParser = new JsonParser();
        jsonParser.writeToFile(new Cart("alex-cart"));

        File file = new File("src/main/resources/alex-cart.json");
        assertTrue(file.exists());
        file.delete();
    }

    @Test
    @Disabled
    void jsonParserReadFromValidFile_NoException() {
        JsonParser jsonParser = new JsonParser();

        assertDoesNotThrow(() -> jsonParser
                       .readFromFile(new File("src/main/resources/andrew-cart.json")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"src/main/resources/andrew-cart.json", "src/main/resources/eugen-cart.json"})
    void jsonParserReadFromValidFile2_NoException(String input) {
        JsonParser jsonParser = new JsonParser();

        assertDoesNotThrow(() -> jsonParser
                .readFromFile(new File(input)));    }


    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"  ", "src/main/resources/alex-cart.json", "src/main/resources/andrey-cart.json", "src/main/resources/evgen-cart.json"})
    void jsonParserReadFromInvalidFile_NoSuchFileException(String input) {
        JsonParser jsonParser = new JsonParser();
        Exception exception = assertThrows(NoSuchFileException.class, () -> {
            jsonParser.readFromFile(new File(input));
        });

        String expectedMessage = "json not found!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }




}
