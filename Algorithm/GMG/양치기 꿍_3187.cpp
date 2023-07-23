#include <iostream>
#include <queue>
#include <string>
using namespace std;
int main()
{
	queue<int> rq;
	queue<int> cq;
	int dr[4] = {-1, 1, 0, 0};
	int dc[4] = {0, 0, -1, 1};
	int arr[252][252] = {0};
	bool visited[252][252] = {false};
	int R, C, frontR, frontC, newR, newC, sheep, wolf, cntSheep, cntWolf;
	cin >> R >> C;
	string str = "";
	sheep = 0; wolf = 0; cntSheep = 0; cntWolf = 0;
	
	// # : 0 / . : 1 / k : 2 : 양 / v : 3 : 늑대 
	for (int i = 1; i <= R; i++)
	{
		cin >> str;
		for (int j = 1; j <= C; j++)
		{
			int idx = j - 1;
			
			if (str[idx] == '#') {
				arr[i][j] = 0;
			} else if (str[idx] == '.') {
				arr[i][j] = 1;
			} else if (str[idx] == 'k') {
				arr[i][j] = 2;
			} else {
				arr[i][j] = 3;
			}
		}
	}
	
	for (int i = 1; i <= R; i++)
	{
		for (int j = 1; j <= C; j++)
		{
			sheep = 0;
			wolf = 0;
			if (!visited[i][j] && arr[i][j] != 0)
			{				
				rq.push(i);
				cq.push(j);
				
				while (!rq.empty())
				{
					frontR = rq.front();
					frontC = cq.front();
					rq.pop();
					cq.pop();
					if (arr[frontR][frontC] == 2)
					{
						//cout << "sheep " << frontR << " " << frontC << endl;
						sheep++;
					}
					else if (arr[frontR][frontC] == 3)
					{
						//cout << "wolf " << frontR << " " << frontC << endl;
						wolf++;
					}
					visited[frontR][frontC] = true; // 이 줄이 없어서 arr[i][j]를 두 번씩 방문함. 
					
					for (int dt = 0; dt < 4; dt++)
					{
						newR = frontR + dr[dt];
						newC = frontC + dc[dt];
						
						if (!visited[newR][newC] && arr[newR][newC] != 0)
						{
							rq.push(newR);
							cq.push(newC);
						}
						visited[newR][newC] = true;
					}
				}
				//cout << "q is empty now !! sheep : " << sheep << " / wolf : " << wolf << endl;
				if (sheep > wolf)
				{
					cntSheep += sheep;
				}
				else
				{
					cntWolf += wolf;
				}
			}
			visited[i][j] = true;
		}
	}
	cout << cntSheep << " " << cntWolf;
	return 0;
}