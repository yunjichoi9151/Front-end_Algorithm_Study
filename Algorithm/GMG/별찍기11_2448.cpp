#include <iostream>
using namespace std;

bool arr[3072][6144]; 
// !!! 가능한 가장 큰 사이즈의 arr을 전역변수로 선언. 

void star(int r, int c, int N)
{
	if (N == 3)
	{
		arr[r][c] = true;
		arr[r + 1][c - 1] = true;
		arr[r + 1][c + 1] = true;
		arr[r + 2][c - 2] = true;
		arr[r + 2][c - 1] = true;
		arr[r + 2][c] = true;
		arr[r + 2][c + 1] = true;
		arr[r + 2][c + 2] = true;

	}
	else
	{
		int newN = N / 2;
		
		star(r, c, newN);
		star(r + newN, c - newN, newN);
		star(r + newN, c + newN, newN);
	}
}

int main()
{
	int rows, cols, N;
	cin >> N;
	rows = N;
	cols = 2 * N - 1;
	
	star(0, N - 1, N);
	
	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			if (arr[i][j] == true)
			{
				cout << "*";
			}
			else
			{
				cout << " ";
			}
		} // 한 글자 
		cout << endl; 
	} // 한 줄 
	
	return 0;	
}