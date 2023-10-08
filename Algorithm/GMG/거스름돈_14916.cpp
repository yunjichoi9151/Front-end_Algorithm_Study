#include <iostream>
using namespace std;
int main() {
    int arr[10] = {0, -1, 1, -1, 2, 1, 3, 2, 4, 3};
    int n; cin >> n;
    if (n < 10) cout << arr[n];
    else cout << arr[n % 5 + 5] + n / 5 - 1;
    return 0;
}