#include "pilha.h"
#include <iostream>

Pilha::Pilha(){
    this->setInicio(NULL);
    this->setTamanho(0);
}

void Pilha::setInicio(No *no){
        this->inicio = no;
}

No *Pilha::getInicio(){
    return this->inicio;
}

void Pilha::setTamanho(int tamanho){
    if(tamanho >= 0)
        this->tamanho = tamanho;
}

int Pilha::size(){
    return this->tamanho;
}

void Pilha::attach(int numero){
    No *no = new No(numero);
    no->setProximo(this->getInicio());
    this->setInicio(no);

    this->setTamanho(this->size() + 1);
}

int Pilha::dettach(){
    if(this->size() == 0){
        std::cout << "A pilha esta vazia" << std::endl;
        return NULL;
    }

    No *no = this->getInicio();
    int numero = no->getNumero();

    this->setInicio(no->getProximo());
    free(no);

    this->setTamanho( this->size() - 1);
    return numero;
}

void Pilha::imprime(){
    std::cout << "(";
    Pilha pilha = *this;
    while(pilha.size() != 0)
        std::cout << " [" << pilha.dettach() << "] ";

    std::cout << ")" << std::endl;
}
