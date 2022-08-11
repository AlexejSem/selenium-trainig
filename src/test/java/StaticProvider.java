import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "path",parallel = true)
    public static Object[][] createData() {
        return new Object[][]{
                new Object[]{new String(" ")}
                ,{("src/main/resources/alexey-cart.json")}
                ,{("src/main/resources/andrey-cart.json")}
                ,{("src/main/resources/evgen-cart.json")}
                ,{("test")}
        };
    }
}

