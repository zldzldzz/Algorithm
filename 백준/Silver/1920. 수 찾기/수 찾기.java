import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> n = new HashSet<>();

        String str= br.readLine();

        str = br.readLine();
        String mapN[] = str.split(" ");

        for (String string : mapN) {
            n.add(string);
        }

        str= br.readLine();

        str = br.readLine();
        String mapM[] = str.split(" ");

        for (String string : mapM) {
            bw.write(n.contains(string) ? "1\n" : "0\n");
        }
        bw.flush();
        bw.close();
    }
}
