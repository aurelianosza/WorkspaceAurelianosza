#include<iostream>
#include "fabrica.h"
#include "../questao01/pilha.h"
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
        this->mudarCaixa(this->getPilhaA(),this->getPilhaB());
        this->getPilhaA()->attach(numero);
        this->mudarCaixa(this->getPilhaB(), this->getPilhaA());
    }
    else{
        int contador = 1;
        //Pilha *comandos = new Pilha();
        Pilha *comando1, *comando2;
        while(this->getPilhaA()->size() != 0 && numero > this->getPilhaA()->getInicio()->getNumero()){
            try{
                if(contador == 1){// CASO O COUNTER TENHA O VALOR 1, OCORRERÁ UMA AÇÃO ENTRE A PILHA A E B

                    if(this->getPilhaB()->size() == 0)
                        throw 1;
                    if(this->getPilhaA()->size() == 0)
                        throw 2;

                    if(this->getPilhaA()->getInicio()->getNumero() > this->getPilhaB()->getInicio()->getNumero()){
                        do{
                            this->mudarCaixa(this->getPilhaA(), this->getPilhaB());
                            comando1->attach(1);
                            comando2->attach(2);
                        }while(this->getPilhaB()->getInicio()->getNumero() == this->getPilhaA()->getInicio()->getNumero());
                    }else{
                        do{
                            this->mudarCaixa(this->getPilhaB(), this->getPilhaA());
                            comando1->attach(2);
                            comando2->attach(1);
                        }while(this->getPilhaB()->getInicio()->getNumero() == this->getPilhaA()->getInicio()->getNumero());
                    }

                }else if(contador == 2){// CASO O COUNTER TENHA O VALOR 2, OCORRERÁ UMA AÇÃO ENTRE A PILHA A E C

                    if(this->getPilhaC()->size() == 0)
                        throw 3;
                    if(this->getPilhaA()->size() == 0)
                        throw 2;

                    if(this->getPilhaA()->getInicio()->getNumero() > this->getPilhaC()->getInicio()->getNumero()){
                        do{
                            this->mudarCaixa(this->getPilhaA(), this->getPilhaC());
                            comando1->attach(1);
                            comando2->attach(3);
                        }while(this->getPilhaC()->getInicio()->getNumero() == this->getPilhaA()->getInicio()->getNumero());
                    }else{
                        do{
                            this->mudarCaixa(this->getPilhaC(), this->getPilhaA());
                            comando1->attach(3);
                            comando2->attach(1);
                        }while(this->getPilhaC()->getInicio()->getNumero() == this->getPilhaA()->getInicio()->getNumero());
                    }

                }else if(contador == 3){// CASO O COUNTER TENHA O VALOR 3, OCORRERÁ UMA AÇÃO ENTRE A PILHA B E C

                    if(this->getPilhaB()->size() == 0)
                        throw 4;
                    if(this->getPilhaC()->size() == 0)
                        throw 5;


                    if(this->getPilhaB()->getInicio()->getNumero() > this->getPilhaC()->getInicio()->getNumero()){
                        do{
                            this->mudarCaixa(this->getPilhaB(), this->getPilhaC());
                            comando1->attach(2);
                            comando2->attach(3);
                        }while(this->getPilhaC()->getInicio()->getNumero() == this->getPilhaB()->getInicio()->getNumero());
                    }else{
                        do{
                            this->mudarCaixa(this->getPilhaC(), this->getPilhaB());
                            comando1->attach(3);
                            comando2->attach(2);
                        }while(this->getPilhaC()->getInicio()->getNumero() == this->getPilhaB()->getInicio()->getNumero());
                    }

                }

            }catch(int excecao){

                if(excecao == 1){
                    do{
                        this->mudarCaixa(this->getPilhaA(), this->getPilhaB());
                        comando1->attach(1);
                        comando2->attach(2);
                    }while(this->getPilhaB()->getInicio()->getNumero() == this->getPilhaA()->getInicio()->getNumero());
                }else if(excecao == 2){
                    break;
                }else if(excecao == 3){
                    do{
                        this->mudarCaixa(this->getPilhaA(), this->getPilhaC());
                        comando1->attach(1);
                        comando2->attach(3);
                    }while(this->getPilhaC()->getInicio()->getNumero() == this->getPilhaA()->getInicio()->getNumero());
                }else if(excecao == 5){
                    do{
                        this->mudarCaixa(this->getPilhaB(), this->getPilhaC());
                        comando1->attach(2);
                        comando2->attach(3);
                    }while(this->getPilhaC()->getInicio()->getNumero() == this->getPilhaB()->getInicio()->getNumero());
                }else if(excecao == 4){
                    do{
                        this->mudarCaixa(this->getPilhaC(), this->getPilhaB());
                        comando1->attach(3);
                        comando2->attach(2);
                    }while(this->getPilhaC()->getInicio()->getNumero() == this->getPilhaB()->getInicio()->getNumero());
                }

            }

            contador == 3 ? contador = 1: contador++;
        }
    }
}

void Fabrica::mudarCaixa(Pilha *pilha1, Pilha *pilha2){
    if(pilha1->getInicio()->getNumero() > pilha2->getInicio()->getNumero()){
        std::cout << "ERROR";
        exit(1);
    }

    pilha2->attach(pilha1->dettach());
}
