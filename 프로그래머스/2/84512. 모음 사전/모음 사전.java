import java.util.List;
import java.util.ArrayList;
class Solution {
    public static char[] words = {'A', 'E', 'I', 'O', 'U'};
    public static List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
			dfs("", 0);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(word)) {
					answer = i;
				}
			}
        return answer;
    }
    public static void dfs(String word, int level) {
		list.add(word);

		if (level == 5) {
			return;
		}
		for (int i = 0; i < 5; i++) {
			dfs(word + words[i], level + 1);
		}

	}
}