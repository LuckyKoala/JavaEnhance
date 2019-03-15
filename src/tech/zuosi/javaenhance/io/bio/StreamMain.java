package tech.zuosi.javaenhance.io.bio;

import java.io.*;

public class StreamMain {
    public static void main(String[] args) {
        String srcFile = "E:"+File.separator+"io"+File.separator+"88.txt";
        System.out.println(srcFile);
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(srcFile));
            System.out.print(String.format("Double value: %d", dataInputStream.readInt()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
