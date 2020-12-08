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
    public void testEncryption_encryptionValidation_boolean(){
        Encrypt encrypt = new Encrypt();
        String input = "My name is Daniel";
        encrypt.setInput(input);
        String encryptedString = "GS HUGY CM XUqHCYF";
        assertEquals(encryptedString, encrypt.getOutput());
    }
}