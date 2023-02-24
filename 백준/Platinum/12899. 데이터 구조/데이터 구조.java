

import java.io.*;
import java.util.*;


public class Main {
	private static int firstLeaf;
	private static int[] tree;
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        firstLeaf =1;
        while(firstLeaf <2_000_001) {
        	firstLeaf<<=1;
        }
        tree = new int[firstLeaf*2];
        for(int i=0;i<N;i++) {
        	st= new StringTokenizer(br.readLine()," ");
        	int num = Integer.parseInt(st.nextToken());
        	int x = Integer.parseInt(st.nextToken());
        	if(num==1) {
        		int tmp = firstLeaf+x-1;
        		tree[tmp]+=1;
        		edit(tmp);
        	} else {
        		int tmp = search(1,1,firstLeaf,x);
        		sb.append(tmp- firstLeaf+1).append("\n");
        		tree[tmp]-=1;
        		edit(tmp);
        	}
        }
        System.out.print(sb);
	}
	private static int search(int node, int l,int r,int x) {
		while(node < firstLeaf) {
			if(tree[node*2]>=x) {
				node = node*2;
			} else {
				x = x- tree[node*2];
				node = node *2+1;
			}
		}
		return node;
	}
	private static void edit(int x) {
		while(x>1) {
			x/=2;
			tree[x] = tree[x*2] + tree[x*2+1];
		}
		
	}
}
