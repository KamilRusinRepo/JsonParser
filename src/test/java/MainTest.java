import org.json.parser.Main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testValidResourceField() {
        String path = "src/main/resources/awsFile.json";
        boolean result = Main.checkResourceField(path);
        assertFalse(result);
    }

    @Test
    public void testInvalidResourceField() {
        String path = "src/test/java/testAwsFile.json";
        boolean result = Main.checkResourceField(path);
        assertTrue(result);
    }

    @Test
    public void testInvalidFile() {
        String path = "src/test/java/testAwsFil.json";
        boolean result = Main.checkResourceField(path);
        assertTrue(result);
    }

}
