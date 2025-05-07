
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str =br.readLine().trim().split("");

        Stack<Integer> in = new Stack<>();

        int answer=0;

        for (int i = 1; i < str.length; i++)
        {

                if (str[i-1].equals("(")&&str[i].equals(")")){
                    //자르기
                    answer+=in.size();
                } else if(str[i-1].equals(")")&&str[i].equals(")")){
                    //막대기 끝
                    in.pop();
                }else if(str[i-1].equals("(")){
                    //막대 추가
                    in.push(1);
                    answer+=1;
                }
        }
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
