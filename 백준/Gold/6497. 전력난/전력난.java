
import java.io.*;
import java.util.*;

class VVE {
	int v1;
	int v2;
	int e;
	
	VVE(int v1, int v2, int e) {
		this.v1 = v1;
		this.v2 = v2;
		this.e = e;
	}
}

public class Main {
	private static StringBuilder sb;
	
	private static int[] parents;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
        
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken()); //집의 수
	 		int n = Integer.parseInt(st.nextToken()); //길의 수
	 		if(m==0&&n==0) {
	 			break;
	 		}
			parents = new int[m+1];
			for(int i=0;i<=m;i++) {
				parents[i] = i;
			}
			PriorityQueue<VVE> pq = new PriorityQueue<>((o1,o2) -> o1.e-o2.e);
			int res =0;
	 		for(int i=0;i<n;i++) {
	 			st = new StringTokenizer(br.readLine(), " ");
	 			int x = Integer.parseInt(st.nextToken()) +1;
	 	 		int y = Integer.parseInt(st.nextToken()) +1;
	 	 		int z = Integer.parseInt(st.nextToken());
	 	 		res +=z;
	 			pq.offer(new VVE(x,y,z));
	 		}
	 		
	 		while(!pq.isEmpty()) {
	 			VVE now = pq.poll();
	 			if(find(now.v1)!= find(now.v2)) {
	 				union(now.v1,now.v2);
	 				res -= now.e;
	 			}
	 		}
	 		System.out.println(res);
		}
	}
	private static void union(int v1, int v2) {
		// TODO Auto-generated method stub
		v1 = find(v1);
		v2 = find(v2);
		if(v1<v2) {
			parents[v2] = v1;
			return;
		}
		parents[v1] = v2;
	}
	private static int find(int x) {
		// TODO Auto-generated method stub
		if(parents[x] ==x ) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
}
