import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Stack<Integer> answer=new Stack<>() ;

        int index=0;

        for (int i = 0; i < length; i++) {

            String[] str = br.readLine().split(" ");

            if(str[0].equals("push")){
                answer.push(Integer.parseInt(str[1]));

            } else if (str[0].equals("pop")) {
               if(answer.empty()){
                   bw.write("-1"+'\n');
               }else {
                   bw.write(String.valueOf(answer.pop())+'\n');
               }
            } else if (str[0].equals("size")) {
                bw.write(String.valueOf(answer.size())+'\n');
            } else if (str[0].equals("empty")) {
                if (answer.empty()){
                    bw.write("1"+'\n');
                }else {
                    bw.write("0"+'\n');
                }

            } else if (str[0].equals("top")) {
                if (answer.empty()){
                    bw.write("-1"+'\n');
                }else {
                    bw.write(String.valueOf(answer.peek())+'\n');
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
