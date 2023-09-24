	package algo;
	
	import java.io.*;
	import java.util.*;
	
	public class Main_5430_AC {
		// boj Gold5
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int T = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < T; i++) {
				String P = br.readLine();
				int n = Integer.parseInt(br.readLine());
				ArrayDeque<Integer> deque = new ArrayDeque<>();
				
				// '[',']',','로 글자를 자름 
				StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
				// deque에 자른 글자 저장
				for (int j = 0; j < n; j++) {				
					deque.add(Integer.parseInt(st.nextToken()));
				}
				
				boolean direction = true;
				boolean state = true;
				for (int j = 0; j < P.length(); j++) {
					// 명령어 판단
					if (P.charAt(j) == 'D') {
						// 삭제 명령어일때 deque가 비어있으면 error 체크 후 탈출
						if (deque.isEmpty()) {
							state = false;
							break;
						// 비어있지 않다면 방향에 맞게 삭제
						} else if (direction) {
							deque.pollFirst();
						} else {
							// 방향 전환 명령어일때, 방향 구분 bool 값을 전환
							deque.pollLast();
						}
					} else {
						direction = !direction;
					}
				}
				
				// error 체크
				if (state) {
					bw.write("[");
					int size = deque.size();
					// 방향에 맞게 하나씩 출력
					if (direction) {
						for (int j = 0; j < size; j++) {
							bw.write(deque.pollFirst().toString());
							if (j < size - 1) {
								bw.write(",");
							}
						}
					} else {
						for (int j = 0; j < size; j++) {
							bw.write(deque.pollLast().toString());
							if (j < size - 1) {
								bw.write(",");
							}
						}
					}
					bw.write("]\n");
					
				} else {
					bw.write("error\n");
				}
			}
			
			bw.flush();
			bw.close();
		}
	
	}
