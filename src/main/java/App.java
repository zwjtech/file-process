import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2019/1/1 0001.
 */
public class App {
    public static void main(String[] args) {
        Path path = Paths.get("file path");
        try {

            byte[] data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
