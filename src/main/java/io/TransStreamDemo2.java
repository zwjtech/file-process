package io;

/**
 * Created by Administrator on 2019/1/1 0001.
 */
import java.io.*;


/*

IO流的操作规律。
三个明确：

1，明确源(读)和目的(写)。
		其实就是在明确输入流还是输出流。
		源：输入流 InputStream  Reader
		目的：输出流 OutputStream  Writer


2，明确操作的数据内容。
		其实就是在明确字符流还是字节流。
		如果数据都是纯文本数据使用字符流。
		如果数据是非文本数据使用字节流。

前两步已经明确了使用哪一个体系。


3，明确具体的设备。
	明确使用的具体对象。

	源设备：内存，键盘(System.in)，硬盘(文本)(File)。
	目的设备：内存，控制台(System.out)，硬盘(文件)(File).

扩展部分：需要进行高效操作吗？
	是：加入缓冲区技术(Buffered)。





--------------------------------------------------
需求1：
读取键盘，并键盘录入的数据变成大写打印在控制台上。

自己动手完成分析步骤。




需求2：
读取键盘录入数据，将数据变成大写，保存到一个文件中。

分析：
源：键盘，InputStream。Reader
是纯文本数据:Reader.
设备：System.in.

已经明确了使用读取字符流体系，可是设备是键盘System.in是读取字节流对象。
这时就需要将字节流转成字符流。用到了InputStreamReader.

需要高效吗？需要。Buffered

BufferedReader bufr =
		new BufferedReader(new InputStreamReader(System.in));
大家记住，以后老师在说读键盘录入，就写这句代码！


目的：硬盘，OutputStream Writer
纯文本？yes Writer
设备：硬盘文件 FileWriter。
缓冲，yes

BufferedWriter bufw = new BufferedWriter(new FileWriter("a.txt"));
BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt")));
BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt"),"GBK"));
这三句都是等效的。使用都是默认的编码表GBK.

另加一个需求？
想要将录入的数据按照UTF-8另一个编码表的形式进行数据的存储。
那么目的就要变化了，因为FileWriter，虽然可以作为文件目的对象，但是该对象中的编码表是默认的GBK。
当想要指定编码表时，必须要使用转换流。
BufferedWriter bufw =
	BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt"),"UTF-8"));


##############################################
#记住：凡是涉及到编码转换的操作，            #
#一定要想到转换流，如果只用默认码表，		 #
#可是使用转换流的子类FileWriter或FileReader. #
##############################################


-----------------------------------------------------


需求3：
读取一个文本文件，将文本文件的数据展现在控制台上。
分析：
源：硬盘文件。InputStream Reader。
纯文本？yes  Reader。
设备：硬盘 FileReader.
缓冲？yes  BufferedReader

BufferedReader bufr = new BufferedReader(new FileReader("a.txt"));

目的：OutputStream  Writer
纯文本?yes  Writer.
设备：控制台 System.out.

发现控制台的对象是System.out.是字节输出流。
因为是纯文本数据，使用Writer所以可以将字符流转成成字节串流。
使用了转换流 OutputStreamWriter

需要高效吗？需要。

BufferedWriter bufw =
	new BufferedWriter(new OutputStreamWriter(System.out));


---------------------------------------------------


需求4：
读取一个文本文件，将数据变成大写，存到一个文件中。

分析：
源？目的？
源：一个硬盘文件。就明确了要使用InputStream  Reader
是纯文本的吗？是，就进一步明确了使用Reader.
什么设备：硬盘文件。在进一步明确了使用Reader体系中FileReader

FileReader fr = new FileReader("a.txt");

需要提高效率吗？需要！
BufferedReader bufr = new BufferedReader(fr);



目的：一个硬盘文件。使用体系 OutputStream Writer
是纯文本吗？是，使用Writer。
目的设备：硬盘文件.使用FileWriter.

FileWriter fw = new FileWriter("b.txt");

需要高效吗？需要!
BufferedWriter bufw = new BufferedWriter(fw);

*/

class  TransStreamDemo2
{
    public static void main(String[] args)throws IOException
    {

		/*
		InputStream in = System.in;

		//需要将字节流转成字符流。
		InputStreamReader isr = new InputStreamReader(in);

		//使用缓冲区的readLine
		BufferedReader bufr = new BufferedReader(isr);


		OutputStream out = System.out;

		OutputStreamWriter osw = new OutputStreamWriter(out);


		BufferedWriter bufw = new BufferedWriter(osw);
		*/


        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(new FileInputStream("LineNumberReaderDemo.java")));

        BufferedWriter bufw =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copyLine.txt")));

        String line  = null;

        while((line=bufr.readLine())!=null)
        {

            if("over".equals(line))
                break;
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();

        }
        bufw.close();
        bufr.close();

    }
}
/*

c:\abc
c:\abc\haah
c:\abc\0.mp3    "c:\abc\0.mp3"--replace("c:\abc","d:\qq\abc")->"d:\qq\abc\0.mp3"

new FileInputStream("c:\abc\0.mp3");

new FileOutputStream("d:\qq\abc\0.mp3");


d:\qq\
d:\qq\abc\haah
d:\qq\abc\0.mp3





d:\qq\
d:\qq\abc
d:\qq\abc\0.mp3

*/


