//Carlos Revilla, cfr5spw, 1/25/2022, LifeCycle.cpp


#include <iostream>
#include <string>
#include "LifeCycle.h"
using namespace std;

// Constructors and destructors - no return types
MyObject::MyObject() {
    // Important: notice how we don't define 'name' or 'id' here
    // Instead, we're setting the variables that we declared in MyObject
    name = "--default--";
    id = ++numObjs;
    cout << "MyObject Default constructor:   " << *this << endl;
}

MyObject::MyObject(string n) {
    name = n;
    id = ++numObjs;
    cout << "MyObject Parameter constructor: " << *this << endl;
}

MyObject::MyObject(const MyObject& rhs) {
    name = rhs.name;
    id = ++numObjs;
    cout << "MyObject Copy constructor:      " << *this << endl;
}

MyObject::~MyObject() {
    cout << "MyObject Destructor:            " << *this << endl;
}

// Regular methods, with return types
string MyObject::getName() const {
    return name;
}

void MyObject::setName(const string& newName) {
    name = newName;
}

// Let cout know how to print MyObjects
ostream& operator<<(ostream& output, const MyObject& obj) {
    // output in format: ("object name", id)
    return output << "(\"" << obj.name << "\", " << obj.id << ")";
}

// Prototypes for non-member functions we define later on
// These are *non-member* functions because we didn't declare them as part of the MyObject class
MyObject getMaxMyObj(const MyObject o1, const MyObject o2);
int cmpMyObj(const MyObject o1, const MyObject o2);
void swapMyObj(MyObject& o1, MyObject& o2);

// Static variables
int MyObject::numObjs = 0;  // static member for all objects in class
static MyObject staticObj("I'm static, outside of main");
