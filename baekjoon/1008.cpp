#include <iostream>
using namespace std;
int main(int argc, char** argv) {
	double a;
	double b;
	cin >> a;
	cin >> b;
	
	cout.precision(9);
	cout << fixed << a/b;
	

	return 0;
}
