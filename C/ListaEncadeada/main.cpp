#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include "No.h"
#include "Lista.h"

    using namespace std;

    int main(){
        Lista l1 = cria_lista();
        adiciona_fim(&l1,30);
        adiciona_fim(&l1,40);
        adiciona_fim(&l1,50);
        adiciona_fim(&l1,60);
        adiciona_fim(&l1,70);
        adiciona_inicio(&l1,100);
        adiciona_inicio(&l1,678);
        adiciona_posicao(&l1,8888,9);
        adiciona_fim(&l1,58499);
        imprime(&l1);
        int x = pega_ultimo(&l1);
        if(x)
            printf("%d",x);
    }
