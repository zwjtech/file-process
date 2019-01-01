import java.io.*;

/**
 * Created by Administrator on 2019/1/1 0001.
 */
public class FileReaderAndWriter {

    public static void main(String[] args) throws IOException {

        //不带缓存
        FileReader fr = new FileReader("test.txt");

        //带缓存读
        BufferedReader br =  new BufferedReader(new FileReader("in.txt"));
        String line = null;
        line = br.readLine();
        //带缓存读
        BufferedReader br0 =  new BufferedReader(new FileReader("in.txt"),1024*8);

        //带缓存读，制定字符编码读
        BufferedReader br1 =  new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("in.txt"),"utf-8"));

        //带缓存写，指定编码写
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("out.txt"),"utf-8"));

    }
}
