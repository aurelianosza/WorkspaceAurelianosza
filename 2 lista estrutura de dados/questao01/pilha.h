#ifndef PILHA_H
#define PILHA_H
#include "../no.h"

class Pilha{
public:
    Pilha();
    int size();
    void attach(int numero);
    int dettach();
    void imprime();
    No *getInicio();
private:
    void setInicio(No *no);
    void setTamanho(int tamanho);
    No *inicio;
    int tamanho;
};

#endif // PILHA_H
