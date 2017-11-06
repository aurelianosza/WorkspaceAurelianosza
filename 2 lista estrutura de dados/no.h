#ifndef NO_H
#define NO_H


class No{
public:
    No(int numero);
    ~No();
    int getNumero();
    void setNumero(int numero);
    No *getProximo();
    void setProximo(No *no);
private:
    int numero;
    No *proximo;
};

#endif // NO_H
