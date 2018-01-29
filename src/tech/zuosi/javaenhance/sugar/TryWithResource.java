package tech.zuosi.javaenhance.sugar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class TryWithResource {
    void sugar(String zipFileName, String outputFileName) throws java.io.IOException {

        Charset charset = StandardCharsets.US_ASCII;
        Path outputFilePath = Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement

        try (
                ZipFile zf = new ZipFile(zipFileName);
                BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName = ((ZipEntry)entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

    //Code which is decompiled from class file
    void actual(String zipFileName, String outputFileName) throws IOException {
        Charset charset = StandardCharsets.US_ASCII;
        Path outputFilePath = Paths.get(outputFileName);
        ZipFile zf = new ZipFile(zipFileName);
        Throwable var5 = null;

        try {
            BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset);
            Throwable var7 = null;

            try {
                Enumeration entries = zf.entries();

                while(entries.hasMoreElements()) {
                    String newLine = System.getProperty("line.separator");
                    String zipEntryName = ((ZipEntry)entries.nextElement()).getName() + newLine;
                    writer.write(zipEntryName, 0, zipEntryName.length());
                }
            } catch (Throwable var32) {
                var7 = var32;
                throw var32;
            } finally {
                if (writer != null) {
                    if (var7 != null) {
                        try {
                            writer.close();
                        } catch (Throwable var31) {
                            var7.addSuppressed(var31);
                        }
                    } else {
                        writer.close();
                    }
                }

            }
        } catch (Throwable var34) {
            var5 = var34;
            throw var34;
        } finally {
            if (zf != null) {
                if (var5 != null) {
                    try {
                        zf.close();
                    } catch (Throwable var30) {
                        var5.addSuppressed(var30);
                    }
                } else {
                    zf.close();
                }
            }

        }

    }
}
