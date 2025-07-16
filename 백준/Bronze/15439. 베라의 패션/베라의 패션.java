import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int T = Integer.parseInt(str);
        System.out.println(T*(T-1));
      }
}
