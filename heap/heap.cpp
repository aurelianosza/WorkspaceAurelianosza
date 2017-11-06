#include<iostream>
#include "heap.h"

Heap::Heap(){
    this->setTamanho(0);
    this->array = (Bloco*)malloc(sizeof(Bloco) * 30);
}
/*<metodo>
 *      <parametros>
 *
 *      </parametros>
 *      <passos>
 *          <passo numero="1">
 *              -verifica se tem pelo menos 1 elemento na heap
 *              <sub-passo numero="1.1">
 *                  -lanca uma excessao e retorna NULL
 *              </sub-passo>
 *              -cria um bloco auxiliar
 *              -diminui o tamanho da heap
 *              -verifica se ainda possui elementos na heap
 *              <sub-passo numero="1.2">
 *                  -pega o ultimo elemento e joga ele no topo da arvore
 *                  -chama a funcao descer, paraorganizar a heap
 *              </sub-passo>
 *              -retorna a informacao de maior prioridade.
 *          </passo>
 *      </passos>
 * </metodo>
*/
void *Heap::remove(){
    try{
        //PASSO 1:
        if(this->getTamanho() == 0)
            //PASSO 1.1
            throw 1;
        Bloco bloco = this->array[0];
        this->setTamanho(this->getTamanho() - 1);
        if(this->getTamanho() > 0){
            //PASSO 1.2
            this->array[0] = this->array[this->getTamanho()];
            this->descer(1);
        }
        return bloco.informacao;
    }catch(int excessao){
        if(excessao == 1)
            return NULL;
    }
}

void Heap::setTamanho(int tamanho){
    if(tamanho >= 0)
        this->tamanho = tamanho;
}

int Heap::getTamanho(){
    return this->tamanho;
}

void Heap::adiciona(void *informacao, int chave){
    if(this->getTamanho() >= 30)
        this->array = (Bloco*)realloc(this->array,sizeof(Bloco)*(this->getTamanho() + 1));
    this->setTamanho(this->getTamanho() + 1);
    this->array[this->getTamanho() - 1] =  Bloco(informacao,chave);
    this->subir(this->getTamanho());
}

void Heap::adiciona(int numero, int chave){
    int *ponteiro = (int*)malloc(sizeof(int));
    *ponteiro = numero;
    this->adiciona(ponteiro,chave);
}

void Heap::adiciona(int numero){
    if(this->getTamanho() > 0)
        this->adiciona(numero,this->array[this->getTamanho() - 1].getChave() - 1);
    else
        this->adiciona(numero,1);
}


void Heap::adiciona(double numero, int chave){
    float *ponteiro = (float*)malloc(sizeof(float));
    *ponteiro = numero;
    this->adiciona(ponteiro,chave);
}

void Heap::adiciona(double numero){
    if(this->getTamanho() > 0)
        this->adiciona(numero, this->array[this->getTamanho() - 1].getChave() - 1);
    else
        this->adiciona(numero,1);
}


/*
 * <metodo nome="subir" tipo-de-retorno="void">
 *
 *      <funcao numero="1">
 *          sobe na arvore ate encontrar a posicao correta
 *      </funcao>
 *
 *      <parametros>
 *          <parametro numero="1" tipo="inteiro" nome="indice"/>
 *      </parametros>
 *
 *      <passos>
 *          <passo numero="1">
 *              calcula um valor auxiliar para saber quem é o pai do galho da árvore.
 *          </passo>
 *          <passo numero="2">
 *              verifica se existe a posicao, ou no caso se ela e maios que 0, caso contrario, ja está no inicio do vetor r não hánescessidade de subir.
 *              <sub-passo numero="2.1" gatilho="se a posicao for maior ou igual a 0">
 *                  verifica se o no pai tem valor menor que o nó filho.
 *                  <sub-passo numero="2.1.1" gatilho="se a prioridade do filho for maior que a do pai">
 *                      troca os valores a posicao dos nós da arvore.
 *                  </sub-passo>
 *              </sub-passo>
 *          </passo>
 *      </passos>
 *
   </metodo> */

void Heap::subir(int indice){

    //std::cout << "voar voar subir subir " << std::endl;

    //PASSO 1:
    int auxiliar = (int)indice/2;
    //PASSO 2:
    if(auxiliar >= 1){
        //PASSO 2.1:
        if(this->array[indice - 1] > this->array[auxiliar - 1]){
            //PASSO 2.1.1
            Bloco bloco = array[indice - 1];
            this->array[auxiliar - 1] = this->array[indice - 1];
            this->array[indice - 1] = bloco;
            this->subir(auxiliar);
        }
    }
}

void Heap::descer(int indice){
    int auxiliar = (int)indice * 2;
    if(auxiliar <= this->getTamanho()){
        if(this->array[auxiliar].getChave() > this->array[auxiliar - 1].getChave() )
            j++;
        if(this->array[auxiliar - 1].getChave() < this->array[indice - 1].getChave()){
            Bloco bloco = this->array[auxiliar - 1];
            this->array[auxiliar - 1] = this->array[indice - 1];
            this->array[indice -1] = bloco;
            this->descer(auxiliar);
        }
    }
}
