package tech.zuosi.javaenhance.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by luckykoala on 19-3-15.
 * 经典Reactor模式
 *#######################################################
 *#            =====================================    #
 *#            ==============  Reactor  ============    #
 *#Client ---> =====================================    #
 *#Client ---/  /  ^     ^       ^      ^      ^        #
 *#Client --/  /   |     |       |      |      |        #
 *# ...       /   read decode compute encode send       #
 *#          /     ...  ...    ...     ...    ...       #
 *#   Acceptor                                          #
 *#######################################################
 */
public class NIOServer {
    private static final Logger LOGGER = Logger.getLogger(NIOServer.class.getName());

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        //Socket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(1234));

        LOGGER.info("NIOServer opened!");
        //Select
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
                    //New channel wait to be read
                    SocketChannel socketChannel = acceptServerSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    LOGGER.info("Accept request from " + socketChannel.getRemoteAddress());
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    //Read data from channel
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int count = socketChannel.read(buffer);
                    if (count <= 0) {
                        socketChannel.close();
                        key.cancel();
                        LOGGER.info("Received invalided data, close the connection");
                        continue;
                    }
                    LOGGER.info("Received message " + new String(buffer.array()));
                }
                keys.remove(key);
            }
        }
    }
}
