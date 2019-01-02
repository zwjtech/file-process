package file;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2019/1/1 0001.
 */
public class FileIoTest {

    @Test
    public void fileReaderTest() throws IOException {
        FileReader fr = new FileReader("E:\\sourceCode\\file-process\\src\\test\\java\\file\\buf.txt");
        //读一个
        int readNum = fr.read();
        System.out.print(readNum);
        System.out.print((char)readNum);
        //读下一个
        int readNum1 = fr.read();
        System.out.print(readNum1);
        System.out.print((char)readNum1);

        int chNum = 0;
        while( chNum != -1){
            chNum = fr.read();
            System.out.print((char)chNum);
        }
        fr.close();
    }

    @Test
    public void fileReaderTest1() throws IOException {
        FileReader fr = new FileReader("E:\\sourceCode\\file-process\\src\\test\\java\\file\\buf.txt");
        // type arrayName[] = new type[arraySize];
        char buf[] = new char[1024];
        while( fr.read(buf) != -1){
            System.out.print(new String(buf));
        }
        fr.close();
    }

    @Test
    public void bufferedFileReaderTest() throws IOException {
        BufferedReader in = new BufferedReader(
                new FileReader("E:\\sourceCode\\file-process\\src\\test\\java\\file\\buf.txt"));
        String line = null;
        while ((line = in.readLine()) !=null){
            System.out.print(line);
        }

        in.close();
    }


}
