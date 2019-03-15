package tech.zuosi.javaenhance.io.bio;

import tech.zuosi.javaenhance.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by luckykoala on 19-3-15.
 * 为每个请求创建一个线程
 */
public class IOServerMultiThread {
    private static final Logger LOGGER = Logger.getLogger(IOServer.class.getName());

    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(1234));
        } catch (IOException ex) {
            LOGGER.throwing(IOServer.class.getName(), "main", ex);
            return;
        }
        LOGGER.info("Multi Thread Server opened!");

        try{
            while(true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        InputStream inputstream = socket.getInputStream();
                        LOGGER.info("Received message " + IOUtils.toString(inputstream));
                        IOUtils.closeQuietly(inputstream);
                    } catch (IOException ex) {
                        LOGGER.throwing(IOServer.class.getName(), "main", ex);
                    }
                }).start();
            }
        } catch(IOException ex) {
            IOUtils.closeQuietly(serverSocket);
            LOGGER.throwing(IOServer.class.getName(), "main", ex);
        }
    }
}
