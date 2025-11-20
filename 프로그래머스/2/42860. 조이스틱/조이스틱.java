class Solution {

    public int solution(String name) {
      int answer = 0;
      int legth = name.length();
      //좌우 이동 최소(정방향만)
      int move = legth - 1;
      for (int i = 0; i < legth; i++) {
        char nameChar = name.charAt(i);
        //해당 문자의 상하를 고를 때의 값 지정
        answer += Math.min(nameChar - 'A', 'Z' - nameChar + 1);

        int nextIndex = i + 1;
        while (nextIndex < legth && 'A' == name.charAt(nextIndex)) {
          nextIndex++;
        }

        int moveA = i;
        int moveB = name.length() - nextIndex;

        int totalMove = moveA + moveB + Math.min(moveA, moveB);

        move = Math.min(move, totalMove);
      }
      return answer+move;
    }
  }