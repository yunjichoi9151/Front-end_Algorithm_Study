#include <iostream>
using namespace std;
bool arr[1001];
int main() {
    arr[1] = arr[3] = true;
    for (int i = 5; i < 1001; i++) {
        if (!arr[i - 1] && !arr[i - 3] && !arr[i - 4]) arr[i] = true;
    }
    int n; cin >> n;
    if (arr[n]) cout << "CY";
    else cout << "SK";
    return 0;
}