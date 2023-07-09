#include <iostream>
#include <queue> 

// 잘 짜놨구만 dev cpp에서 안 돌아가서 헤맸네...
// 온라인 컴파일러에선 돌아감 

using namespace std;
int main()
{
	queue<pair<int, int> > q;
	int arr[1002][1002] = {0}; // (0 and 1001)(행 and 열)은 패딩... for문 범위 확인 
	int visited[1002][1002] = {0};
	int dx[4] = {-1, 1, 0, 0};
	int dy[4] = {0, 0, -1, 1};
	int N, M, red, blue, green, T, cnt;
	cin >> N >> M;
	
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= M; j++)
		{
			cin >> red >> blue >> green; 
			arr[i][j] = red + blue + green;
		}
	}
	cin >> T;
	T = T * 3;
	// cout << "T : " << T << endl;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= M; j++)
		{
			// cout << "arr[" << i << "][" << j << "] : " << arr[i][j] << endl;
			if (arr[i][j] < T)
			{
				arr[i][j] = 0;
			}
			else
			{
				arr[i][j] = 1;
			}
			// cout << "arr[" << i << "][" << j << "] : " << arr[i][j] << endl;
		}
	}
	
	cnt = 0;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= M; j++)
		{
			if (visited[i][j] == 1)
			{
				continue;
			}
			visited[i][j] = 1;
			// cout << "visited[" << i << "][" << j << "] : 1" << endl;

			if (arr[i][j] == 0)
			{
				// cout << "arr[" << i << "][" << j << "] 건너뛰기" << endl;
				continue;

			}
			// 여기 들어오면 한 덩어리 시작한 거임
			cnt++;
			q.push(make_pair(i, j));
			// cout << "q.push(make_pair(" << i << "," << j << ")" << endl;
			
			// 큐가 빌 때까지 뺑글뺑글 돌면서
			// 내부 요소 하나 빼서, 그 요소의 상하좌우 요소의 visited 확인하구 
				// i, j 범위 확인 ( 1 ~ N, 1 ~ M ) 하구 <- 아냐 패딩 만들면 범위 확인 필요 없겠다 
			// 유효한 위치면 그 요소도 큐에 넣어버리고(유효하다 : arr[i][j] == 1) 
			// 유효하든 안 하든 visited[i][j]는 1로 바꿔버림			
			
			while (!q.empty())
			{
				pair<int, int> xy = q.front();
				q.pop();
				int x = xy.first;
				int y = xy.second;
				// cout << "x : " << x << " / y : " << y << endl;
				
				for (int delta = 0; delta < 4; delta++)
				{
					int tmpx = x + dx[delta];
					int tmpy = y + dy[delta];
					// cout << "tmpx : " << tmpx << " / tmpy : " << tmpy << endl;
					if (visited[tmpx][tmpy] == 1)
					{
						continue;
					}
					visited[tmpx][tmpy] = 1;
					if (arr[tmpx][tmpy] == 1)
					{
						q.push(make_pair(tmpx, tmpy)); 
			 			// cout << "q.push(make_pair(" << tmpx << "," << tmpy << ")" << endl;
					} 
				}
			} // while
			// cout << "q is empty" << endl;
		}
	}
	
	cout << cnt;
	return 0;
}