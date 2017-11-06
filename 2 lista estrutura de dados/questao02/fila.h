#ifndef FILA_H
#define FILA_H
#include "../no.h"

class Fila{
public:
    Fila();
    void adiciona(int numero);
    int remove();
    void imprime();
    int size();

private:
    void setInicio(No *no);
    No *getInicio();
    void setFim(No *no);
    No *getFim();
    void setTamanho(int tamanho);
    No *inicio;
    No *fim;
    int tamanho;
};

#endif // FILA_H
