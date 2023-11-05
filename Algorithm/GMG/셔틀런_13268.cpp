#include <iostream>
using namespace std;
int arr[21];
int ans[100];
int main() {
    for (int i = 0; i < 21; i++) arr[i] = (i + 4) / 5;
    
    ans[0] = 0;
    int idx = 0, pos = 0;
    for (int limit = 5; limit <= 20; limit += 5) {
        if (idx == 100) break;
        while (pos < limit) ans[++idx] = arr[++pos];
        while (pos > 0) ans[++idx] = arr[--pos];
    }
    int n; cin >> n; cout << ans[n % 100];
    return 0;
}