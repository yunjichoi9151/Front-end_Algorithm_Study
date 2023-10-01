package algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24060_알고리즘수업병합정렬1 {
	// boj Silver3
	
	static int N,K;
	static int[] arr, tmp;
	static int result = -1;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int [N];
		tmp = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(0,N-1);
		
		System.out.println(result);
	}

	private static void merge_sort(int p, int r) {
		if (cnt > K) return;
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(p, q);
			merge_sort(q+1, r);
			merge(p,q,r);
		}
	}

	private static void merge(int p, int q, int r) {
		int i = p;
        int j = q + 1;
        int t = 0;

        while(i <= q && j <= r){
            if(arr[i] < arr[j]){ 
                tmp[t++] = arr[i++]; 
            }
            else{
                tmp[t++] = arr[j++]; 
            }
        }

        while(i <= q){
            tmp[t++] = arr[i++]; 
        }

        while(j <= r){ 
            tmp[t++] = arr[j++]; 
        }

        i = p;
        t = 0;
        while(i <= r){ 
            cnt++;

            if(cnt == K){ 
                result = tmp[t]; 
               break;
            }

            arr[i++] = tmp[t++];
        }
	}
}
