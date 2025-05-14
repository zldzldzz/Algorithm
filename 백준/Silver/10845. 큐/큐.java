import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new LinkedList<>();

        int length = Integer.parseInt(br.readLine());
        for (int i = 0; i < length; i++) {
            String[] str = br.readLine().split(" ");
            String command = str[0];

            if (command.equals("push")) {
                queue.add(Integer.parseInt(str[1]));
            } else if (command.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.peek() + "\n");
                }
            } else if (command.equals("back")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.getLast() + "\n");
                }
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.pop() + "\n");
                }
            } else if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (command.equals("size")) {
                bw.write(queue.size() + "\n");
            }
        }
        bw.flush(); // Ensure all output is written
        bw.close(); // Close the writer
        br.close(); // Close the reader
    }
}