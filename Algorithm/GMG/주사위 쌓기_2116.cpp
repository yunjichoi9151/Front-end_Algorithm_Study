#include <iostream>
using namespace std;
#define fastio() ios::sync_with_stdio(false); cin.tie(NULL)

void input();
void solve(int s);
int getSide(int idx, int val);
int getMax(int idx, int side);


int n, ans = -1, can;
int dice[10000][6];
int opposite[6] = {5, 3, 4, 1, 2, 0};

int main() {
    fastio();
    input();
    for (int i = 0; i < 6; i++) solve(i);
    cout << ans;
    return 0;
}

void input() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 6; j++) cin >> dice[i][j];
    }
    return;
}

void solve(int startSide) {
    can = 0;
    int side = startSide;
    
    for (int idx = 0; idx < n; idx++) {
        can += getMax(idx, side);
        if (idx != n - 1) side = getSide(idx + 1, dice[idx][opposite[side]]);
    }
    
    if (can > ans) ans = can;
    return;
}
int getMax(int idx, int side) {
    int target = -1;
    for (int i = 0; i < 6; i++) {
        if(i != side && i != opposite[side] && dice[idx][i] > target) target = dice[idx][i];
    }
    return target;
}

int getSide(int idx, int val) {
    for (int i = 0; i < 6; i++) {
        if (dice[idx][i] == val) { 
            return i; 
        }
    }
    cout << "failed to get side\n";
    return -1;
}