#ifndef TOOLS_H_INCLUDED
#define TOOLS_H_INCLUDED

int faixa_de_valores(int minimo, int maximo){
    if(minimo > maximo){
        int aux = minimo;
        minimo = maximo;
        maximo = aux;
    }
    int numero;

    while(1){
        scanf("%d",&numero);

        if(numero <= maximo && numero >= minimo)
            break;
        else
            puts("opcao invalida");
    }

    return numero;
}
#endif // TOOLS_H_INCLUDED
