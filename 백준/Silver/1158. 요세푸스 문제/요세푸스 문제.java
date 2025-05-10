import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input =br.readLine().split(" ");
        int[] inputNumber= new int[2];
        for (int i=0;i<2;i++) {
            inputNumber[i]= Integer.parseInt(input[i]);
        }

        List<Integer> Cycle= new ArrayList<>();
        List<String> answer =new ArrayList<>();

        for (int i = 1; i <= inputNumber[0]; i++) {
            Cycle.add(i);
        }
        int index=0;
        for (int i = 1; i <= inputNumber[0]; i++) {
            index = index+inputNumber[1]-1;
            if (index+1>Cycle.size()){
                index=index%Cycle.size();
            }
            answer.add(String.valueOf(Cycle.get(index)));
            Cycle.remove(index);
        }

        bw.write("<" + String.join(", ", answer) + ">");
        bw.flush();
        bw.close();

    }

}
