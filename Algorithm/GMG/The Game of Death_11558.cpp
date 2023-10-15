// 1. 대입할 땐 비교연산자를 쓰고 비교할 땐 대입연산자를 썼네 내가...
// 2. 손이 하나니까 그냥 for문 돌리면 되는 건데 BFS로 접근하려 했음 바보  

#include <iostream>
using namespace std;
int main()
{
	int T, N;
	cin >> T;
	for(int tc = 1; tc <= T; tc++)
	{
		cin >> N;
		int arr[10001] = {0};
		
		for(int i = 1; i <= N; i++)
		{
			cin >> arr[i];
//			cout << endl << i << "번째 원소 : " << arr[i] << endl;
		}
		
		int idx = 1;
		
		for(int i = 1; i <= N; i++)
		{
			if (arr[idx] == idx)
			{
				cout << 0 << endl;
				break;	
			}
						
			if (arr[idx] == N)
			{
				cout << i << endl;
				break;
			}
			
			idx = arr[idx];
//			cout << "현재 인덱스는 " << idx << endl; 

			
			if (i == N)
			{
				cout << 0 << endl;				
			}
		}
	}
	return 0;
}