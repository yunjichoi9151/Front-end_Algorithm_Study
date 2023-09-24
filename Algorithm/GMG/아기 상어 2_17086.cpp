#include <iostream>
#include <algorithm> // max()
#include <cstdlib> // abs()
using namespace std;
int main()
{
	int N, M;
	cin >> N >> M;
	int input[50][50] = {0}; // 변수 써서 만들지 말고 입력 상한으로 만들 것. 
	int safe[50][50] = {0};
	
	//input
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			int temp;
			cin >> temp;
			input[i][j] = temp;
			safe[i][j] = 64; 
		}
	}
	
	// (i, j)에 있는 상어와 (j, k)칸의 거리 계산해서 가장 큰 거 저장 
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			
			if (input[i][j] == 1)
			{
				safe[i][j] = 0;
				
				for (int k = 0; k < N; k++)
				{
					for (int l = 0; l < M; l++)
					{
						int rDiff = abs(i - k);
						int cDiff = abs(j - l);
						safe[k][l] = min(safe[k][l], max(rDiff, cDiff));
					}
				}
			}
		}
	}
	
	int result = 0;
	
		for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (safe[i][j] > result)
			{
				result = safe[i][j];	
			} 
		}
	}	
	
	cout << result;
	return 0;
}