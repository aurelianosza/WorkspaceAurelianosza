#include<iostream>
#include "fabrica.h"
#include "../questao01/pilha.h"
#include "../no.h"
Fabrica::Fabrica(){
    this->pilhaA = new Pilha();
    this->pilhaB = new Pilha();
    this->pilhaC = new Pilha();
}

Pilha *Fabrica::getPilhaA(){
    return this->pilhaA;
}

Pilha *Fabrica::getPilhaB(){
    return this->pilhaB;
}

Pilha *Fabrica::getPilhaC(){
    return this->pilhaC;
}

void Fabrica::estocar(int numero){
    if(this->getPilhaA()->size() == 0 || this->getPilhaA()->getInicio()->getNumero() >= numero){
        this->getPilhaA()->attach(numero);
    }else if(this->getPilhaA()->size() == 1){
        this->mudarCaixa(this->getPilhaA(), this->getPilhaB());
        this->getPilhaA()->attach(numero);
        this->mudarCaixa(this->getPilhaB(),this->getPilhaA());
    }else if(this->getPilhaA()->size() == 2){
        this->mudarCaixa(this->getPilhaA(),this->getPilhaB());
        this->mudarCaixa(this->getPilhaA(),this->getPilhaC());
        this->getPilhaA()->attach(numero);
        this->mudarCaixa(this->getPilhaC(),this->getPilhaA());
        this->mudarCaixa(this->getPilhaB(),this->getPilhaA());
    }else{
        Pilha comando;
        int contador = 1;
        while(this->getPilhaA()->size() > 0 && this->getPilhaA()->getInicio()->getNumero() < numero){
            if(contador == 1){
                comando.attach(contador);
                mudarCaixa(this->getPilhaA(),this->getPilhaB());
            }else if(contador == 2){
                comando.attach(contador);
                mudarCaixa(this->getPilhaA(),this->getPilhaC());
            }
            else if(contador == 3){
                comando.attach(contador);
                mudarCaixa(this->getPilhaB(),this->getPilhaC());
            }
            contador == 3 ? contador = 1 : contador++;
        }

        this->getPilhaA()->attach(numero);

        while(comando.size() > 0){
            if(comando.dettach() == 1){
                mudarCaixa(this->getPilhaA(),this->getPilhaB());
            }else if(comando.dettach() == 2){
                mudarCaixa(this->getPilhaA(),this->getPilhaC());
            }else if(comando.dettach() == 3){
                mudarCaixa(this->getPilhaB(),this->getPilhaC());
            }
        }
    }

}

void Fabrica::mudarCaixa(Pilha *pilha1, Pilha *pilha2){
    if(pilha2->size() > 0 && pilha2->getInicio()->getNumero() < pilha1->getInicio()->getNumero()){
        Pilha *pilha = pilha1;
        pilha1 = pilha2;
        pilha2 = pilha;
    }
    do{
        pilha2->attach(pilha1->dettach());
        if(pilha1->size()== 0)
            break;
    }while(pilha1->getInicio()->getNumero() == pilha2->getInicio()->getNumero());
}
