import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] k=new int[26];
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char c= str.charAt(i);
            if('a' <= c && c <= 'z'){
                k[c-'a']++;

            }
        }
        for (int i : k) {
            System.out.print(i+" ");
        }

    }
}
