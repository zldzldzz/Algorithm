import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int a=0,b=0;
        boolean find=false;

        for (int i = num / 5; i >= 0; i--) {
            int remain = num - i * 5;
            if (remain % 3 == 0) {
                find=true;
                bw.write(String.valueOf(i + (remain / 3)));
                break;
            }
        }
        if(!find){
            for (int i = num / 3; i >= 0; i--) {
                int remain = num - i * 3;
                if (remain % 5 == 0) {
                    find=true;
                    bw.write(String.valueOf(i + (remain / 5)));
                    break;
                }
            }
        }

        if (!find){
            bw.write("-1");
        }
        bw.close();
    }

}
