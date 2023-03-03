

import java.io.*;

import java.util.*;
public class Main {
	private static int firstLeaf;
	private static int[] max,min;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	firstLeaf=1;
        	while(firstLeaf<N) {
        		firstLeaf<<=1;
        	}
        	max=new int[firstLeaf*2];
        	Arrays.fill(max, Integer.MIN_VALUE);
        	min=new int[firstLeaf*2];
        	Arrays.fill(min, Integer.MAX_VALUE);
        	for(int j=0;j<firstLeaf;j++) {
        		max[firstLeaf+j] = j;
        		min[firstLeaf+j] = j;
        	}
        	for(int j=firstLeaf-1;j>=1;j--) {
        		max[j] = Math.max(max[j*2], max[j*2+1]);
        		min[j] = Math.min(min[j*2], min[j*2+1]);
        	}
        	for(int j=0;j<K;j++) {
        		st = new StringTokenizer(br.readLine(), " ");
            	int Q = Integer.parseInt(st.nextToken());
            	int A = Integer.parseInt(st.nextToken());
            	int B = Integer.parseInt(st.nextToken());
            	if(Q==0) {
            		edit(A,B);
            		continue;
            	}
            	int maxb = searchMax(1,0,firstLeaf-1,A,B);
            	int mina = searchMin(1,0,firstLeaf-1,A,B);
            	if(A==mina&&B==maxb) {
            		sb.append("YES").append("\n");
            	} else {
            		sb.append("NO").append("\n");
            	}
        	}
        }
        System.out.print(sb);
    }
	private static int searchMin(int node, int l, int r, int sl, int sr) {
		if (sl > r || sr < l) { 
            return Integer.MAX_VALUE;
        }

        if (sl <= l && r <= sr) { 
            return min[node];
        }
        
        return Math.min(searchMin(node * 2, l, (l + r) / 2, sl, sr), searchMin(node * 2 + 1, (l + r) / 2 + 1, r, sl, sr));
	}
	private static int searchMax(int node, int l, int r, int sl, int sr) {
		if (sl > r || sr < l) {
            return Integer.MIN_VALUE;
        }

        if (sl <= l && r <= sr) {
            return max[node];
        }

        return Math.max(searchMax(node * 2, l, (l + r) / 2, sl, sr), searchMax(node * 2 + 1, (l + r) / 2 + 1, r, sl, sr));
	}
	private static void edit(int a, int b) {
		//왜이리 코드 거지같이 짰냐 나 원래 이거 어떤 식으로 짰더라
		int tmp = max[firstLeaf+a];
		max[firstLeaf+a] = max[firstLeaf+b];
		max[firstLeaf+b] = tmp;
		int firstLeafa = firstLeaf+a;
		int firstLeafb = firstLeaf+b;
		while(firstLeafa>1) {
			firstLeafa /=2;
			firstLeafb /=2;
			max[firstLeafa] = Math.max(max[firstLeafa*2], max[firstLeafa*2+1]);
			max[firstLeafb] = Math.max(max[firstLeafb*2], max[firstLeafb*2+1]);
		}
		
		tmp = min[firstLeaf+a];
		min[firstLeaf+a] = min[firstLeaf+b];
		min[firstLeaf+b] = tmp;
		firstLeafa = firstLeaf+a;
		firstLeafb = firstLeaf+b;
		while(firstLeafa>1) {
			firstLeafa /=2;
			firstLeafb /=2;
			min[firstLeafa] = Math.min(min[firstLeafa*2], min[firstLeafa*2+1]);
			min[firstLeafb] = Math.min(min[firstLeafb*2], min[firstLeafb*2+1]);
		}
	}
	
}