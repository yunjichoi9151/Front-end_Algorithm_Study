#include <iostream>
int main() {
    long long arr[117] = {0, 1, 1, 1};
    for (int i = 4; i < 117; i++) arr[i] = arr[i - 1] + arr[i - 3];
    int n; 
    std::cin >> n; 
    std::cout << arr[n];
    return 0;
}