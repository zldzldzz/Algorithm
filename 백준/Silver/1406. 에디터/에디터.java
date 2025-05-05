import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String cordAll= br.readLine();
        int length = Integer.parseInt(br.readLine());

        Stack<Character> leftCord = new Stack<>();
        Stack<Character> rightCord = new Stack<>();

        for (char c : cordAll.toCharArray()) {//문자열을 배열 처럼
            leftCord.push(c);
        }

        for (int i = 0; i < length; i++) {
            String command = br.readLine();
            char C = command.charAt(0);
            
            if (C=='L'&&!leftCord.isEmpty()){
                rightCord.push(leftCord.pop());
            } else if (C=='D'&&!rightCord.isEmpty()) {
                leftCord.push(rightCord.pop());
            } else if (C=='B'&&!leftCord.isEmpty()) {
                leftCord.pop();
            } else if (C=='P') {
                leftCord.push(command.charAt(2));
            }
        }


        while (!leftCord.isEmpty()) {
            rightCord.push(leftCord.pop());
        }



        StringBuilder rightResult = new StringBuilder();
        while (!rightCord.isEmpty()) {
            rightResult.append(rightCord.pop());
        }
        bw.write(rightResult.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
