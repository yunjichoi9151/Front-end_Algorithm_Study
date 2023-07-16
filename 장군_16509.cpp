// 왕 넘어가지 않게 검사하기. 
#include <iostream>
#include <queue>
using namespace std;
int main()
{
	bool flag = false;
	int r, c, kingR, kingC, cnt, newR, newC, firstR, firstC, secondR, secondC;
	cin >> r >> c >> kingR >> kingC;
	cnt = 0; 
	newR = 0; newC = 0; firstR = 0; firstC = 0; secondR = 0; secondC = 0;

	bool visited[10][9] = {false};
	
	int r1[8] = {0, -1, -1, 0, 0, 1, 1, 0}; // 여기 부호 반대 
	int c1[8] = {-1, 0, 0, 1, 1, 0, 0, -1};
	int r2[8] = {-1, -2, -2, -1, 1, 2, 2, 1};
	int c2[8] = {-2, -1, 1, 2, 2, 1, -1, -2};
	int r3[8] = {-2, -3, -3, -2, 2, 3, 3, 2};
	int c3[8] = {-3, -2, 2, 3, 3, 2, -2, -3};

	queue<int> rq;
	queue<int> cq;
	queue<int> cntq;
	
	visited[r][c] = true;
	
	// 코드 시작 
	
	rq.push(r);
	cq.push(c);
	cntq.push(cnt);
	
	while (!rq.empty())
	{
		r = rq.front();
		c = cq.front();
		cnt = cntq.front();
		rq.pop();
		cq.pop();
		cntq.pop();
		
		if (r == kingR && c == kingC)
		{
			flag = true;
			break;
		}
		
		for (int dt = 0; dt < 8; dt++)
		{
			firstR = r + r1[dt];
			firstC = c + c1[dt];
			secondR = r + r2[dt];
			secondC = c + c2[dt];
			newR = r + r3[dt];
			newC = c + c3[dt];
			
			if (!visited[newR][newC] && newR > -1 && newR < 10 && newC > -1 && newC < 9 && 
			!(firstR == kingR && firstC == kingC) && !(secondR == kingR && secondC == kingC) )
			{
				rq.push(newR);
				cq.push(newC);
				cntq.push(cnt + 1);
				visited[newR][newC] = true;
			}
		} // for delta
		
	} // while
	
	if (flag)
	{
		cout << cnt;
	}
	else
	{
		cout << -1;
	}
	
	return 0;
}