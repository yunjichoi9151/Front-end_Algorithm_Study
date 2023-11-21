#include <iostream>
using namespace std;
#define fastio() ios::sync_with_stdio(false); cin.tie(NULL)
int main() {
    fastio();
    
    bool isAppeared[26] = {false, };
    int arr[25] = {0, };
    int n, k, s; cin >> n >> k;
    int ptr = 0;
    char ch;
    bool flag = false;
    
    while (k--) {
        cin >> s >> ch;
        ptr = (ptr + s) % n;
        if (arr[ptr] != 0 && arr[ptr] != ch) flag = true;
        if (arr[ptr] != ch && isAppeared[ch - 'A'] == true) flag = true;
        isAppeared[ch - 'A'] = true;
        arr[ptr] = ch;
    }
    if (flag) {
        cout << '!';
        return 0;
    }
    for (int i = 0; i < n; i++) {
        if (arr[(ptr + n - i) % n]) cout << (char)arr[(ptr + n - i) % n];
        else cout << '?';
    }
    return 0;
}