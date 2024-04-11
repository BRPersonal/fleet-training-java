package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

@Slf4j
public class ExerciseFour implements Runnable
{
    @Override
    public void run()
    {
        System.out.print("Enter file path:");
        Scanner in = new Scanner(System.in);
        String filePath = in.nextLine();
        String commitHash = createCommitHash(filePath);
        log.debug("hash={}", commitHash);

    }

    private  String createCommitHash(String filePath)
    {
        try
        {
            // Read file content
            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));

            // Create a SHA-1 MessageDigest
            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            // Update the digest using the file content
            digest.update(fileContent);

            // Complete the hash computation
            byte[] hashBytes = digest.digest();

            // Convert the byte array into a hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
