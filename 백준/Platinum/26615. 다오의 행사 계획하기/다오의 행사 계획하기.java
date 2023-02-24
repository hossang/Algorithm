
import java.io.*;
import java.util.*;
public class Main {
    private static List<List<Integer>> tree;
    private static int Y,N,M,T;
    private static int[] depths, directionx, directiony;
    private static boolean[][] visited;
    private static int[][] sparseTable,map,A,B;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //y
        M = Integer.parseInt(st.nextToken()); //x
        T = Integer.parseInt(st.nextToken());
        //mappingTable 만들기
        int num =0;
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                map[i][j] = ++num;
            }
        }
        //Y구하기
        int tmp =1;
        while(tmp<num) {
            tmp<<=1;
            Y++;
        }
        //A,B행렬만들기
        A = new int[N-1][M];
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        B = new int[N][M-1];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M-1;j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //트리 만들기, depths 만들기, sparseTable만들기
        tree = new ArrayList<>();
        for(int i=0;i<=num;i++) {
            tree.add(new ArrayList<>());
        }
        directionx = new int []{-1,1,0,0};
        directiony = new int []{0,0,-1,1};
        visited = new boolean[N][M];
        visited[0][0] = true;
        depths = new int[num+1];
        sparseTable = new int[Y+1][num+1];
        depths[1] = 1;
        dfs(0,0);
        for(int i=1;i<=Y;i++) {
            for(int j=1;j<=num;j++) {
                sparseTable[i][j] = sparseTable[i-1][sparseTable[i-1][j]];
            }
        }
        int K = Integer.parseInt(br.readLine());
        long[] prefix = new long[T+2]; //이러면 시간초과 나잖아
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int lca = getlca(map[a][b],map[c][d]);
            long x = (depths[map[a][b]] - depths[lca] + depths[map[c][d]] - depths[lca] + 1) * V;
            prefix[S] += x;
            prefix[E+1] -= x;
        }
        long sum = prefix[1];
        sb.append(sum).append("\n");
        for(int i=2;i<=T;i++) {
        	sum += prefix[i];
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
    private static int getlca(int x, int y) {
        if(depths[x]<depths[y]) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        for(int i=0;i<=Y;i++) {
            if(((depths[x]-depths[y])&(1<<i))>=1) {
                x = sparseTable[i][x];
            }
        }
        if(x==y) {
            return x;
        }
        for(int i=Y;i>=0;i--) {
            if(sparseTable[i][x]!=sparseTable[i][y]) {
                x = sparseTable[i][x];
                y = sparseTable[i][y];
            }
        }
        return sparseTable[0][x];
    }

    private static void dfs(int y,int x) {
        for(int i=0;i<4;i++) { //좌우상하
            int nexty = y + directiony[i];
            int nextx = x + directionx[i];

            if(nexty<0||nextx<0||nexty>N-1||nextx>M-1) {
                continue;
            }
            if(visited[nexty][nextx]) {
                continue;
            }
            if(i==0&&B[nexty][nextx]==1) {
            	continue;
            }
            if(i==1&&B[y][x]==1) {
                continue;
            }
            if(i==2&&A[nexty][nextx]==1) {
            	continue;
            }
            if(i==3&&A[y][x]==1) {
                continue;
            }
            
            visited[nexty][nextx] = true;
            tree.get(map[y][x]).add(map[nexty][nextx]);
            tree.get(map[nexty][nextx]).add(map[y][x]);
            depths[map[nexty][nextx]] = depths[map[y][x]] + 1;
            sparseTable[0][map[nexty][nextx]] = map[y][x];
            dfs(nexty,nextx);
        }

    }
}