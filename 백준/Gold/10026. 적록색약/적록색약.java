import java.awt.desktop.QuitEvent;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String[][] map = new String[size][size];
        boolean[][] visited = new boolean[size][size];
        boolean[][] visitedless = new boolean[size][size];


        int[] dx={1,0,-1,0};
        int[] dy= {0,1,0,-1};

        for (int i = 0; i < size; i++) {
            map[i]=br.readLine().split("");
        }
        int count=0;
        int countless=0;
        Queue<Integer[]> q = new LinkedList<>();
        Queue<Integer[]> qless = new LinkedList<>();

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if(!visitedless[i][j])
                {
                    countless++;
                    String color = map[i][j];
                    int colorCode = 0;
                    if(color.equals("G")) colorCode = 0;
                    else if(color.equals("B")) colorCode = 1;
                    qless.add(new Integer[]{i, j, colorCode});
                    visitedless[i][j] = true;
                    while (!qless.isEmpty())
                    {
                        Integer[] now = qless.poll();  // q가 아니라 qless
                        for (int k = 0; k < 4; k++)
                        {
                            int x = now[0] + dx[k];
                            int y = now[1] + dy[k];
                            if (x>=0&&y>=0&&x<size&&y<size&&!visitedless[x][y])
                            {
                                if((now[2]==0) && (map[x][y].equals("G")||map[x][y].equals("R")))
                                {
                                    qless.add(new Integer[]{x,y,0});
                                    visitedless[x][y]=true;
                                }
                                else if (map[x][y].equals("B")&&now[2]==1)
                                {
                                    qless.add(new Integer[]{x,y,1});
                                    visitedless[x][y]=true;
                                }
                            }
                        }
                    }

                }

                if(!visited[i][j])
                {
                    count++;
                    String color = map[i][j];

                    int colorCode = 0;
                    if(color.equals("G")) colorCode = 1;
                    else if(color.equals("B")) colorCode = 2;

                    q.add(new Integer[]{i, j, colorCode});
                    visited[i][j] = true;

                    while (!q.isEmpty())
                    {
                        Integer[] now = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = now[0] + dx[k];
                            int y = now[1] + dy[k];
                            if (x>=0&&y>=0&&x<size&&y<size&&!visited[x][y])
                            {
                                if(map[x][y].equals("R")&&now[2]==0){
                                    q.add(new Integer[]{x,y,0});
                                    visited[x][y]=true;
                                } else if (map[x][y].equals("G")&&now[2]==1) {
                                    q.add(new Integer[]{x,y,1});
                                    visited[x][y]=true;
                                } else if (map[x][y].equals("B")&&now[2]==2) {
                                    q.add(new Integer[]{x,y,2});
                                    visited[x][y]=true;
                                }
                            }
                        }
                    }
                }

            }
        }
        bw.write(String.valueOf(count)+" "+String.valueOf(countless)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}



