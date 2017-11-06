#ifndef BLOCO_H
#define BLOCO_H


class Bloco{
public:
    Bloco(void *informacao, int chave);
    void *getInformacao();
    int getChave();
    void setInformacao(void *informacao);
    bool operator > (Bloco bloco);
private:
    int chave;
    void *informacao;
    void setChave(int chave);
};

#endif // BLOCO_H
