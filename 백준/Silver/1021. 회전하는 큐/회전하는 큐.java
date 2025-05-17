import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] length = br.readLine().split(" ");
        String[] strNumber = br.readLine().split(" ");
        int count=0;

        int[] target =new int[strNumber.length];
        LinkedList<Integer> number=new LinkedList<Integer>();

        int find=0;

        for (String string : strNumber) {
            target[find]=Integer.parseInt(string);
            find++;
        }
        find=0;

        for (int i = 0; i < Integer.parseInt(length[0]); i++) {
            number.add(i+1);
        }


        while (find<Integer.parseInt(length[1])){
            int targetIndex = number.indexOf(target[find]);
            int halfIndex;

            if(number.size()%2==0){
                halfIndex=number.size()/2-1;
            }else {
                halfIndex=number.size()/2;
            }

            if(targetIndex<=halfIndex){
                for (int i = 0; i < targetIndex; i++) {
                    int tmp = number.pollFirst();
                    number.offerLast(tmp);
                    count++;
                }
            }else {
                for (int i = 0; i < number.size() - targetIndex; i++) {
                    int tmp = number.pollLast();
                    number.offerFirst(tmp);
                    count++;
                }
            }
            number.pollFirst();
            find++;
        }
        System.out.println(count);
    }
}
