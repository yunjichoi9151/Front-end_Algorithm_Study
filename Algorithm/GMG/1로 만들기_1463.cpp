#define MAX 1000001
#include <iostream>
using namespace std;

int arr[MAX] = {0};

void prep();

int main()
{
    
    prep();
    
    int n;
    cin >> n;
    cout << arr[n];
    return 0;
}

void prep()
{
    for (int i = 2; i < MAX; i++)
    {
        arr[i] = arr[i - 1] + 1;
        if (i % 2 == 0 && arr[i] > arr[i / 2] + 1) arr[i] = arr[i / 2] + 1;
        if (i % 3 == 0 && arr[i] > arr[i / 3] + 1) arr[i] = arr[i / 3] + 1;
    }
}