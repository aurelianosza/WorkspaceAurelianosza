#ifndef FABRICA_H
#define FABRICA_H
#include "../questao01/pilha.h"

class Fabrica{
public:
    Fabrica();
    void estocar(int numero);
    int pegar(int numero);
    Pilha *getPilhaA();
private:
    Pilha *pilhaA;
    Pilha *pilhaB;
    Pilha *pilhaC;
    Pilha *getPilhaB();
    Pilha *getPilhaC();
    void mudarCaixa(Pilha *pilha1, Pilha *pilha2);
    void liberaEspaco();
};

#endif // FABRICA_H
