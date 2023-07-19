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


void star(int i, int j, int num)
{
	if (i / num % 3 == 1 && j / num % 3 == 1) {
		cout << ' ';
	}
	else if (num / 3 == 0) {
		cout << '*';
	}
	else 
		star(i, j, num/3);
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int num;
	cin >> num;
	for (int i = 0; i < num; i++)
	{
		for (int j = 0; j < num; j++)
			star(i, j, num);
		cout << '\n';
	}

}
