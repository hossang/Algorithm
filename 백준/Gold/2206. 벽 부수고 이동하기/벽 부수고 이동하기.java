import java.io.*;
import java.util.*;

class YX{
    int y;
    int x;
    int b;
    int res;
    YX(int y, int x, int b,int res) {
        this.y =y;
        this.x = x;
        this.b = b;
        this.res = res;
    }
}

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] graph = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        boolean[][] bisited = new boolean[N][M];

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<M;j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        Deque<YX> dq = new ArrayDeque<>();
        dq.addLast(new YX(0,0,1,0));
        visited[0][0] = true;

        while(!dq.isEmpty()) {
            YX now = dq.pollFirst();
            now.res+=1;

            if(now.y==N-1&&now.x==M-1){
                System.out.println(now.res);
                return;
            }

            for(int i=0;i<4;i++) {
                int ny = now.y+dy[i];
                int nx = now.x+dx[i];

                if(ny<0||nx<0||ny>=N||nx>=M) {
                    continue;
                }
                if(graph[ny][nx]=='1') {
                    continue;
                }

                if (now.b == 1&&!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dq.addLast(new YX(ny,nx,now.b,now.res));
                    continue;
                }
                if (now.b == 0&&!bisited[ny][nx]) {
                    bisited[ny][nx] = true;
                    dq.addLast(new YX(ny,nx,now.b,now.res));
                }
            }

            for(int i=0;i<4;i++) {
                int ny = now.y+dy[i];
                int nx = now.x+dx[i];

                if(ny<0||nx<0||ny>=N||nx>=M) {
                    continue;
                }
                if(now.b==0) {
                    continue;
                }
                if(bisited[ny][nx]) {
                    continue;
                }
                if(graph[ny][nx]=='1') {
                    bisited[ny][nx] = true;
                    dq.addLast(new YX(ny,nx,0,now.res));
                }

            }

        }
        System.out.print(-1);

    }
}
