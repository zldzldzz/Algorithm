import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> stack = new ArrayList<>();

        stack.add(0);
        stack.add(1);
        stack.add(2);


        while (true){
            String str = br.readLine();

            if(str.equals("0 0 0")) {
                break;

            }else {
                String[] numSt = str.split(" ");
                int[] num=new int[numSt.length];

                int max= num[0], k=0;

                for (int i = 0; i < num.length; i++) {
                    num[i]=Integer.parseInt(numSt[i]);
                    if (num[i]>=max){
                        max=num[i];
                        k=i;
                    }
                }
                stack.remove(k);
                if (num[k]*num[k]==(num[stack.get(0)]*num[stack.get(0)])+(num[stack.get(1)]*num[stack.get(1)]) ){
                    bw.write("right\n");
                }else {
                    bw.write("wrong\n");
                }
                
                stack.clear();
                stack.add(0);
                stack.add(1);
                stack.add(2);
            }

        }

        bw.close();
    }
}
