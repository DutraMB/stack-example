### stack-example

Essa é a implementação de uma pilha utilizando uma lista encadeada. A classe Element representa cada elemento da pilha e os atributos são o valor inteiro, o elemento precedente e o mínimo atual da pilha.

A classe Stack representa a pilha e os atributos são o tamanho atual da pilha e o elemento do topo. Nessa mesma classe são disponibilizados os métodos push, pop e getMin.

A cada push, o valor do novo elemento é comparado ao valor mínimo armazenado no elemento do topo. Caso o novo elemento seja menor, o novo elemento a ser inserido conterá o novo mínimo. Caso contrário, o novo elemento a ser inserido conterá o mínimo do precedente. 

A cada pop, basta substituir o elemento do topo pelo seu próprio elemento anterior.

#### Exemplo:

    push=10
    #top
    [0]valor=10, min=10, prev=null
    #bottom
    Min = 10

    push=20
    #top
    [1]valor=20, min=10, prev=[0]
    [0]valor=10, min=10, prev=null
    #bottom
    Min = 10

    push=5
    #top
    [2]valor=5, min=5, prev=[1]
    [1]valor=20, min=10, prev=[0]
    [0]valor=10, min=10, prev=null
    #bottom
    Min = 5

    pop
    #top
    [1]valor=20, min=10, prev=[0]
    [0]valor=10, min=10, prev=null
    #bottom
    Min = 10

Os pontos positivos dessa implementação são o acesso direto ao valor mínimo (O(1)), onde há economia de processamento e a ausência de um tamanho máximo pré-definido da pilha, permitindo inserir quantos elementos forem necessários (ou comportarem a memória) sem realocação prévia. No entanto, o ponto negativo seria em relação ao armazenamento, pois para cada elemento, seria armazenado um inteiro adicional com o valor mínimo correspondente.

### License

MIT © [Marcio Branquinho Dutra](https://github.com/dutramb)
