
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        String str= scanner.nextLine();

        String[] AandB  = str.split( " ");

        int A = Integer.parseInt(AandB[0].toString());
        int B = Integer.parseInt(AandB[1].toString());
        if (A>B){
            System.out.println(">");
        }else if(A==B){
            System.out.println("==");
        }else if (A<B){
            System.out.println("<");
        }

    }
}
