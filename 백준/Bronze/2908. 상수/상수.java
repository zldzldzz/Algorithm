import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] num =str.split(" ");
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        for (int i = 0; i <3 ; i++) {
            first.append(num[0].charAt(2-i));
            second.append(num[1].charAt(2-i));
        }

        int firstNum= Integer.parseInt(first.toString());
        int secondNum=Integer.parseInt(second.toString());

        if(firstNum>secondNum){
            System.out.println(firstNum);
        }else System.out.println(secondNum);

    }
}