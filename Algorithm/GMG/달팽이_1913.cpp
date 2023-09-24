#include <iostream>
using namespace std;
int main()
{
	int N, target, dir, x, y, tx, ty;
	cin >> N >> target;
	dir = 0;
	x = N / 2;
	y = N / 2;
	tx = 0;
	ty = 0;

	int arr[N][N] = {0};
	arr[x][y] = 1;
	int dx[4] = {-1, 0, 1, 0};
	int dy[4] = {0, 1, 0, -1};

	int step = 2;
	int num = 2;
	
	while(num <= N * N)
	{	
		for (int i = 0; i < step / 2; i++)
		{
			x += dx[dir];
			y += dy[dir];
			arr[x][y] = num;
			num++;
			
			if (num > N * N)
			{
				break;
			}	
		} // for

		step++;
		dir = (dir + 1) % 4;
				
	} // while
	
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cout << arr[i][j] << " ";
			if (arr[i][j] == target)
			{
				tx = i;
				ty = j;
			}
		}
		cout << endl;
	}
	cout << tx + 1 << " " << ty + 1 << endl;
	
	return 0;
} // main