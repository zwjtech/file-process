package file;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2019/1/1 0001.
 */
public class FileIoTest {

    @Test
    public void fileReaderTest() throws IOException {
        FileReader fr = new FileReader("E:\\sourceCode\\file-process\\src\\test\\java\\file\\buf.txt");
        int readNum = fr.read();
        System.out.println(readNum);
    }
}
