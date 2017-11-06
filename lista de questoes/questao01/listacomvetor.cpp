#include "listacomvetor.h"
#include <iostream>

ListaComVetor::ListaComVetor(){
    this->setTamanho(0);
}

int ListaComVetor::getTamanho(){
    return this->tamanho;
}

void ListaComVetor::setTamanho(int tamanho){
    this->tamanho = tamanho;
}

void ListaComVetor::adicionaInicio(int numero){
    if(this->getTamanho() == 100){
        std::cout << "A lista esta cheia" << std::endl;
        return;
    }
    for(int i = this->getTamanho(); i >= 0; i--)
        this->vetor[i] = this->vetor[i - 1];

    this->vetor[0] = numero;
    this->setTamanho(this->getTamanho() + 1);
}

void ListaComVetor::adicionaFinal(int numero){
    if(this->getTamanho() == 100){
        std::cout << "A lista esta cheia";
        return;
    }
    this->vetor[this->getTamanho()] = numero;
    this->setTamanho(this->getTamanho() + 1);
}

void ListaComVetor::adicionaPosicao(int posicao, int numero){
    if(this->getTamanho() == 100){
        std::cout << "A lista esta cheia";
        return;
    }
    for(int i = this-> getTamanho(); i >= posicao; i--)
        this->vetor[i] = this->vetor[i - 1];

    this->vetor[posicao - 1] = numero;
    this->setTamanho(this->getTamanho() + 1);
}

int ListaComVetor::removeFinal(){
    if(this->getTamanho() == 0){
        std::cout << "A lista esta vazia" << std::endl;
        return 0;
    }
    int numero = this->vetor[this->getTamanho() - 1];
    this->setTamanho(this->getTamanho() - 1);
    return numero;
}

int ListaComVetor::removeInicio(){
    if(this->getTamanho() == 0){
        std::cout << "A lista esta vazia" << std::endl;
        return 0;
    }
    int numero = this->vetor[0];
    for(int i = 0; i < this->getTamanho(); i++ )
        this->vetor[i] = this->vetor[i + 1];
    this->setTamanho(this->getTamanho() - 1);
    return numero;
}

int ListaComVetor::removerPosicao(int posicao){
    if(this->getTamanho() == 0){
        std::cout << "A lista esta vazia" << std::endl;
        return 0;
    }
    if(posicao < 0 || posicao >= this->getTamanho()){
        std::cout << "Posicao digitada invalida"<< std::endl;
        return 0;
    }
    int numero = this->vetor[posicao];
    for(int i = posicao; i < this->getTamanho(); i++)
        this->vetor[i] = this->vetor[i + 1];
    this->setTamanho(this->getTamanho() - 1);
    return numero;
}

void ListaComVetor::imprime(){
    std::cout << "(  ";
    for(int i = 0; i < this->getTamanho(); i++)
        std::cout << " [" << this->vetor[i] << "]";
    std::cout << "  )" << std::endl;
}
