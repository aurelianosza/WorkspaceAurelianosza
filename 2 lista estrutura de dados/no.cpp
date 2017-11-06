#include "no.h"
#include<iostream>
No::No(int numero){
    this->setNumero(numero);
    this->setProximo(NULL);
}

void No::setNumero(int numero){
    this->numero = numero;
}

int No::getNumero(){
    return this->numero;
}

void No::setProximo(No *no){
    this->proximo = no;
}

No *No::getProximo(){
    return this->proximo;
}
