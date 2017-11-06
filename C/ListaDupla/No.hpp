#ifndef NO_HPP_INCLUDED
#define NO_HPP_INCLUDED

    typedef struct no{
        int numero;
        struct no *proximo;
        struct no *anterior;
    }No;

    No *cria_no(int numero){
        No *no;
        no = (No*)malloc(sizeof(No));
        no->anterior = NULL;
        no->proximo = NULL;
        no->numero = numero;
        return no;
    }

    void imprime(No *no){
        printf("[%d]",no->numero);
        if(no->proximo != NULL)
            imprime(no->proximo);
    }

    void imprime_invertido(No *no){
        printf("[%d]", no->numero);
        if(no->anterior != NULL)
            imprime_invertido(no->anterior);
    }

#endif // NO_HPP_INCLUDED
