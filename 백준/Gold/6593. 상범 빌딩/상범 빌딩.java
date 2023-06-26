import java.io.*;
import java.util.*;

class YXZ {
    int y;
    int x;
    int z;
    
    YXZ(int y, int x, int z) {
        this.y = y;
        this.x = x;
        this.z = z;
    }
}

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken()); //층
            int R = Integer.parseInt(st.nextToken()); //행
            int C = Integer.parseInt(st.nextToken()); //열
            if(L==0&&R==0&&C==0) {
                break;
            }
            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};
            int[] dz = {-1,1};
            char[][][] graph = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];
            Deque<YXZ> dq = new ArrayDeque<>();
            YXZ E = new YXZ(0,0,0);
            for(int i=0;i<L;i++) {
                for(int j=0;j<R;j++) {
                    String s = br.readLine();
                    for(int k=0;k<C;k++) {
                        graph[i][j][k] = s.charAt(k);
                        if(graph[i][j][k]=='S'){
                            dq.addLast(new YXZ(j,k,i));
                            visited[i][j][k] = true;
                        }
                        if(graph[i][j][k]=='E') {
                            E = new YXZ(j,k,i);
                        }
                    }
                }
                st = new StringTokenizer(br.readLine(), " ");
            }
            int cnt = 0;
            a:while(!dq.isEmpty()) {
                int dqsize = dq.size();
                for(int h=0;h<dqsize;h++) {
                    YXZ now = dq.pollFirst();
                
                    if(graph[now.z][now.y][now.x]=='E') {
                    break a;
                    }
                
                    for(int i=0;i<4;i++) {
                        int ny = now.y+dy[i];
                        int nx = now.x+dx[i];
                        if(nx<0||ny<0||nx>=C||ny>=R) {
                            continue;
                        }
                        if(graph[now.z][ny][nx]=='#') {
                            continue;
                        }
                        if(visited[now.z][ny][nx]) {
                            continue;
                        }
                        visited[now.z][ny][nx] = true;
                        dq.addLast(new YXZ(ny,nx,now.z));
                    }
                    for(int i=0;i<2;i++) {
                        int nz = now.z + dz[i];
                        if(nz<0||nz>=L) {
                            continue;
                        }
                        if(graph[nz][now.y][now.x]=='#') {
                            continue;
                        }
                        if(visited[nz][now.y][now.x]) {
                            continue;
                        }
                        
                        visited[nz][now.y][now.x] = true;
                        dq.addLast(new YXZ(now.y,now.x,nz));
                    }
                }
                cnt++;
            }
            if(visited[E.z][E.y][E.x]) {
                sb.append("Escaped in ").append(cnt).append(" minute(s).").append("\n");
            } else {
                sb.append("Trapped!").append("\n");
            }
        }
        System.out.print(sb);
    }
}
