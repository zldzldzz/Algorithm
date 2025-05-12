import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Stack<Integer> answer=new Stack<>() ;

        int answeradd=0;

        for (int i = 0; i < length; i++) {
           String inpustString = br.readLine();
           if(inpustString.equals("0")){
               answer.pop();
           }else {
               answer.push(Integer.parseInt(inpustString));
           }
        }
        for (Integer i : answer) {
            answeradd+=i;

        }
        bw.write(String.valueOf(answeradd));
        bw.flush();
        bw.close();
        br.close();
    }
}
