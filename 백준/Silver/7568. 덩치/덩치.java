import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    static class Person  {
        int x=0;
        int y=0;
        int Rank;

        Person(int x, int y){
            this.x=x;
            this.y=y;
        }

        public void setRank(int rank) {
            Rank = rank;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        ArrayList<Person> stack = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String[] str = br.readLine().split(" ");
            int x= Integer.parseInt(str[0]);
            int y= Integer.parseInt(str[1]);
            Person person = new Person(x,y);
            stack.add(person);
        }
        for (int i = 0; i < stack.size(); i++) {
            int rank = 1; // 기본 1등
            for (int j = 0; j < stack.size(); j++) {
                if (i == j) continue;
                if (stack.get(i).x < stack.get(j).x && stack.get(i).y < stack.get(j).y) {
                    rank++;
                }
            }
            stack.get(i).setRank(rank);
        }

        for (Person person : stack) {
            bw.write(String.valueOf(person.Rank+" "));
        }

        bw.close();
    }
}
