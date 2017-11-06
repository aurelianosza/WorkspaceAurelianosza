#include <QCoreApplication>
#include <iostream>
#include "listacomvetor.h"

using namespace std;

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);


    ListaComVetor lista;

    lista.adicionaFinal(10);
    lista.adicionaFinal(20);
    lista.adicionaFinal(30);
    lista.adicionaFinal(40);
    lista.adicionaFinal(50);
    lista.adicionaFinal(60);
    lista.imprime();
    cout << "Removeu o numero : " << lista.removeInicio() << endl;
    lista.imprime();
    lista.removeFinal();
    lista.imprime();
    return 0;
    //return a.exec();
}
