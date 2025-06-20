import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String s = "";
        int i=0;
        int x=665;
        while (i<num){
            x++;
            String xStr = String.valueOf(x);
            if (xStr.contains("666")){
                i++;
            }
        }
        bw.write(String.valueOf(x));
        bw.close();
    }
}
