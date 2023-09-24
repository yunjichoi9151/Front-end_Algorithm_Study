#include <iostream>
#include <string>
#include <queue>
#include <set>
using namespace std;
void pushpush(long long num, string str);

queue<long long> q;
queue<string> pathq;
set<long long> visited;

int main() {
    long long s, t; cin >> s >> t;
    string str;
    if (s == t) { cout << 0; return 0;}
    if (s == 0) { cout << -1; return 0;}
    
    pushpush(s, "");
    if (s * s <= 1e9 && s != 1) pushpush(s * s, "*");
    if (s + s <= 1e9) pushpush(s + s, "+");
    pushpush(0, "-");
    if (s != 1) pushpush(1, "/");
    
    while (!q.empty()) {
        s = q.front(); q.pop();
        str = pathq.front(); pathq.pop();
        
        if (s == t) { cout << str; return 0; };
        
        if (s * s <= 1e9) {
            set<long long>::iterator it = visited.find(s * s);
            if (it == visited.end()) pushpush(s * s, str + '*');
        }
        
        if (s + s <= 1e9) {
            set<long long>::iterator it = visited.find(s + s);
            if (it == visited.end()) pushpush(s + s, str + '+');
        }
    }
    cout << -1;
    return 0;
}

void pushpush(long long num, string str) {
    visited.insert(num);
    q.push(num);
    pathq.push(str);
}