#include<iostream>
using namespace std;

int main(int argc, char** argv)
{
	int arr[3001][3001] = {0};
	int first[3001] = {0};
	int second[3001] = {0};

	int N, M, K, ans;
	cin >> N >> M >> K;

	for (int i = 1; i <= N; i++)
	{
		cin >> first[i];
	}
	for (int i = 1; i <= M; i++)
	{
		cin >> second[i];
	}

	ans = 0;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= M; j++)
		{
			if (first[i] == second[j])
			{
				arr[i][j] = arr[i - 1][j - 1] + 1;
				if (arr[i][j] > ans)
				{
					ans = arr[i][j];
				}
			}
		}
	}
	cout << ans;
	return 0;
}