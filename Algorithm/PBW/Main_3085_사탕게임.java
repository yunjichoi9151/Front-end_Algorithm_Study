package algo;

import java.util.*;
import java.io.*;

public class Main_3085_사탕게임 {
	// boj Silver2
	
	static char [][] board;
	static int N,result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char [N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				change_row_candy(i, j);
				change_col_candy(i, j);
			}
		}
		
		System.out.println(result);
	}
	
	static void change_row_candy(int row, int col) {
		if (col+1 < N) {
			char candy = board[row][col];
			board[row][col] = board[row][col+1];
			board[row][col+1] = candy;
			
			for (int i = 0; i < N; i++) {
				int color [] = new int [4];
				int temp = 1;
				for (int j = 0; j < N; j++) {
					if (j == N-1) {
						switch (board[j][i]) {
						case 'C':
							if (color[0] < temp) {
								color[0] = temp;
							}
							break;
						case 'P':
							if (color[1] < temp) {
								color[1] = temp;
							}
							break;
						case 'Z':
							if (color[2] < temp) {
								color[2] = temp;
							}
							break;
						case 'Y':
							if (color[3] < temp) {
								color[3] = temp;
							}
							break;
						}
					} else if (board[j][i] == board[j+1][i]) {
						temp++;
					} else {
						switch (board[j][i]) {
						case 'C':
							if (color[0] < temp) {
								color[0] = temp;
							}
							break;
						case 'P':
							if (color[1] < temp) {
								color[1] = temp;
							}
							break;
						case 'Z':
							if (color[2] < temp) {
								color[2] = temp;
							}
							break;
						case 'Y':
							if (color[3] < temp) {
								color[3] = temp;
							}
							break;
						}
						temp = 1;
					}
				}
				for (int j = 0; j < 4; j++) {
	//				System.out.println(j+"번 캔디를 "+color[j]+" 먹음");
					if (result < color[j]) {
						result = color[j];
					}
				}
			}
			for (int i = 0; i < N; i++) {
				int color [] = new int [4];
				int temp = 1;
				for (int j = 0; j < N; j++) {
					if (j == N-1) {
						switch (board[i][j]) {
						case 'C':
							if (color[0] < temp) {
								color[0] = temp;
							}
							break;
						case 'P':
							if (color[1] < temp) {
								color[1] = temp;
							}
							break;
						case 'Z':
							if (color[2] < temp) {
								color[2] = temp;
							}
							break;
						case 'Y':
							if (color[3] < temp) {
								color[3] = temp;
							}
							break;
						}
					} else if (board[i][j] == board[i][j+1]) {
						temp++;
					} else {
						switch (board[i][j]) {
						case 'C':
							if (color[0] < temp) {
								color[0] = temp;
							}
							break;
						case 'P':
							if (color[1] < temp) {
								color[1] = temp;
							}
							break;
						case 'Z':
							if (color[2] < temp) {
								color[2] = temp;
							}
							break;
						case 'Y':
							if (color[3] < temp) {
								color[3] = temp;
							}
							break;
						}
						temp = 1;
					}
				}
				for (int j = 0; j < 4; j++) {
//					System.out.println(j+"번 캔디를 "+color[j]+" 먹음");
					if (result < color[j]) {
						result = color[j];
					}
				}
			}
			
			board[row][col+1] = board[row][col];
			board[row][col] = candy;
		}
	}
	
	static void change_col_candy(int row, int col) {
		if (row+1 < N) {
			char candy = board[row][col];
			board[row][col] = board[row+1][col];
			board[row+1][col] = candy;
			
			for (int i = 0; i < N; i++) {
				int color [] = new int [4];
				int temp = 1;
				for (int j = 0; j < N; j++) {
					if (j == N-1) {
						switch (board[j][i]) {
						case 'C':
							if (color[0] < temp) {
								color[0] = temp;
							}
							break;
						case 'P':
							if (color[1] < temp) {
								color[1] = temp;
							}
							break;
						case 'Z':
							if (color[2] < temp) {
								color[2] = temp;
							}
							break;
						case 'Y':
							if (color[3] < temp) {
								color[3] = temp;
							}
							break;
						}
					} else if (board[j][i] == board[j+1][i]) {
						temp++;
					} else {
						switch (board[j][i]) {
						case 'C':
							if (color[0] < temp) {
								color[0] = temp;
							}
							break;
						case 'P':
							if (color[1] < temp) {
								color[1] = temp;
							}
							break;
						case 'Z':
							if (color[2] < temp) {
								color[2] = temp;
							}
							break;
						case 'Y':
							if (color[3] < temp) {
								color[3] = temp;
							}
							break;
						}
						temp = 1;
					}
				}
				for (int j = 0; j < 4; j++) {
	//				System.out.println(j+"번 캔디를 "+color[j]+" 먹음");
					if (result < color[j]) {
						result = color[j];
					}
				}
			}
			for (int i = 0; i < N; i++) {
				int color [] = new int [4];
				int temp = 1;
				for (int j = 0; j < N; j++) {
					if (j == N-1) {
						switch (board[i][j]) {
						case 'C':
							if (color[0] < temp) {
								color[0] = temp;
							}
							break;
						case 'P':
							if (color[1] < temp) {
								color[1] = temp;
							}
							break;
						case 'Z':
							if (color[2] < temp) {
								color[2] = temp;
							}
							break;
						case 'Y':
							if (color[3] < temp) {
								color[3] = temp;
							}
							break;
						}
					} else if (board[i][j] == board[i][j+1]) {
						temp++;
					} else {
						switch (board[i][j]) {
						case 'C':
							if (color[0] < temp) {
								color[0] = temp;
							}
							break;
						case 'P':
							if (color[1] < temp) {
								color[1] = temp;
							}
							break;
						case 'Z':
							if (color[2] < temp) {
								color[2] = temp;
							}
							break;
						case 'Y':
							if (color[3] < temp) {
								color[3] = temp;
							}
							break;
						}
						temp = 1;
					}
				}
				for (int j = 0; j < 4; j++) {
//					System.out.println(j+"번 캔디를 "+color[j]+" 먹음");
					if (result < color[j]) {
						result = color[j];
					}
				}
			}
			
			board[row+1][col] = board[row][col];
			board[row][col] = candy;
		}
	}
}
