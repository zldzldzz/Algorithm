import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str= br.readLine();
        int[] answer= new int[26];
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                answer[str.charAt(i)-'a']++;
            }
        }
        for (int i : answer) {
            bw.write(String.valueOf(i)+" ");
            bw.flush();
        }
        bw.close();
        br.close();

    }
}
