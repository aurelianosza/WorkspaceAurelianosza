#include"bloco.h"

#ifndef HEAP_H
#define HEAP_H


class Heap{
public:
    Heap();
    void adiciona(int numero);
    void adiciona(double numero);
    void adiciona(void *informacao);
    void adiciona(int numero, int chave);
    void adiciona(double numero, int chave);
    void adiciona(void *informacao, int chave);
    void *remove();
    int getTamanho();
private:
    Bloco *array;
    int tamanho;
    void setTamanho(int tamanho);
    void subir(int indice);
    void descer(int indice);
};

#endif // HEAP_H
