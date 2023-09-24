package algo0408;

import java.util.*;
import java.io.*;

public class Main_1107_리모컨 {
    // boj Gold5
    static int N,M,channel,cnt;
    static boolean [] remocon;

    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        cnt = 0;
        int temp = N;
        while(temp > 0){      
            temp = temp/10;
            cnt++;
        }

        remocon = new boolean [10];
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int dummy = Integer.parseInt(st.nextToken());
                remocon[dummy] = true;
            }
        }

        channel = Math.abs(N-100);
        
        if (N < 10) {
        	for (int i = 0; i < 10; i++) {
        		if (!remocon[i]) {
        			int dummy = Math.abs(N - i) + 1;
        			if (dummy < channel) {
        				channel = dummy;						
					}
        		}
        	}
        }
        if (N != 0) {
        	perm(1,0,0);        				
		}
        
        System.out.println(channel);
        
    }

    private static void perm(int ten,int result,int btn) {
		if (btn == cnt + 2) {
		    return;
		}
		
		if (btn != 0) {			
			int temp = Math.abs(N - result);
			if (temp + btn < channel) {
				channel = temp + btn;
			}
		}
    	
        for (int i = 0; i < 10; i++) {
            if (!remocon[i]) {
                perm(ten*10, result+i*ten,btn+1);
            }
        }
    }
}