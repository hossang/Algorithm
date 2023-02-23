import java.io.*;
import java.util.*;


public class Main {
	private static long cnt =0L;
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        mergesort(arr);
        System.out.print(cnt);
	
	}
	private static void mergesort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergesort(arr,tmp,0,arr.length-1);
		
	}
	private static void mergesort(int[] arr, int[] tmp, int l, int r) {
		if(l<r) {
			int mid = l +(r-l)/2;
			mergesort(arr,tmp,l,mid);
			mergesort(arr,tmp,mid+1,r);
			merge(arr,tmp,l,r,mid);
		}
		
	}
	private static void merge(int[] arr, int[] tmp, int l, int r, int mid) {
		for(int i = l;i<=r;i++) {
			tmp[i]= arr[i];
		}
		int lp = l;
		int rp = mid+1;
		int i = l;
		while(lp <= mid && rp<=r) {
			if(tmp[lp]<= tmp[rp]) {
				arr[i++] = tmp[lp++];
			} else {
				arr[i++] = tmp[rp++];
				cnt += mid-lp+1;
			}
		}
		for(int j=lp;j<=mid;j++) {
			arr[i++]=tmp[j];
		}
		
		
	}
}
