

import java.io.*;
import java.util.*;


public class Main {
	private static int firstLeaf;
	private static int[] tree;
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        firstLeaf = 1;
        while (firstLeaf<N) {
        	firstLeaf <<=1;
        }
        tree = new int[firstLeaf * 2];
        for(int i=0;i<N;i++) {
        	tree[i+firstLeaf] = 1;
        }
        for(int i=firstLeaf-1;i>=1;i--) {
        	tree[i] = tree[i*2] + tree[i*2+1];
        }
        int rank = K;
        int size = N;
        sb.append('<');
        while(true) {
        	int num = search(1,rank);
        	edit(num);
        	sb.append(num-firstLeaf+1);
        	if(tree[1]!=0) {
        		sb.append(", ");
        		size--;
        		rank = (rank+K-2)%size+1;
        	} else {
        		sb.append('>');
        		break;
        	}
        }
        System.out.print(sb);
	}
	private static void edit(int num) {
		while(num>=1) {
			tree[num]--;
			num>>=1;
		}
		
	}
	private static int search(int node, int k) {
		while(node<firstLeaf) {
			if(tree[node*2]<k) {
				k= k-tree[node*2];
				node =node*2+1;
			} else {
				node = node*2;
			}
		}
		return node;
	}
}
