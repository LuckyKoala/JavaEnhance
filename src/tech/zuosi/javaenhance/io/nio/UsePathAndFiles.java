package tech.zuosi.javaenhance.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 * Created by iwar on 2017/6/12.
 */
public class UsePathAndFiles {
    public static void main(String[] args) {
        Path ioDir = Paths.get("E:\\io");
        Path dataDir = ioDir.resolve("data");
        Path dataFile = dataDir.resolve("data.lk");

        try {
            if(Files.notExists(dataDir)) {
                Files.createDirectory(dataDir);
            }
            if(Files.notExists(dataFile)) {
                Files.createFile(dataFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(Files.exists(dataFile)) {
            Entity originalEntity = new Entity("John Doe", 1,2, 3.2);
            //Write
            try {
                Files.write(dataFile, originalEntity.toString().getBytes(Charset.forName("UTF-8")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Read
            try {
                byte data[] = Files.readAllBytes(dataFile);
                String dataStr = new String(data, Charset.forName("UTF-8"));
                Entity entity = Entity.of(dataStr);
                System.out.println(entity.toString().equals(originalEntity.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
