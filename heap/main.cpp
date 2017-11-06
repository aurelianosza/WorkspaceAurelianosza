#include <QCoreApplication>
#include<iostream>
#include"heap.h"
using namespace std;
int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    //cout << "olámundo" << endl;
    Heap *h1 = new Heap();

   h1->adiciona(34,6);

    cout << h1->getTamanho() << endl;

    //return a.exec();
    return 0;
}
