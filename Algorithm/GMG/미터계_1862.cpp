#include <iostream>
#include <string>
using namespace std;
int main() {
    int ans = 0, multiplier = 1, temp;
    string str; cin >> str;
    for (int i = str.size() - 1; i > -1; i--) {
        temp = str[i] - '0';
        if (temp > 3) temp--;
        ans += temp * multiplier;
        multiplier *= 9;
    }
    cout << ans;
    return 0;
}