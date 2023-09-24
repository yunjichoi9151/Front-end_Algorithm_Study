#include <iostream>
#include <map>
using namespace std;
int main()
{
	long long N, a, b, joy;
	cin >> N;
	joy = 0;

	if (N == 1)
	{
		cout << 0;
		return 0;
	}

	map<int, int> m;
	m.insert(make_pair(-N, 1));

	a = 0; // first half
	b = 0;
	while (!m.empty())
	{
		int key = -(m.begin()->first);
		int val = m.begin()->second;
		//cout << "key : " << key << " / val : " << val << endl;
		m.erase(-key); // 여기 마이너스 빼먹어서 무한 루프.

		if (key % 2 == 0)
		{
			a = key / 2;
			joy += a * a * val;
			if (a != 1)
			{
				if (m.find(-a) == m.end())
				{
					m.insert(make_pair(-a, 0));
					//cout << "make_pair : " << a;
				}
				m[-a] += val * 2;
				//cout << "m[-" << a << "] : " << m[-a] << endl;
			}
		}
		else
		{
			a = key / 2 + 1;
			b = key / 2;
			joy += a * b * val;
			if (a != 1)
			{
				if (m.find(-a) == m.end())
				{
					m.insert(make_pair(-a, 0));
					//cout << "make_pair : " << a;
				}
				m[-a] += val;
				//cout << "m[-" << a << "] : " << m[-a] << endl;
			}
			if (b != 1)
			{
				if (m.find(-b) == m.end())
				{
					m.insert(make_pair(-b, 0));
					//cout << "make_pair : " << b;
				}
				m[-b] += val;
				//cout << "m[-" << b << "] : " << m[-b] << endl;
			}
		}
	}
	cout << joy;
	return 0;
}