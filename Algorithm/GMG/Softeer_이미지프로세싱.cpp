#include<iostream>
#include<queue>
using namespace std;
int main(int argc, char** argv)
{
	int dr[4] = {-1, 1, 0, 0};
	int dc[4] = {0, 0, -1, 1};

	int arr[130][130] = {0};

	queue<int> rq;
	queue<int> cq;

	int H, W, Q, target, row, col, paint, nr, nc;
	cin >> H >> W;

	for (int i = 1; i <= H; i++)
	{
		for (int j = 1; j <= W; j++)
		{
			cin >> arr[i][j];
		}
	}

	cin >> Q;
	for (int i = 0; i < Q; i++)
	{
		bool visited[130][130] = {false};

		cin >> row >> col >> paint;

		target = arr[row][col];

		rq.push(row);
		cq.push(col);
		arr[row][col] = paint;
		visited[row][col] = true;

		while(!rq.empty())
		{
			row = rq.front();
			col = cq.front();
			rq.pop();
			cq.pop();
			
			for (int dt = 0; dt < 4; dt++)
			{
				nr = row + dr[dt];
				nc = col + dc[dt];

				if (arr[nr][nc] == target && !visited[nr][nc])
				{
					rq.push(nr);
					cq.push(nc);
					arr[nr][nc] = paint;
					visited[nr][nc] = true;
				}
			} // for dt
		} // while
	} // for i

	for (int i = 1; i <= H; i++)
	{
		for (int j = 1; j <= W; j++)
		{
			cout << arr[i][j];
			if (j != W)
				cout << " ";
		}
		if (i != H)
			cout << "\n";
	}

	return 0;
}