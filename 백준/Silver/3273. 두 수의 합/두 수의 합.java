import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] nums = new int[size];
        Set<Integer> numSet= new HashSet<>();


        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
            numSet.add(nums[i]);
        }
        int x = scanner.nextInt();

        int answer=0;
        for(int num:nums){
            if(numSet.contains(x-num)&&x-num>num){
                answer++;
            }
            numSet.add(num);
        }
        System.out.println(answer);
    }
}
