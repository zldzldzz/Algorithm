import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        Queue<Integer> answer= new LinkedList<>();

        for (int i = 0; i < number; i++) {
            answer.add(i+1);
        }
        int j=0;
        while (answer.size()!=1){

            if(j%2==0){
                answer.poll();
            }
            else {
                int tmp =answer.poll();
                answer.add(tmp);
            }
            j++;
        }
        System.out.println(answer.peek());
    }
}
