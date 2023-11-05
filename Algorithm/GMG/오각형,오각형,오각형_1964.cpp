#include <iostream>
using namespace std;
int main() {
    int n, a; 
    cin >> n;
    a = 5;
    
    for (int i = 2; i <= n; i++) a = (a + 3 * i + 1) % 45678;
    cout << a;
    return 0;
}