import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lenth = Integer.parseInt(br.readLine());
        Deque<Integer> deque= new ArrayDeque<>();

        for (int i = 0; i < lenth; i++) {
            String[] str = br.readLine().split(" ");
            String command = str[0];
            if(command.equals("push")){
                deque.add(Integer.parseInt(str[1]));
            } else if (command.equals("front")) {
                if (deque.isEmpty()){
                    bw.write("-1\n");
                }else {
                    bw.write(deque.getFirst()+"\n");
                }
            } else if (command.equals("back")) {
                if (deque.isEmpty()){
                    bw.write("-1\n");
                }else {
                    bw.write(deque.getLast()+"\n");

                }
            } else if (command.equals("size")) {
                bw.write(deque.size()+"\n");
            } else if (command.equals("empty")) {
                if(deque.isEmpty()){
                    bw.write("1\n");
                }else bw.write("0\n");
            } else if (command.equals("pop")) {
                if (deque.isEmpty()){
                    bw.write("-1\n");
                }else {
                    bw.write(String.valueOf(deque.pop())+"\n");

                }
            }
        }
        bw.close();
        br.close();
        
    }
}
