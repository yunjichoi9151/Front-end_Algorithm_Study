#include <iostream>
using namespace std;

int main() {
    int arr[1001][11] = { 0 };
    for (int i = 1; i <= 1000; i++)
    {
        if (i == 1)
        {
            for (int j = 0; j < 10; j++)
            {
                arr[i][j] = 1;
            }
            arr[i][10] = 10;
        }
        else
        {
            arr[i][0] = arr[i - 1][7];
            arr[i][1] = arr[i - 1][2] + arr[i - 1][4];
            arr[i][2] = arr[i - 1][1] + arr[i - 1][3] + arr[i - 1][5];
            arr[i][3] = arr[i - 1][2] + arr[i - 1][6];
            arr[i][4] = arr[i - 1][1] + arr[i - 1][5] + arr[i - 1][7];
            arr[i][5] = arr[i - 1][2] + arr[i - 1][4] + arr[i - 1][6] + arr[i - 1][8];
            arr[i][6] = arr[i - 1][3] + arr[i - 1][5] + arr[i - 1][9];
            arr[i][7] = arr[i - 1][4] + arr[i - 1][8] + arr[i - 1][0];
            arr[i][8] = arr[i - 1][5] + arr[i - 1][7] + arr[i - 1][9];
            arr[i][9] = arr[i - 1][6] + arr[i - 1][8];
            
            for (int j = 0; j < 10; j++)
            {
                arr[i][j] %= 1234567;
            }
            
            for (int j = 0; j < 10; j++)
            {
                arr[i][10] += arr[i][j];
            }
            
            arr[i][10] %= 1234567;
            
        }
    }
    
    int T, N;
    cin >> T;
    for (int tc = 0; tc < T; tc++)
    {
        cin >> N;
        cout << arr[N][10] << endl;
    }

    return 0;
}