#include<iostream>
#include<queue>
using namespace std;
int main(int argc, char** argv)
{
	priority_queue<pair<int, int> > pq;
	int N, first, second, answer, target;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> first >> second;
		pq.push(make_pair(first, second));
	} // input

	answer = 0;
	target = 987654321;

	while(!pq.empty())
	{
		first = pq.top().first;
		second = pq.top().second;
		pq.pop();

		if(second <= target)
		{
			answer++;
			target = first;
		}
	}
	cout << answer;
	return 0;
}