package io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
FileWriter
FileReader
BufferedWriter
BufferedReader


FileInputStream
FileOutputStream
BufferedInputStream
BufferedOutputStream


如何将字节流和字符流之间做着转换呢？
转换流。

InputStreamReader:字节到字符的桥梁。
OutputStreamWriter：字符到字节的桥梁。

转换流的特点在于该流中定义了将字节转换成字符的编码表。

该流完成编码转换动作，那么它的子类FileReader或者FileWriter。
就可以直接使用父类中的方法。进行文本数据的读取。

所不同的是，FileReader和FileWriter内部使用了默认的编码表，在本机中是GBK。

而父类转换流，就可以使用默认码表，也可以指定编码表。


*/
class  TransStreamDemo
{
    public static void main(String[] args) throws IOException
    {
        //发现读取键盘的方式，和readLine的功能是一致的。
        //那么已经有这个功能，直接去使用即可。
        //但是很遗憾。System.in。是字节读取流。
        //readLine是BufferedReader字符流对象的方法。

        //键盘录入。
        InputStream in = System.in;

        //需要将字节流转成字符流。
        InputStreamReader isr = new InputStreamReader(in);

        //使用缓冲区的readLine
        BufferedReader bufr = new BufferedReader(isr);

        String line  = null;

        while((line=bufr.readLine())!=null)
        {

            if("over".equals(line))
                break;
            System.out.println(line.toUpperCase());

        }
        bufr.close();
    }

	/*
	获取键盘录入的数据，
	将录入的一行数据转成大写后，打印在控制台。
	如果录入的数据是over。那么录入程序结束。

	键盘录入使用的是System.in

	*/

    public static void readKey()throws IOException
    {
        int ch = 0;

        InputStream in = System.in;

        StringBuilder sb = new StringBuilder();

        while(true)
        {
            ch = in.read();

            if(ch=='\r')
                continue;
            if(ch=='\n')
            {
                String s = sb.toString();
                sb = sb.delete(0,sb.length());
                if(s.equals("over"))
                    return;
                System.out.println(s.toUpperCase());
            }
            else
                sb.append((char)ch);
        }

    }

}
