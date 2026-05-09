import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256Ex {
    public static String bytesToHex(byte[] hash) {
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : hash)
            stringBuilder.append(String.format("%01x", b));
        return stringBuilder.toString();
    }

    public static String textToSha256(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedHash);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to save to the file: ");
        String textToWriteToTheFile = scanner.nextLine();

        System.out.println("Hashing text...");
        System.out.println("Saving text to file...");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("writtenText.txt"))) {
            writer.write(textToSha256(textToWriteToTheFile));
        }

        System.out.println("File hashed and saved successfully!");

        System.out.println("--- FILE CONTENTS ---");
        try(BufferedReader reader = new BufferedReader(new FileReader("writtenText.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.print(line);
            }
        }
    }
}