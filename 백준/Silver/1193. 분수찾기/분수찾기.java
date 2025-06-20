import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int x = 0, y=0;
        int k=1;
        while (num-k>0){
            num = num-k;
            k++;
        }
        k--;

        if(k%2==0){
            x=k+2;
            for (int i = 0; i < num; i++) {
                x--;
                y++;
            }
            bw.write(x+"/"+y);

        }else {
            y=k+2;
            for (int i = 0; i < num; i++) {
                y--;
                x++;

            }
            bw.write(x+"/"+y);
        }
        bw.close();
        br.close();
    }
}
