package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) {
        String filename = "test.exe"; // test.exe is the name or path to an executable file
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes){
            outputStringBuilder.append((char)b);
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}
