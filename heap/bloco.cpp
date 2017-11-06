#include "bloco.h"
#include<iostream>
Bloco::Bloco(void *informacao, int chave){
    this->setInformacao(informacao);
    this->setChave(chave);
}

void Bloco::setInformacao(void *informacao){
    if(informacao != NULL)
        this->informacao = informacao;
}

void Bloco::setChave(int chave){
    this->chave = chave;
}

int Bloco::getChave(){
    return this->chave;
}

bool Bloco::operator >(Bloco bloco){
    return this->getChave() > bloco.getChave() ? true :  false;
}
