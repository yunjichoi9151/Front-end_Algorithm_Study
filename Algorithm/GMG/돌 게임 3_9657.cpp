#include <iostream>
using namespace std;
#define fastio() ios::sync_with_stdio(false); cin.tie(NULL)
bool arr[1001];
int main() {
    fastio();
    
    arr[1] = arr[3] = arr[4] = true;
    for (int i = 5; i < 1001; i++) {
        if (!(arr[i - 1] && arr[i - 3] && arr[i - 4])) arr[i] = true;
    }
    
    int n; cin >> n;
    if (arr[n]) cout << "SK";
    else cout << "CY";
    return 0;
}