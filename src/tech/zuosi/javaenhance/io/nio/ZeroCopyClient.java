package tech.zuosi.javaenhance.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by luckykoala on 19-3-15.
 */
public class ZeroCopyClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(1234);
        socketChannel.connect(address);
        RandomAccessFile file =
                new RandomAccessFile(ZeroCopyClient.class.getResource("README.md").getFile(), "rw");
        FileChannel channel = file.getChannel();
        /*
         * This method is potentially much more efficient than a simple loop
         * that reads from this channel and writes to the target channel.  Many
         * operating systems can transfer bytes directly from the filesystem cache
         * to the target channel without actually copying them.
         */
        channel.transferTo(0, channel.size(), socketChannel);
        channel.close();
        file.close();
        socketChannel.close();
    }
}
