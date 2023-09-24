#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int arr[26] = {0};
void input();

int main()
{
    int n, ans;  
    cin >> n;
    for (int i = 0; i < n; i++) input();
    sort(arr, arr + 26);
    
    ans = 0;
    for (int i = 9; i > 0; i--) ans += arr[16 + i] * i;
    cout << ans;
    return 0;
}

void input()
{
    string str;
    cin >> str;
    int place = 1;
    
    for (int i = str.size() - 1; i > -1; i--)
    {
        arr[str[i] - 'A'] += place;
        place *= 10;
    }
}