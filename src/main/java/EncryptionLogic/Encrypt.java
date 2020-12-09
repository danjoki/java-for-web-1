package EncryptionLogic;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Encrypt {
    private String input;
    private String output;
    private int key;
    private String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T","U", "V","W", "X", "Y", "Z"};

    public Encrypt() {
    }

    public Encrypt(int key) {
        this.key = key;
    }

    public Encrypt(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        setOutput(input);
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String input) {
        this.output = encryptString(input);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    private String encryptString(String input){
        String phrase = input.toUpperCase();
        String output = "";
        int index = 0;
        try {
            char[] inputSplit = phrase.toCharArray();
            for (char letter : inputSplit){
                String theletter = String.valueOf(letter);
                if (theletter.equals(" ") || !arrayToList(alphabets).contains(theletter)) {
                    output = output + " ";
                } else {
                    for (int i = 0; i <= alphabets.length; i++) {
                        if (theletter.equalsIgnoreCase(alphabets[i])) {
                            index = i + getKey();
                            if (index >= alphabets.length)
                                output = output + alphabets[index - alphabets.length];
                            else
                                output = output + alphabets[index];
                            break;
                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Out: ".concat(output));
        return output;
    }

    private List<String> arrayToList(String[] alphabets){
        List<String> list = new ArrayList<>();
        for (String letter : alphabets){
            list.add(letter);
        }
        return list;
    }
}
