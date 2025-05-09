import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str= br.readLine().split("");
        int[] answer=new int[10];
        for (String string : str) {
            int i=Integer.parseInt(string);
            if(i==9){
                answer[6]++;
            }
            else answer[i]++;
        }
        if (answer[6]%2==0){
            answer[6]=answer[6]/2;
        }else {
            answer[6]=answer[6]/2;
            answer[6]++;
        }
        int max=0;
        for (int i : answer) {
            if(max<i){
                max=i;
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}
