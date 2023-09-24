#include <iostream>
using namespace std;
int main()
{
    int n, b, one, two, onesum, twomax; 
    cin >> n;
    
    onesum = twomax = 0;
    while(n--) {
        cin >> b;
        one = two = 0;
        while (b) {
            if (b % 2 == 0) {
                two++;
                b /= 2;
            } else {
                one++;
                b -= 1;
            }
        }
        onesum += one;
        if (two > twomax) twomax = two;
    }
    cout << onesum + twomax;
    return 0;
}