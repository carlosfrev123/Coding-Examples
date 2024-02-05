/*
Carlos F Revilla
cfr5spw
"prelab4.cpp"
 */

#include <iostream>
#include <climits>
#include <cmath>
#include <string>
using namespace std;

void sizeOfTest(){

  cout << "Size of int: " << sizeof(int) << endl;
   cout << "Size of unsigned int: " << sizeof(unsigned int) << endl;
    cout << "Size of float: " << sizeof(float) << endl;
     cout << "Size of double: " << sizeof(double) << endl;
      cout << "Size of char: " << sizeof(char) << endl;
       cout << "Size of bool: " << sizeof(bool) << endl;
        cout << "Size of int*: " << sizeof(int*) << endl;
	 cout << "Size of char*: " << sizeof(char*) << endl;
	  cout << "Size of double*: " << sizeof(double*) << endl;
	 
}


void outputBinary(unsigned int x){
  int counter = 0;
  string bin = "";
  for(int i = 31; i >= 0; i--){
    if ( x & (1<<i)){
      bin.append("1");
      counter++;
    }else{
      bin.append("0");
      counter++;
    }
    if(counter%4 == 0){
      bin.append(" ");
    }
  }
  cout << bin << endl;
}
void overflow(){
 
  cout << "4294967295 + 1 = 0" << endl;

}
int main(){
  int input;
  cin >> input;
  sizeOfTest();
  overflow();
  outputBinary(input);

  return 0;

}
