#ifndef NO_H_INCLUDED
#define NO_H_INCLUDED

    typedef struct no{
        int numero;
        struct no *proximo;
    }No;

    No *cria_no(int numero){
        No *no;
        no = (No*)malloc(sizeof(No));
        no->numero = numero;
        no->proximo = NULL;
        return no;
    }

    void imprime(No *no){
        if(no->proximo == NULL){
            printf("[%d] )", no->numero);
            return;
        }
        printf("[%d] ", no->numero);
        imprime(no->proximo);
    }

#endif // NO_H_INCLUDED
