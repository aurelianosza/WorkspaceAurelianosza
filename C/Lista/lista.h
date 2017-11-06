#ifndef LISTA_H_INCLUDED
#define LISTA_H_INCLUDED

void adiciona_fim(int *vetor, int *tamanho, int numero){
    if(*tamanho >= 10){
        system("cls");
        puts("o vetor esta cheio");
        sleep(2);
        return;
    }

    vetor[*tamanho] = numero;

    (*tamanho)++;
}

void adiciona_inicio(int *vetor, int *tamanho, int numero){
    if(*tamanho >= 10){
        system("cls");
        puts("o vetor esta cheio");
        sleep(2);
        return;
    }

    for(int i = *tamanho; i > 0; i--)
        vetor[i] = vetor[i - 1];


    vetor[0] = numero;

    (*tamanho)++;
}

void adiciona_posicao_escolhida(int *vetor, int *tamanho, int numero, int posicao){
    if(*tamanho >= 10){
        system("cls");
        puts("o vetor esta cheio");
        sleep(2);
        return;
    }
    if(posicao < 1 || posicao > *tamanho){
        system("cls");
        puts("posicao invalida");
        sleep(2);
        return;
    }

    for(int i = *tamanho; i >= posicao; i--)
        vetor[i] = vetor[i - 1];

    vetor[posicao - 1] = numero;

    (*tamanho)++;
}

void remove_final(int *tamanho){
    if(*tamanho == 0){
        system("cls");
        puts("não existem elementos na lista");
        sleep(2);
        return;
    }

    (*tamanho)--;
}

void remove_inicio(int *vetor, int *tamanho){
    if(*tamanho == 0){
        system("cls");
        puts("nao existem elementos na lista");
        sleep(2);
        return;
    }

    for(int i = 0; i < *tamanho; i++)
        vetor[i] = vetor[i + 1];

    (*tamanho)--;
}

void remove_posicao(int *vetor, int *tamanho, int posicao){
    if(*tamanho == 0){
        system("cls");
        puts("nao existem elementos na lista");
        sleep(2);
        return;
    }
    if(posicao < 1 || posicao > *tamanho){
        system("cls");
        puts("posicao invalida");
        sleep(2);
        return;
    }

    for(int i = posicao - 1; i < *tamanho; i++)
        vetor[i] = vetor [i + 1];

    (*tamanho)--;
}

int pega_pela_posicao(int *vetor, int *tamanho, int posicao){
    if(*tamanho == 0){
        system("cls");
        puts("A lista esta vazia");
        sleep(2);
        return;
    }
    if(posicao < 0 || posicao > *tamanho){
        system("cls");
        puts("posicao invalida");
        sleep(2);
        return;
    }

    return vetor[posicao - 1];
}

int pega_primeiro(int *vetor, int *tamanho){
    if(*tamanho == 0){
        system("cls");
        puts("O vetor esta vazio");
        sleep(2);
        return;
    }
    return vetor[0];
}

int pega_ultimo(int *vetor, int *tamanho){
    if(*tamanho == 0){
        system("cls");
        puts("O vetor esta vazio");
        sleep(2);
        return;
    }
    return vetor[*tamanho - 1];
}

int pega_pelo_valor(int *vetor, int *tamanho, int numero){
    if(*tamanho == 0){
        system("cls");
        puts("A lista esta vazia");
        sleep(2);
        return;
    }
    for(int i = 0; 1; i++){
        if(i == *tamanho){
            system("cls");
            puts("O valor não existe");
            sleep(2);
            return;
        }
        if(vetor[i] == numero)
                return i + 1;
    }
}

void imprime(int *vetor, int *tamanho){
    for(int i = 0; i < *tamanho; i++)
        printf("[%d] ",vetor[i]);

    puts("");
}

#endif // LISTA_H_INCLUDED
