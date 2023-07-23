#include <iostream>
#include <queue>
#include <string>
#include <sstream>
using namespace std;
int main()
{
	int N, K, A, B;
	cin >> N >> K; //N은 3 ~ 1000, K는 2 ~ 30
	
	string input[1001] = {""};
	bool board[1001][1001] = {false};
	bool visited[1001] = {false};
	
	for (int i = 1; i <= N; i++)
	{
		cin >> input[i];
	}
	int flag = 0;
	for (int i = 1; i <= N - 1; i++)
	{
		for (int j = i + 1; j <= N; j++)
		{
			flag = 0;
			for (int k = 0; k < K; k++)
			{
				if (input[i][k] != input[j][k])
				{
					flag++;
				}
			}
			if (flag == 1)
			{
				board[i][j] = true;
				board[j][i] = true;
			}
		}
	} // make board
	
	queue<int> qloc;
	queue<string> qstr;
	cin >> A >> B;
	visited[A] = true;
	qloc.push(A);
	stringstream ss;
	ss << A;
	string str = ss.str();
	qstr.push(str);
	
	while(!qloc.empty())
	{
		A = qloc.front();
		str = qstr.front();
		qloc.pop();
		qstr.pop();
		if (A == B)
		{
			cout << str;
			return 0;
		}
		
		for (int i = 1; i <= N; i++)
		{
			if (board[A][i] && !visited[i])
			{
				visited[i] = true;
				qloc.push(i);
				stringstream sstemp;
				sstemp << i;
				string temp = str + " " + sstemp.str();
				qstr.push(temp);
			}
		}
	}
	
	cout << -1;
	return 0;
}