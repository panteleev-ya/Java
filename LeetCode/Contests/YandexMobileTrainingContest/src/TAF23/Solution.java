package TAF23;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream binaryFile = new BufferedInputStream(new FileInputStream("D:\\DiskApps\\Programming\\GitRepos\\Java\\LeetCode\\Contests\\YandexMobileTrainingContest\\src\\TAF23\\sample.taf23"));
//        BufferedInputStream binaryFile = new BufferedInputStream(new FileInputStream("input.txt"));

        String response = "OK";
        int index = 0;

        while (binaryFile.available() > 0) {
            int memorySectionSize = 0;

            // Read section size
            if (binaryFile.available() >= 4) {
                byte[] sectionSize = new byte[4];
                binaryFile.read(sectionSize);
                reverseByteArray(sectionSize);
                memorySectionSize = ByteBuffer.wrap(sectionSize).getInt();
            } else {
                response = "data loss";
            }

            // Read stored data
            if (binaryFile.available() >= memorySectionSize) {
                byte[] someData = new byte[memorySectionSize];
                binaryFile.read(someData);
            } else {
                response = "data loss";
            }

            // Read next index
            if (binaryFile.available() >= 4) {
                byte[] indexBytes = new byte[4];
                binaryFile.read(indexBytes);
                reverseByteArray(indexBytes);
                int nextIndex = ByteBuffer.wrap(indexBytes).getInt();
                if (!(nextIndex - index == 1 || (nextIndex == 0 && binaryFile.available() == 0))) {
                    response = "not a ring buffer";
                    break;
                }
            } else {
                response = "data loss";
            }
        }

        System.out.println(response);
        binaryFile.close();
    }

    private static void reverseByteArray(byte[] bytes) {
        for (int i = 0; i < (bytes.length + 1) / 2; i++) {
            byte tmp = bytes[i];
            bytes[i] = bytes[bytes.length - 1 - i];
            bytes[bytes.length - 1 - i] = tmp;
        }
    }
}
