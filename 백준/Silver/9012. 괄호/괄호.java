import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Stack<Integer> yorn = new Stack<>();

        for (int i = 0; i < length; i++) {
        String[] str = br.readLine().split("");
        int k=0;
            for (String string : str) {
               // System.out.println(string);
                if (string.equals("(")){
                    yorn.add(1);
                } else if (string.equals(")")) {
                    if(yorn.isEmpty()){
                       bw.write("NO\n");
                       yorn.clear();
                       k=1;
                        break;
                    }else {
                        yorn.pop();
                    }
                }
            }
            if (yorn.isEmpty()&&k==0){
                yorn.clear();
                bw.write("YES\n");
            }else if(k==0) {
                yorn.clear();
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
