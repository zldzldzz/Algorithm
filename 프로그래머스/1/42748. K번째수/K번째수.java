import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new LinkedList<>();
    for (int[] command : commands) {
      int start = command[0] - 1;
      int end = command[1];

      List<Integer> temp = new LinkedList<>();
      for (int i = start; i < end; i++) {
        temp.add(array[i]);
      }
      Collections.sort(temp);
      int find = command[2] - 1;
      result.add(temp.get(find));
    }

    int[] answer = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      answer[i] = result.get(i);
    }
    return answer;
    }
}