import EncryptionLogic.Decrypt;
import EncryptionLogic.Encrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    private static String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T","U", "V","W", "X", "Y", "Z"};

    public static void main(String[] args) throws FileNotFoundException {
        File content = new File("src/main/resources/text.txt");
        Scanner input = new Scanner(content);
        String rawString = input.nextLine().toUpperCase();
//        stringValidator(rawString);
        Encrypt encrypt = new Encrypt();
        encrypt.setKey(10);
        encrypt.setInput(rawString);
        Decrypt decrypt = new Decrypt();
        decrypt.setKey(10);
        decrypt.setInput(encrypt.getOutput());
        System.out.println("Input String: ".concat(rawString)
                .concat("\n Encrypted String: ").concat(encrypt.getOutput())
                .concat("\n Decrypted String: ").concat(decrypt.getOutput()));
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
