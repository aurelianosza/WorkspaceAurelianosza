#include <QCoreApplication>
#include <iostream>
#include "pilha.h"

using namespace std;

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    Pilha *pilha1 = new Pilha();

    pilha1->attach(2);
    pilha1->attach(3);
    pilha1->attach(4);
    pilha1->attach(5);
    pilha1->attach(6);

    pilha1->imprime();

    pilha1->dettach();
    pilha1->dettach();

    pilha1->imprime();


    return 0;
    //return a.exec();
}
