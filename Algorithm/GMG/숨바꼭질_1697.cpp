// visited 관리를 하지 않아 이미 들른 곳을 계속 들렀고, 메모리가 터졌다. 

#include <iostream>
#include <queue>
using namespace std;
int main()
{
	int N, K, location, time;
	cin >> N >> K;
	queue<int> ql;
	queue<int> qt;
	bool visited[100001] = {false};
	
	visited[N] = true;
	ql.push(N);
	qt.push(0);
	
	while(!ql.empty())
	{
		location = ql.front();
		time = qt.front();
		
		ql.pop();
		qt.pop();
		
		if (location == K)
		{
			break;
		}
		
		if (location * 2 <= 100000 && !visited[location * 2])
		{
			visited[location * 2] = true;
			ql.push(location * 2);
			qt.push(time + 1);
		}
		
		if (location + 1 <= 100000 && !visited[location + 1])
		{
			visited[location + 1] = true;
			ql.push(location + 1);
			qt.push(time + 1);
		}
		
		if (location -1 > -1 && !visited[location - 1])
		{
			visited[location - 1] = true;
			ql.push(location - 1);
			qt.push(time + 1);
		}
	}
	
	cout << time;
	return 0;
}