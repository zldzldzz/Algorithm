import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] number = new int[length];

        Stack<Integer> index=new Stack<>();
        Stack<Integer> value = new Stack<>();

        for (int i = 0; i < length; i++) {
            number[i]= Integer.parseInt(str[i]);
        }
        for (int i = 0; i < length; i++) {
            if(i==0){
                index.add(0);
                value.add(number[0]);
                bw.write("0 ");
            }
            else {
                while (!value.isEmpty() && value.peek() <= number[i]) {
                    value.pop();
                    index.pop();
                }
                if (value.isEmpty()) {
                    bw.write("0 ");
                } else {
                    bw.write(String.valueOf(index.peek() + 1) + " ");
                }
                value.push(number[i]);
                index.push(i);
            }
        }


        bw.close();
    }
}