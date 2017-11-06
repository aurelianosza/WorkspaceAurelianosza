#ifndef LISTA_HPP_INCLUDED
#define LISTA_HPP_INCLUDED
    typedef struct lista{
        No *primeiro;
        No *ultimo;
        int tamanho;
    }Lista;

    Lista cria_lista(){
        Lista l1;
        l1.tamanho = 0;
        l1.primeiro = NULL;
        l1.ultimo = NULL;
        return l1;
    }

    void adiciona_inicio(Lista *lista, int numero){
        No *no =  cria_no(numero);
        if(lista->primeiro != NULL)
            lista->primeiro->anterior = no;
        no->proximo = lista->primeiro;
        lista->primeiro = no;
        if(lista->tamanho == 0)
            lista->ultimo = no;
        lista->tamanho++;
    }

    void adiciona_final(Lista *lista, int numero){
        if(lista->tamanho == 0){
            adiciona_inicio(lista,numero);
            return;
        }
        No *no = cria_no(numero);
        no->anterior = lista->ultimo;
        lista->ultimo->proximo = no;
        lista->ultimo = no;
        lista->tamanho++;
    }

    void adiciona_posicao(Lista *lista, int numero, int posicao){
        if(posicao == 1){
            adiciona_inicio(lista,numero);
            return;
        }
        if(posicao == lista->tamanho + 1){
            adiciona_final(lista,numero);
            return;
        }
        if(posicao < 1 || posicao > lista->tamanho){
            printf("posicao invalida");
            return;
        }
        No *no = cria_no(numero);
        No *n1;
        if(posicao < lista->tamanho/2){
            n1 = lista->primeiro->proximo;
            int contador = 2;
            while(contador != posicao){
                n1 = n1->proximo;
                contador++;
            }
        }else{
            n1 = lista->ultimo;
            int contador = lista->tamanho;
            while(contador != posicao){
                n1 = n1->anterior;
                contador--;
            }
        }
        no->proximo = n1;
        no->anterior = n1->anterior;
        n1->anterior->proximo = no;
        n1->anterior = no;
        lista->tamanho++;
    }

    void remove_final(Lista *lista){
        if(lista->tamanho == 0){
            puts("A lista esta vazia");
            return;
        }
        No *n1;
        if(lista->tamanho == 1){
            n1 = lista->ultimo;
            lista->primeiro = NULL;
            lista->ultimo = NULL;
            free(n1);
            lista->tamanho = 0;
            return;
        }
        n1 = lista->ultimo;
        lista->ultimo = lista->ultimo->anterior;
        lista->ultimo->proximo = NULL;
        free(n1);
        lista->tamanho--;
    }

    void remove_inicio(Lista *lista){
        if(lista->tamanho == 0){
            puts("A lista esta vazia");
            return;
        }
        if(lista->tamanho == 1){
            remove_final(lista);
        }
        No *n1 = lista->primeiro;
        lista->primeiro = lista->primeiro->proximo;
        lista->primeiro->anterior = NULL;
        free(n1);
        lista->tamanho--;
    }

    void imprime(Lista *lista){
        if(lista->tamanho > 0)
            imprime(lista->primeiro);
        else
            puts("A lista esta vazia");
    }

    void imprime_invertido(Lista *lista){
        if(lista->tamanho > 0)
            imprime_invertido(lista->ultimo);
        else
            puts("A lista esta vazia");
    }

#endif // LISTA_HPP_INCLUDED
