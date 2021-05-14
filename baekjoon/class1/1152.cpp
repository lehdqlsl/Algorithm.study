#include <iostream>
using namespace std;
int main(void){
    string s;
    getline(cin, s);
    int cnt = 0;
    bool flag = true;
    for (int i = 0; i < s.length(); i++){
         if (s[i] != ' ' && flag){
         	cnt++;
         	flag = false;
		 }
		 
		 if (s[i] == ' '){         	
         	flag = true;
		 }
    }
    cout << cnt << "\n";
    return 0;
}
