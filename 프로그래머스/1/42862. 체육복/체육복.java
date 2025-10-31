import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] arr = new int[n];

		Arrays.fill(arr, 1);
        for (int i = 0; i < reserve.length; i++) {
			arr[reserve[i]-1] = 2;
		}

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < lost.length; i++) {
			arr[lost[i]-1] = arr[lost[i]-1] - 1;
			if (arr[lost[i]-1] == 0) {
				answer--;
				q.add(lost[i]-1);
			}
		}
		/**
		 * 전체 학생 수 n
		 * 학생 현재 상태 arr[]
		 * 체육복 없는 학생 q
		 */
		while (!q.isEmpty()) {
			int student = q.poll();
			int front = student-1;
			int back = student+1;
			if(arr[front] == 2) {
				arr[front]=arr[front]-1;
				answer++;
			} else if (arr[back]==2) {
				arr[back]=arr[back]-1;
				answer++;
			}
		}
        return answer;
    }
}