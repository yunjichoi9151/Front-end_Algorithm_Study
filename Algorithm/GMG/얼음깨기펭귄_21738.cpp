#include <iostream>
#include <queue>
#include <vector>

using namespace std;
int main()
{
	int N, S, P, a, b, flag, loc, cnt, ans;
	cin >> N >> S >> P;

	vector<int> v[328001];
	vector<int>::iterator ptr;
	bool visited[328001] = { false };
	
	for (int i = 0; i < N - 1; i++)
	{
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	} // input

	queue<int> ql;
	queue<int> qc;
	ql.push(P);
	qc.push(0);
	visited[P] = true;

	flag = 0;
	ans = 0;
	while (flag < 2)
	{
		loc = ql.front();
		cnt = qc.front();
		ql.pop();
		qc.pop();

		if (loc <= S)
		{
			flag++;
			ans += cnt;
			if (flag == 2)
			{
				cout << N - 1 - ans;
				return 0;
			}
		}

		for (ptr = v[loc].begin(); ptr != v[loc].end(); ptr++)
		{
			if (!visited[*ptr])
			{
				visited[*ptr] = true;
				ql.push(*ptr);
				qc.push(cnt + 1);
			}
		}
	}
	return 0;
}