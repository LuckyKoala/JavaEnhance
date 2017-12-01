package tech.zuosi.javaenhance.io.streams;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;
        String src = "E:"+ File.separator+"io"+File.separator+"src"+File.separator+"a.txt";
        String dst = "E:"+ File.separator+"io"+File.separator+"dst"+File.separator+"a.txt";

        try {
            inputStream = new FileReader(src);
            outputStream = new FileWriter(dst);

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}