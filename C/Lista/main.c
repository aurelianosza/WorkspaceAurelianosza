#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "lista.h"
#include "tools.h"

int main(){
    int vetor[10], tamanho = 0;

    while(1){

        system("cls");
        imprime(&vetor,&tamanho);
        puts("");
        puts("[1] - Inserir na lista");
        puts("[2] - Remover da lista");
        puts("[3] - Pegar posicao");
        puts("[4] - SAIR");
        puts("Escolha uma opcao");

        switch(faixa_de_valores(1,4)){
            case 4:
                return 0;
            break;
            case 1:
                puts("[1] - Inserir no fim");
                puts("[2] - Inserir no inicio");
                puts("[3] - Inserir em local selecionado");
                int numero;
                switch(faixa_de_valores(1,3)){
                    case 1:
                        puts("Digite um valor");
                        scanf("%d",&numero);
                        adiciona_fim(&vetor,&tamanho,numero);
                    break;

                    case 2:
                        puts("Digite um valor");
                        scanf("%d",&numero);
                        adiciona_inicio(&vetor,&tamanho,numero);
                    break;

                    case 3:
                        puts("Digite um valor");
                        scanf("%d",&numero);
                        puts("Digite a posicao");
                        int posicao;
                        scanf("%d",&posicao);
                        adiciona_posicao_escolhida(&vetor,&tamanho,numero,posicao);
                    break;
                }
            break;
            case 2:
                puts("[1] - Remover no fim");
                puts("[2] - Remover no inicio");
                puts("[3] - Remover em local selecionado");
                switch(faixa_de_valores(1,3)){
                    case 1:
                        remove_final(&tamanho);
                    break;
                    case 2:
                        remove_inicio(&vetor,&tamanho);
                    break;
                    case 3:
                        puts("escolha uma posicao");
                        int posicao;
                        scanf("%d",&posicao);
                        remove_posicao(&vetor,&tamanho,posicao);
                    break;
                }
            break;
            case 3:
                puts("[1] - Pegar ultima posicao");
                puts("[2] - Pegar primeira posicao");
                puts("[3] - Pegar numero pela posicao");
                puts("[4] - Pegar posicao pelo numero");
                switch(faixa_de_valores(1,4)){
                    case 1:
                        if(pega_ultimo(&vetor,&tamanho)||pega_ultimo(&vetor,&tamanho)==0){
                            system("cls");
                            printf("A ultima posicao e %d",pega_ultimo(&vetor,&tamanho));
                            sleep(2);
                        }
                    break;
                    case 2:
                        if(pega_primeiro(&vetor,&tamanho)||pega_primeiro(&vetor,&tamanho) == 0){
                            system("cls");
                            printf("A primeira posicao e %d",pega_primeiro(&vetor,&tamanho));
                            sleep(2);
                        }
                    break;
                    case 3:
                        puts("digite a posicao");
                        int posicao;
                        scanf("%d",&posicao);
                        if(pega_pela_posicao(&vetor,&tamanho,posicao)||pega_pela_posicao(&vetor,&tamanho,posicao) == 0){
                            system("cls");
                            printf("A posicao %d guarda o numero %d",posicao,pega_pela_posicao(&vetor,&tamanho,posicao));
                            sleep(2);
                        }
                    break;
                    case 4:
                        puts("digite o numero");
                        int numero;
                        scanf("%d",&numero);
                        if(pega_pelo_valor(&vetor,&tamanho,numero)){
                            system("cls");
                            printf("O valor %d esta na posicao %d", numero, pega_pelo_valor(&vetor,&tamanho,numero));
                            sleep(2);
                        }
                    break;
                }
            break;
        }
    }
}
