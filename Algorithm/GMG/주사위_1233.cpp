#include <iostream>
using namespace std;
int main() {
    int a, b, c, max, ans;
    int arr[81] = {0, };
    
    cin >> a >> b >> c;
    for (int i = 1; i <= a; i++) {
        for (int j = 1; j <= b; j++) {
            for (int k = 1; k <= c; k++) arr[i + j + k]++;
        }
    }
    
    max = -1;
    for (int i = 3; i < 81; i++) {
        if (arr[i] > max) {
            ans = i;
            max = arr[i];
        }
    }
    
    cout << ans;
    return 0;
}