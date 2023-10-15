#include <iostream>
using namespace std;
#define divisor 1000000007
#define max 1000001
long long arr[max][2]; // 아주 큰 배열은 전역 변수 범위에 선언.
int main() {
    arr[1][0] = 3;
    arr[1][1] = 4;
    for (int i = 2; i < max; i++) {
        arr[i][0] = (arr[i - 1][0] * 3 + arr[i - 1][1]) % divisor;
        arr[i][1] = (arr[i - 1][0] * 4 + arr[i - 1][1] * 2) % divisor;
    }
    
    int t, n;
    cin >> t;
    while (t) {
        cin >> n;
        cout << (arr[n][0] + arr[n][1]) % divisor << "\n";
        t--;
    }
    return 0;
}