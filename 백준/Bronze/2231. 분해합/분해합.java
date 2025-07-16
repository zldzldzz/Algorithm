import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int target= Integer.parseInt(str);
        String[] string = str.split("");

        boolean answer= false;
        int m=1;
        if(target-string.length*9>0){
            m=target-string.length*9;
        }
        for (int i = m; i <target; i++) {
            int k=i;
            int j=0;
            while (k!=0){
                j+=k%10;
                k/=10;
            }
            if((j+i)==target){
                answer=true;
                bw.write(String.valueOf(i));
                break;
            }
        }
        if (!answer){
            bw.write("0");
        }

        bw.flush();
        bw.close();
      }
}
