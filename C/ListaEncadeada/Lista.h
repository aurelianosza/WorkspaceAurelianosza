#ifndef LISTA_H_INCLUDED
#define LISTA_H_INCLUDED

    typedef struct lista{
        No *inicio;
        No *fim;
        int tamanho;
    }Lista;

    Lista cria_lista(){
        Lista lista;
        lista.inicio = NULL;
        lista.tamanho = 0;
        return lista;
    }

    void adiciona_inicio(Lista *lista, int numero){
        No *no = cria_no(numero);
        no->proximo = lista->inicio;
        lista->inicio = no;
        if(lista->tamanho == 0)
            lista->fim = no;
        lista->tamanho++;
    }

    void adiciona_fim(Lista *lista, int numero){
        if(lista->tamanho == 0){
            adiciona_inicio(lista,numero);
            return;
        }
        No *no = cria_no(numero);
        lista->fim->proximo =  no;
        lista->fim = no;
        lista->tamanho++;
    }

    void adiciona_posicao(Lista *lista, int numero, int posicao){
        if(lista->tamanho == 0 || posicao <= 1){
            adiciona_inicio(lista,numero);
            return;
        }
        if(posicao > lista->tamanho + 1){
            puts("Posicao invalida");
            return;
        }
        int contador = 2;
        No *no_auxiliar = lista->inicio;
        while(contador != posicao){
            no_auxiliar = no_auxiliar->proximo;
            contador++;
        }
        No *no = cria_no(numero);
        no->proximo = no_auxiliar->proximo;
        no_auxiliar->proximo = no;
        lista->tamanho++;
    }

    int pega_inicio(Lista *lista){
        if(lista->tamanho == 0){
            puts("A lista esta vazia");
            return NULL;
        }
        return lista->inicio->numero;
    }

    int pega_ultimo(Lista *lista){
        if(lista->tamanho == 0){
            puts("A lista esta vazia");
            return NULL;
        }
        return lista->fim->numero;
    }

    int busca_posicao(Lista *lista, int posicao){
        if(lista->tamanho == 0){
            puts("A lista esta vazia");
            return NULL;
        }
        if(posicao > lista->tamanho){
            puts("posicao invalida");
            return NULL;
        }
        No *no = lista->inicio;
        int contador = 1;
        while(contador < posicao){
            no = no->proximo;
            contador++;
        }
        return no->numero;
    }

    int busca_valor(Lista *lista, int numero){
        if(lista->tamanho == 0){
            puts("A lista esta vazia");
            return NULL;
        }
        No *no = lista->inicio;
        int contador = 1;
        while(no->proximo!=NULL ){
            if(no->numero == numero)
                return contador;
            if(contador > lista->tamanho)
                break;
            contador++;
            no =no->proximo;
        }
        puts("\nA lista nao possui o numero");
    }

    int size(Lista *lista){
        return lista->tamanho;
    }

    void imprime(Lista *lista){
        if(lista->tamanho == 0){
            puts("()");
            return;
        }
        printf("( ");
        imprime(lista->inicio);
    }

#endif // LISTA_H_INCLUDED
