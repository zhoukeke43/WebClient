import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Main {

    public static void main(String[] args) throws Exception {

        /*
        //System.out.println("Hello World!");
        //1.通过SocketChannel的open()方法创建一个SocketChannel对象
        SocketChannel socketChannel = SocketChannel.open();
        //2.连接到远程服务器（连接此通道的socket）
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 3333));
        // 3.创建写数据缓存区对象
        ByteBuffer writeBuffer = ByteBuffer.allocate(128);
        writeBuffer.put("hello WebServer this is from WebClient".getBytes());
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        //创建读数据缓存区对象
        ByteBuffer readBuffer = ByteBuffer.allocate(128);
        socketChannel.read(readBuffer);
        //String 字符串常量，不可变；StringBuffer 字符串变量（线程安全），可变；StringBuilder 字符串变量（非线程安全），可变
        StringBuilder stringBuffer=new StringBuilder();
        //4.将Buffer从写模式变为可读模式
        readBuffer.flip();
        while (readBuffer.hasRemaining()) {
            stringBuffer.append((char) readBuffer.get());
        }
        System.out.println("从服务端接收到的数据："+stringBuffer);

        socketChannel.close();
        */


        SocketChannel socketChannel1 = SocketChannel.open();
        socketChannel1.connect(new InetSocketAddress("127.0.0.1", 3333));

        ByteBuffer writeBuffer1 = ByteBuffer.allocate(32);
        ByteBuffer readBuffer1 = ByteBuffer.allocate(32);

        writeBuffer1.put(("hello," + 1).getBytes());
        writeBuffer1.flip();

        SocketChannel socketChannel2 = SocketChannel.open();
        socketChannel2.connect(new InetSocketAddress("127.0.0.1", 3333));

        ByteBuffer writeBuffer2 = ByteBuffer.allocate(32);
        ByteBuffer readBuffer2 = ByteBuffer.allocate(32);

        writeBuffer2.put(("hello," + 2).getBytes());
        writeBuffer2.flip();

        while (true) {
            writeBuffer1.rewind();
            socketChannel1.write(writeBuffer1);
            readBuffer1.clear();
            socketChannel1.read(readBuffer1);

            writeBuffer2.rewind();/**/
            socketChannel2.write(writeBuffer2);
            readBuffer2.clear();
            socketChannel2.read(readBuffer2);

            Thread.sleep(2000);
        }


    }
}
