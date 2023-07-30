#include<iostream>


using namespace std;

int main(int argc, char** argv)
{
	int height[3000] = {0};
	int ans[3000] = {0};
	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> height[i];
		ans[i] = 1;
	}

	for (int i = 1; i < N; i++)
	{
		for (int j = 0; j < i; j++)
		{
			if (height[i] > height[j] && ans[j] >= ans[i])
			{
				ans[i] = ans[j] + 1;
			}
		}
	}

	int answer = 0;
	for (int i = 0; i < N; i++)
	{
		if (ans[i] > answer)
			answer = ans[i];
	}

	cout << answer;
	return 0;
}