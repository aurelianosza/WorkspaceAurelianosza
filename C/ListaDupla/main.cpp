#include<stdio.h>
#include<stdlib.h>
#include"No.hpp"
#include"Lista.hpp"

int main(){
    Lista l1 = cria_lista();
    adiciona_inicio(&l1,5);
    adiciona_inicio(&l1,4);
    adiciona_inicio(&l1,3);
    adiciona_inicio(&l1,2);
    adiciona_inicio(&l1,67);
    adiciona_inicio(&l1,45);
    adiciona_inicio(&l1,68);
    adiciona_final(&l1,40);
    adiciona_posicao(&l1,377,7);
    imprime(&l1);
    puts("");
    remove_final(&l1);
    remove_final(&l1);
    imprime(&l1);
    puts("");
    remove_inicio(&l1);
    remove_inicio(&l1);
    imprime(&l1);

}
