import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(br.readLine());
        String[] s =  br.readLine().split("");
        int count=0;
        for (String string : s) {
            if(string.equals("O")){
                count++;
            }
        }
        if(n%2==1){
            if(count>=n/2+1){
                bw.write("Yes");
            }else {
                bw.write("No");
            }
        }else{
            if(count>=n/2){
                bw.write("Yes");
            }else {
                bw.write("No");
            }
        }

        bw.flush();
        bw.close();
        br.close();


    }

}