import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[] answer = new String[length];

        for (int i = 0; i < length; i++) {
            String[] a = br.readLine().split(" ");
            String sa= a[0];
            String sb= a[1];
            if(sa.length()!= sb.length()){
                answer[i]="Impossible";
            }else {
                int[] count = new int[26];
                boolean possible= true;
                for (char c : sa.toCharArray()) {
                    count[c-'a']++;
                }
                for (char c : sb.toCharArray()) {
                    count[c-'a']--;
                }
                for (int j = 0; j < 26; j++) {
                    if (count[j] != 0) {
                        possible = false;
                        break;
                    }
                }
                if (possible){
                    answer[i]="Possible";
                }else  answer[i]="Impossible";

            }

        }
        for (String string : answer) {
            bw.write(string);
            bw.write('\n');

            bw.flush();

        }
    }
}
