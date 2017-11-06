#ifndef LISTACOMVETOR_H
#define LISTACOMVETOR_H


class ListaComVetor{
public:
    ListaComVetor();
    int getTamanho();
    void adicionaInicio(int numero);
    void adicionaFinal(int numero);
    void adicionaPosicao(int posicao, int numero);
    int removeInicio();
    int removeFinal();
    int removerPosicao(int posicao);
    void imprime();
private:
    int vetor[100];
    int tamanho;
    void setTamanho(int tamanho);
};

#endif // LISTACOMVETOR_H
