
import java.io.*;
import java.util.*;


public class Main {
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int h=0;h<T;h++) {
        	int N = Integer.parseInt(br.readLine());
            int tmp = 1;
            int y = 0;
            while(tmp < N) {
            	tmp<<=1;
            	y++;
            }
            List<List<Integer>> tree = new ArrayList<>();
            for(int i =0;i<=N;i++) {
            	tree.add(new ArrayList<>());
            }
            boolean[] childs = new boolean[N+1];
            
            for(int i =0;i<N-1;i++) {
            	st= new StringTokenizer(br.readLine(), " ");
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	
            	tree.get(a).add(b);
            	tree.get(b).add(a);
            	
            	childs[b] = true;
            }
            int[][] sparsetable = new int[y+1][N+1];
            int[] depths = new int[N+1];
            int parent = 0;
            for(int i=1;i<=N;i++) {
            	if (!childs[i]) {
            		parent = i;
            		break;
            	}
            }
            depths[parent] = 1; //부모를 찾아야함
            dfs(parent, depths, sparsetable, tree);
            for(int i=1;i<=y;i++) {
            	for(int j=1;j<=N;j++) {
            		sparsetable[i][j] = sparsetable[i-1][sparsetable[i-1][j]];
            	}
            }
        	st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	sb.append(lca(a,b, sparsetable,depths, y)).append("\n");
        }
        
        System.out.print(sb);
        
    }

	private static int lca(int a, int b, int[][] sparsetable, int[] depths, int y) {
		if(depths[a] < depths[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		//높이 맞춰주기
		for(int i =0; i<=y;i++) {
			if(((depths[a]-depths[b])&(1<<i))>=1) {
				a = sparsetable[i][a];
			}
		}
		
		if(a==b) {
			return a;
		}
		
		for(int i = y;i>=0;i--) {
			if(sparsetable[i][a]!=sparsetable[i][b]) {
				a = sparsetable[i][a];
				b = sparsetable[i][b];
			}
		}
		
		return sparsetable[0][a];
	}

	private static void dfs(int now, int[] depths, int[][] sparsetable, List<List<Integer>> tree) {
		
		for(Integer next:tree.get(now)) {
			if(depths[next]==0) {
				depths[next] = depths[now] + 1;
				sparsetable[0][next] = now;
				dfs(next, depths, sparsetable, tree);
			}
		}
		
	}

}
