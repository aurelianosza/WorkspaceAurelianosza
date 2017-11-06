#include "No.h"

No::No(int numero){

}

No *No::getProximo(){
    return this->proximo;
}

void No::setProximo(No no){
    this->proximo = no;
}


