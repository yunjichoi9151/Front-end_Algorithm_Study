#include<iostream>
using namespace std;

int main(int argc, char** argv)
{
	int data[101][2] = { 0 };
	int arr[101][100001] = { 0 };

	int n, k, weight, value;
	cin >> n >> k;
	for (int i = 1; i <= n; i++)
	{
		cin >> data[i][0] >> data[i][1];
	}

	for (int i = 1; i <= n; i++)
	{
		weight = data[i][0];
		value = data[i][1];
		for (int j = 1; j <= k; j++)
		{
			if (j - weight >= 0 && arr[i - 1][j - weight] + value > arr[i - 1][j])
				arr[i][j] = arr[i - 1][j - weight] + value;
			else
				arr[i][j] = arr[i - 1][j];
		}
	}
	cout << arr[n][k];
	return 0;
}