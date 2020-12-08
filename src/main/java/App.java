import EncryptionLogic.Encrypt;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Encrypt encrypt = new Encrypt();
        encrypt.setInput("My name is Daniel");
        System.out.println("Output: ".concat(encrypt.getOutput()));
    }
}
