import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleJava {
    
    public void getTenRolls() {
    // public static void main(String[] args) {
        Random randMachine = new Random();
        ArrayList<Integer> tenRolls = new ArrayList<Integer>();
        for (int i=1; i<=10; i++) {
            tenRolls.add(randMachine.nextInt(20)+1);
        }
        System.out.println(tenRolls);
    }

    public void alphabet() {
    // public static void main(String[] args) {
        Random randMachine = new Random();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }
        System.out.println(alphabet);
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        int randomVal = randMachine.nextInt(25);
        System.out.println(alphabet.get(randomVal));
    }

    public void generatePassword() {
    // public static void main(String[] args) {
        Random randMachine = new Random();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }
        String password = "";
        for(int i=0; i<8; i++) {
            int randomVal = randMachine.nextInt(25);
            password = password + alphabet.get(randomVal);
        }
        System.out.println(password);
    }

    // public void newPassword() {
    public static void main(String[] args) {
        Random randMachine = new Random();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }
        String password = "";
        for(int i=0; i<8; i++) {
            int randomVal = randMachine.nextInt(25);
            password = password + alphabet.get(randomVal);
        }
        int length = 5;
        ArrayList<String> passwordSet = new ArrayList<String>();
        for(int i = 0; i < length; i++) {
            passwordSet.add(password);
        }
        System.out.println(passwordSet);
    }

}