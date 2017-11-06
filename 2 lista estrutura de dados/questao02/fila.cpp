#include "fila.h"
#include<iostream>

Fila::Fila(){
    this->setInicio(NULL);
    this->setTamanho(0);
    this->setFim(NULL);
}

No *Fila::getInicio(){
    return this->inicio;
}

void Fila::setInicio(No *no){
    if(no != NULL)
        this->inicio = no;
}

No *Fila::getFim(){
    return this->fim;
}

void Fila::setFim(No *no){
    if(no != NULL)
        this->fim= fim;
}

void Fila::setTamanho(int tamanho){
    if(tamanho >= 0)
        this->tamanho = tamanho;
}

int Fila::size(){
    return this->tamanho;
}



void Fila::adiciona(int numero){
    No *no = new No(numero);
    if(this->size() > 0)
        this->getFim()->setProximo(no);
    this->setFim(no);
    if(this->size() == 0)
        this->setInicio(no);

    this->setTamanho(this->size() + 1);
}

int Fila::remove(){
    if(this->size() < 1){
        std::cout << "A fila esta vazia" << std::endl;
        return NULL;
    }
    No *no = this->getInicio();
    int numero = no->getNumero();
    this->setInicio(no->getProximo());
    free(no);
    this->setTamanho(this->size() - 1);
    return numero;
}

void Fila::imprime(){
    std:: cout << "( ";
    Fila fila = *this;
    while(fila.size() != 0){
        std::cout << "[" << fila.remove() << "] ";
    }
    std::cout << ")";

}
