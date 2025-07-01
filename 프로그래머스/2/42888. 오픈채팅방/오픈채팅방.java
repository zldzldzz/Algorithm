import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idToName = new HashMap<>();
        List<String[]> actionAndId = new ArrayList<>();

        for (String rec : record) {
            String[] parts = rec.split(" ");
            String action = parts[0];
            String id = parts[1];

            if (action.equals("Enter") || action.equals("Change")) {
                String name = parts[2];
                idToName.put(id, name);
            }

            if (action.equals("Enter") || action.equals("Leave")) {
                actionAndId.add(new String[]{action, id});
            }
        }

        List<String> answer = new ArrayList<>();
        for (String[] strings : actionAndId) {
            if (strings[0].equals("Enter")) {
                String name = idToName.get(strings[1]);
                answer.add(name + "님이 들어왔습니다.");
            } else if (strings[0].equals("Leave")) {
                String name = idToName.get(strings[1]);
                answer.add(name + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
