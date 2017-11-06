#ifndef NO_H
#define NO_H


class No
{
    public:
        No(int numero);
        virtual ~No();

        void setProximo(No no);
        No getProximo();

    private:
        int *proximo;
};

#endif // NO_H
