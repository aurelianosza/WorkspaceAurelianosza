#include <QCoreApplication>
#include <iostream>
#include "fila.h"

using namespace std;
int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    Fila fila;

    fila.adiciona(10);

    fila.imprime();

    fila.remove();

    fila.imprime();


    exit(1);
    //return a.exec();
}
