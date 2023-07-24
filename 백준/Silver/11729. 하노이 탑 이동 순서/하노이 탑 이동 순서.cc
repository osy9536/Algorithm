#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
#include<sstream>
#include<cstring>
#include <cstdlib>
#include<string>
#include<cmath>
using namespace std;

void hanoi(int start, int mid, int end, int n) {
	if (n == 1) {
		cout << start << ' ' << end << '\n';
	}
	else {
		hanoi(start, end, mid, n - 1);
		cout << start << ' ' << end << '\n';
		hanoi(mid, start, end, n - 1);
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n;
	cin >> n;

	cout << (int)pow(2, n) - 1 << '\n';

	hanoi(1, 2, 3, n);

}
