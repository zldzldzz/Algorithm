import java.io.*;

public class Main {
    static int strat(char[] row, int startRow, boolean cloor) {
        char[] compare;
        if(cloor){
            compare =new char[] {'W', 'B'};

        }else {
            compare =new char[] {'B', 'W'};
        }
        int change = 0;
        for (int i = 0; i < 8; i++) {
            if (i%2==0) {
                if(row[startRow + i] != compare[0]){
                    change++;
                }
            }else {
                if(row[startRow + i] != compare[1]){
                    change++;
                }
            }
        }
        return change;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        //전체 보드판 배열
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        //최대수 적용 최소값 찾기
        int minChange = Integer.MAX_VALUE;

        //i와 j를 통해 새로운 판 한개 씩 생성
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int wStart = 0;
                int bStart = 0;
                //새롭게 생긴 판의 한줄씩 비교하기 위해 전달
                for (int k = 0; k < 8; k++) {
                    //판의 시작에 따라 검정 혹은 하얀으로 시작하는 것에 따라 비교 시작
                    if (k % 2 == 0) {
                        bStart += strat(board[i + k], j, false);
                        wStart += strat(board[i + k], j, true);
                    } else {
                        bStart += strat(board[i + k], j, true);
                        wStart += strat(board[i + k], j, false);
                    }
                }
                if(wStart>bStart){
                    if (minChange>bStart){
                        minChange=bStart;
                    }
                }else {
                    if (minChange>wStart){
                        minChange=wStart;
                    }
                }
            }
        }
        bw.write(String.valueOf(minChange));
        bw.close();
    }
}
