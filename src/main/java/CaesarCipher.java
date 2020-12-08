import java.util.Scanner;

public class CaesarCipher {
    private String value;

    public CaesarCipher(){

    }

    public CaesarCipher(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
