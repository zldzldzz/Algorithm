import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] str1 =new int[26];
        int[] str2 =new int[26];

        int answer=0;

        String str= br.readLine();
        for (int i = 0; i < str.length(); i++) {
            str1[str.charAt(i)-'a']++;
        }

        str= br.readLine();
        for (int i = 0; i < str.length(); i++) {
            str2[str.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            answer+= Math.abs(str1[i]-str2[i]);
        }

        //출력
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();

    }
}
