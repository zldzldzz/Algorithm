import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String solution(int[] numbers) {
        // 숫자 배열을 사전식으로 정렬하기 위해 String 배열로 변경
		String[] stringArray = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			stringArray[i] = String.valueOf(numbers[i]);
		}

		//정렬 메소드 사용
		/*
			compare은 양수가 나오면 자리를 기존 o1, o2의 순서에서 o2, o1으로 변경한다.
			크기를 비교할때 compareTo를 사용하는데 compareTo은 .compareTo를 기준으로 앞에 같이 더 크면 양수
			.compareTo의 뒤에 값이 더 크면 음수가 나온다.
			때문에 .compareTo의 결과가 앞에 값 해당 문제의 경우 o2+o1이 o1+o2보다 크다면 자리를 바꾸는 것이다.
		 */
		Arrays.sort(stringArray, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// (o2 + o1)과 (o1 + o2)를 비교하여 내림차순 정렬
				return (o2+o1).compareTo(o1+o2);
			}
		});
        
        if(stringArray[0].equals("0")){
			return "0";
		}else{
            
        return String.join("", stringArray);
        }
    }
}