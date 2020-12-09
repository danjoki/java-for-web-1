import EncryptionLogic.Decrypt;
import EncryptionLogic.Encrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    private static String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T","U", "V","W", "X", "Y", "Z"};

    public static void main(String[] args) throws IOException {
        File rawText = new File("src/main/resources/text.txt");
        Scanner input = new Scanner(rawText);
        String rawString = input.nextLine().toUpperCase();
//        stringValidator(rawString);
        Encrypt encrypt = new Encrypt();
        encrypt.setKey(10);
        encrypt.setInput(rawString);
        Decrypt decrypt = new Decrypt();
        decrypt.setKey(10);
        decrypt.setInput(encrypt.getOutput());
        String fileName = "src/main/resources/encoded.txt";
        File f = new File(fileName);
        if(f.exists() && !f.isDirectory()) {
            writeToFile(rawString, encrypt, decrypt, fileName);
        } else {
            if (f.createNewFile())
                writeToFile(rawString, encrypt, decrypt, fileName);
        }
    }

    private static void writeToFile(String rawString, Encrypt encrypt, Decrypt decrypt, String fileName) throws IOException {
        System.out.println("Please check results on this file: ");
        FileWriter write = new FileWriter(fileName);
        write.write("++++++++++++++++++++++++++++++++++++++++++++++++");
        write.write("\nRaw Text: ".concat(rawString));
        write.write("\nEncoded Text: ".concat(encrypt.getOutput()));
        write.write("\nDecoded Text: ".concat(decrypt.getOutput()));
        write.write("\n++++++++++++++++++++++++++++++++++++++++++++++++\n");
        write.close();
    }

    private static void stringValidator(String text) throws RuntimeException{
        char[] phrase = text.toCharArray();
        for (char letter : phrase){
            for (int i = 0; i<=alphabets.length; i++){
                if (!String.valueOf(letter).equalsIgnoreCase(alphabets[i]))
                    throw new RuntimeException();
            }
        }
    }
}
