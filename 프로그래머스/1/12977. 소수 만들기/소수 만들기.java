class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    System.out.println(sum);

                    if (sum % 2 != 0 && sum >= 2) {
                        boolean isPrime = true;

                        for (int d = 2; d <= sum/2; d++) {
                            if (sum % d == 0) {
                                isPrime = false;
                                break;
                            }
                        }

                        if (isPrime) {
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
