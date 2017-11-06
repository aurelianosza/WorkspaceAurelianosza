#include <QCoreApplication>
#include<iostream>
#include"fabrica.h"

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    Fabrica fabrica;

    fabrica.estocar(3);
    fabrica.estocar(4);
    fabrica.estocar(5);
    fabrica.estocar(6);

    fabrica.getPilhaA()->imprime();

    std::cout << "olamundo";

    //return a.exec();
}
