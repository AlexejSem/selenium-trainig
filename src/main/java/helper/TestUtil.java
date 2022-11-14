package helper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestUtil {

    public static final String USERS_PATH = "src/test/resources/users.json";
    private static List<User> users = new ArrayList<>();

    static {
        ObjectMapper mapper = new ObjectMapper();
        try {
            users = Arrays.asList(mapper.readValue(new File(USERS_PATH), User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User getUser(int userNumber) {
        return users.get(userNumber);
    }

    public static double priceParser(String price) {
        return Double.parseDouble(price.replace("$", ""));
    }

    public static int randomInt() {
        return new Random().nextInt(10);
    }

}
