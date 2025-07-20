import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr=new String[n];
        HashSet<String> set=new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr = br.readLine().split(" ");
            if(arr[0].equals("add")){
                set.add(arr[1]);
            }
            else if (arr[0].equals("remove")&&set.contains(arr[1])) {
                set.remove(arr[1]);
            } else if (arr[0].equals("check")) {
                if (set.contains(arr[1])) {
                    bw.write("1"+"\n");
                }else {
                    bw.write("0"+"\n");
                }
            }else if (arr[0].equals("toggle")) {
                if (set.contains(arr[1])) {
                    set.remove(arr[1]);
                }else {
                    set.add(arr[1]);
                }
            }else if (arr[0].equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(String.valueOf(j));
                }
            }else if (arr[0].equals("empty")) {
                set.clear();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}



