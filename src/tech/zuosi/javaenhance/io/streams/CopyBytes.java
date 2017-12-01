package tech.zuosi.javaenhance.io.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;
        String src = "E:"+ File.separator+"io"+File.separator+"src"+File.separator+"a.txt";
        String dst = "E:"+ File.separator+"io"+File.separator+"dst"+File.separator+"a.txt";

        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dst);
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
