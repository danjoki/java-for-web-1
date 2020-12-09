import EncryptionLogic.Decrypt;
import EncryptionLogic.Encrypt;
import org.junit.Test;

import static org.junit.Assert.*;

public class caesarCipherTest {
    @Test
    public void inputAsString_inputValidation_boolean(){
        String value = "2";
        CaesarCipher caesarCipher = new CaesarCipher();
        caesarCipher.setValue(value);
        assertEquals(value, caesarCipher.getValue());
    }

    @Test
    public void testEncryption_decryptingString_boolean(){
        Encrypt encrypt = new Encrypt();
        encrypt.setKey(23);
        encrypt.setInput("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG");
        String encryptedString = "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";
        assertEquals(encryptedString, encrypt.getOutput());
    }

    @Test
    public void testDecryption_encryptString_boolean(){
        Decrypt decrypt = new Decrypt();
        decrypt.setKey(20);
        decrypt.setInput("GS HUGY CM XUHCYF");
        String rawString = "My name is Daniel".toUpperCase();
        assertEquals(rawString, decrypt.getOutput());
    }

    @Test
    public void testBoth_encryptAndDecrypt_string(){
        String rawString = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG".toUpperCase();
        Encrypt encrypt = new Encrypt();
        encrypt.setKey(23);
        encrypt.setInput(rawString);
        Decrypt decrypt = new Decrypt();
        decrypt.setKey(23);
        decrypt.setInput(encrypt.getOutput());
        assertEquals(rawString, decrypt.getOutput());
    }
}