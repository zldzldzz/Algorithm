import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();

        int length = Integer.parseInt(br.readLine());

        for (int i = 0; i < length; i++) {
            String[] str= br.readLine().split(" ");
            String command = str[0];
            switch (command)
            {
                case "pop_front":{
                    if(deque.isEmpty()){
                        bw.write("-1\n");
                    }else bw.write(deque.pop()+"\n");
                    break;
                }
                case "pop_back":{
                    if(deque.isEmpty()){
                        bw.write("-1\n");
                    }else  bw.write(deque.pollLast()+"\n");
                    break;

                }
                case "size":{
                    bw.write(deque.size()+"\n");
                    break;
                }
                case "empty":{
                    if (deque.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                }
                case "front":{
                    if (deque.isEmpty()){
                        bw.write("-1\n");
                    }else bw.write(deque.getFirst()+"\n");
                    break;
                }
                case "back":{
                    if (deque.isEmpty()){
                        bw.write("-1\n");
                    }else bw.write(deque.getLast()+"\n");
                    break;
                }
                case "push_front":{
                    deque.addFirst(Integer.parseInt(str[1]));
                    break;
                }

                case "push_back":{
                    deque.addLast(Integer.parseInt(str[1]));
                    break;
                }
            }


        }
        bw.flush();
        bw.close();
        br.close();

    }
}
