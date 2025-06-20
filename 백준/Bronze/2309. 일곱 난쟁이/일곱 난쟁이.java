import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0,b=0;
        ArrayList<Integer> dwarf = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            dwarf.add(Integer.parseInt(br.readLine()));
        }
        int sum=0;
        for (Integer i : dwarf) {
            sum+=i;
        }
        sum=sum-100;

        loopout:
        for (Integer i : dwarf) {
            for (Integer j : dwarf) {
                if((i+j)==sum&&i!=j){
                    a=i;
                    b=j;
                    break loopout;
                }
            }
        }
        dwarf.remove(Integer.valueOf(a));
        dwarf.remove(Integer.valueOf(b));
        dwarf.sort(Comparator.naturalOrder());
        for (Integer i : dwarf) {
            bw.write(i+"\n");
        }
        bw.close();
    }
}
