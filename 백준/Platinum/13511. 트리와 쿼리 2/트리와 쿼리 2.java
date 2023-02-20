
import java.io.*;
import java.util.*;

class VE {
	int v;
	int e;
	public VE(int v, int e) {
		super();
		this.v = v;
		this.e = e;
	}
}

public class Main {
	private static List<List<VE>> tree;
	private static int y;
	private static int[] depths;
	private static int[][] sparseTable;
	private static long[][] prices;
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int tmp =1;
        while(tmp<N) {
        	tmp<<=1;
        	y++;
        }
        sparseTable = new int[y+1][N+1];
        prices = new long[y+1][N+1];
        depths = new int[N+1];
        tree = new ArrayList<>();
        for (int i =0;i<=N;i++) {
        	tree.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	tree.get(u).add(new VE(v,w));
        	tree.get(v).add(new VE(u,w));
        }
        depths[1] = 1;
        dfs(new VE(1,0));
        for(int i=1;i<=y;i++) {
        	for(int j=1;j<=N;j++) {
        		sparseTable[i][j] = sparseTable[i-1][sparseTable[i-1][j]];
        		prices[i][j] = prices[i-1][j] + prices[i-1][sparseTable[i-1][j]];
        	}
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int num = Integer.parseInt(st.nextToken());
        	int u,v,k;
        	if(num==1) {
        		u = Integer.parseInt(st.nextToken());
        		v = Integer.parseInt(st.nextToken());
        		sb.append(uv(u,v)).append("\n");
        		continue;
        	}
        	u = Integer.parseInt(st.nextToken());
        	v = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	int lca =  getlca(u,v);
        	int x = getk(u,v,lca,k-1);
        	sb.append(x).append("\n");
        }
        System.out.print(sb);
	}
	
	private static int getk(int u, int v, int lca, int k) {
		int tmp;
		if(depths[u] -depths[lca] > k) {
			for(int i=0;i<=y;i++) {
				if((k&(1<<i))>=1) {
					u = sparseTable[i][u];
					k =k ^ (1<<i);
				}
			}
			return u;
		}
		if(depths[u] - depths[lca] < k) {
			k -= depths[u] - depths[lca];
			k = depths[v] - depths[lca] - k;
			for(int i=0;i<=y;i++) {
				if((k&(1<<i))>=1) {
					v = sparseTable[i][v];
					k =k ^ (1<<i);
				}
			}
			return v;
		}
		return lca;
	}

	private static int getlca(int u, int v) { 
		if(depths[u]<depths[v]) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		
		for(int i=0;i<=y;i++) {
			if(((depths[u]-depths[v])&(1<<i))>=1) {
				u = sparseTable[i][u];
			}
		}
		if(u==v) {
			return u;
		}
		
		for(int i=y;i>=0;i--) {
			if(sparseTable[i][u] != sparseTable[i][v]) {
				u = sparseTable[i][u];
				v = sparseTable[i][v];
			}
		}
		return sparseTable[0][u];
		
	}
	
	private static long uv(int u, int v) {
		long sum=0L; 
		
		if(depths[u]<depths[v]) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		
		for(int i=0;i<=y;i++) {
			if(((depths[u]-depths[v])&(1<<i))>=1) {
				sum += prices[i][u];
				u = sparseTable[i][u];
			}
		}
		if(u==v) {
			return sum;
		}
		
		for(int i=y;i>=0;i--) { //LCA 바로 아래까지만 움직임
			if(sparseTable[i][u] != sparseTable[i][v]) {
				sum += prices[i][u];
				sum += prices[i][v];
				u = sparseTable[i][u];
				v = sparseTable[i][v];
			}
		}
		sum += prices[0][u] + prices[0][v];
		return sum;
		
	}
	private static void dfs(VE now) {
		for(VE next : tree.get(now.v)) {
			if(depths[next.v]==0) {
				depths[next.v] = depths[now.v] + 1;
				sparseTable[0][next.v] = now.v;
				prices[0][next.v] = next.e;
				dfs(next);
			}
		}
	}
}
