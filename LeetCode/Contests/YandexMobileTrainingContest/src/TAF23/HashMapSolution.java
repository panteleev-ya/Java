package TAF23;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSolution {
    public static void main(String[] args) throws IOException {
//        BufferedInputStream binaryFile = new BufferedInputStream(new FileInputStream("D:\\DiskApps\\Programming\\GitRepos\\Java\\LeetCode\\Contests\\YandexMobileTrainingContest\\src\\TAF23\\sample.taf23"));
        BufferedInputStream binaryFile = new BufferedInputStream(new FileInputStream("input.txt"));
        String response = "OK";
        int index = 0;

        // Stores list[0] = 1 if it only appears as start of section (example: 0)
        // Stores list[1] = 1 if it appears also as pointing index
        // Returns "data loss" if pointer is pointing at non-existent index
        // (if list[0] = 0; list[1] = 1;)
        HashMap<Integer, List<Boolean>> indexes = new HashMap<>();

        while (binaryFile.available() > 0) {
            int sectionStartIndex = index;
            List<Boolean> existingNotPointedAt = new ArrayList<>(2);
            existingNotPointedAt.add(true);
            existingNotPointedAt.add(false);
            indexes.putIfAbsent(sectionStartIndex, existingNotPointedAt);
            indexes.get(sectionStartIndex).set(0, true);

            int memorySectionSize = 0;

            // Read section size
            if (binaryFile.available() >= 4) {
                index += 4;
                byte[] sectionSize = new byte[4];
                binaryFile.read(sectionSize);
                reverseByteArray(sectionSize);
                memorySectionSize = ByteBuffer.wrap(sectionSize).getInt();
            } else {
                response = "data loss";
            }

            // Read stored data
            if (binaryFile.available() >= memorySectionSize) {
                index += memorySectionSize;
                byte[] someData = new byte[memorySectionSize];
                binaryFile.read(someData);
            } else {
                response = "data loss";
            }

            // Read next index
            if (binaryFile.available() >= 4) {
                index += 4;
                byte[] indexBytes = new byte[4];
                binaryFile.read(indexBytes);
                reverseByteArray(indexBytes);
                int pointingIndex = ByteBuffer.wrap(indexBytes).getInt();
                List<Boolean> notExistingPointedAt = new ArrayList<>(2);
                notExistingPointedAt.add(false);
                notExistingPointedAt.add(true);
                indexes.putIfAbsent(pointingIndex, notExistingPointedAt);
                indexes.get(pointingIndex).set(1, true);
            }
        }

        for (Map.Entry<Integer, List<Boolean>> pair: indexes.entrySet()) {
            List<Boolean> existsAndPointedAt = pair.getValue();
            if (!existsAndPointedAt.get(0) || !existsAndPointedAt.get(1)) {
                response = "not a ring buffer";
                break;
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
