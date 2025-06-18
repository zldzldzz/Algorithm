import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = {1,1,2,2,2, 8};

        String str = br.readLine();
        String[] chass = str.split(" ");

        for (int i = 0; i < chass.length; i++) {
            int diff = arr[i] - Integer.parseInt(chass[i]);
            bw.write(diff + " ");
        }
        bw.flush();
        bw.close();
    }
}