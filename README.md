# CaprichApp
Repositório dedicado aos exercícios propostos por João Lucas Scharf neste link: https://aleatorio.dev.br/posts/ideias-programar/.
Em cada item, trarei o enunciado do exercício e os requisitos, depois algumas observações sobre minha resolução e o que aprendi com o exercício.

### Capítulo 1: Prova de conceito
"Você foi recém contratado para estagiar na revista Capriche. É a revista jovem mais balada do Brasil, o carro chefe da revista são os questionários que respondem perguntas extremamente importantes como: “será que o Crush está afim de você”, “Qual profissão é mais a sua cara” e “De qual casa de hogwarts você seria”.

Você chega no seu primeiro dia de trabalho cheio de energia e vontade de programar. Por uma série de problemas na contratação, o seu chefe, Delipe Fylon, não estava preparado para fazer uma recepção apropriada. Por causa disso, ele inventa uma atividade em cima da hora, sem muito planejamento e com a cobrança de prazo para o quanto antes. Você precisa automatizar a execução desses questionários para ele apresentar para a diretoria."

Seguem as instruções:

* Escreva um programa em linha de comando para fazer questionário com o tema "Você está afim do seu melhor amigo?";
* Esse programa fará várias perguntas diferentes e aceitará apenas as entradas 'S' e 'N';
* Para cada pergunta respondida 'S', ele deve somar um ponto. Cada pergunta respondida 'N' ele não soma nada;
* Ao final da execução, o programa responderá o usuário de acordo com a soma dos pontos. 
* A lista de perguntas é:
```
A) "Você já sonhou que seu melhor amigo era um unicórnio voando sobre arco-íris cor-de-rosa enquanto segurava um buquê de salsichas?"
B) "Você já se viu dançando a dança do frango em homenagem ao aniversário do seu melhor amigo, vestida de pinguim?"
C) "Se seu melhor amigo fosse um sorvete, ele seria o sorvete de pistache?"
D) "Você pensa em patos de borracha quando olha para o seu melhor amigo?"
E) "Você já escreveu um poema de amor épico para o seu melhor amigo usando apenas emojis de vegetais?"
F) "Você acha que seu melhor amigo seria um bom companheiro numa luta contra zumbis alienígenas usando almofadas como armas?"
```
* E a pontuação:
```
- De 0 a 2 pontos: você colocou seu melhor amigo na friendzone. O que é ótimo porque talvez ele seja apenas seu amigo
- De 3 a 4 pontos: Talvez haja amor, talvez seja hormônios. Vale a pena experimentar uns cinco minutos de trocação de beijo sem estragar a amizade.
- 5 ou mais pontos: É o amor /Que mexe com minha cabeça e me deixa assim/ Que faz eu pensar
```
===================================
### Resolução
Para essa primeira tarefa, criei um projeto Maven visando a evolução da aplicação e possibilitando a implementação de testes desde o início.
As perguntas foram armazenadas em um ArrayList de String, para facilitar a iteração. Através do enhanced for loop, cada pergunta é exibida no console, junto com o método do Scanner para pegar o input do usuário, verificar se é S ou N e somar ou não um ponto.
Fiz um método separado para calcular o resultado, facilitando a legibilidade e separação de responsabilidades.
### Aprendizados
Em relação ao versionamento, tentei seguir o "Feature Branch Workflow", então cada tarefa/feature terá sua própria branch. Um erro que aconteceu foi que o git na minha máquina está com o nome default da branch principal de "master", mas aqui no meu github está "main". Assim, quando tentei fazer outro commit inicial e dar merge, a branch "master" da minha máquina apareceu aqui como uma branch à parte. 
Para renomear a minha branch local que estava com o nome "master", usei o comando: `git branch -m master main`
Outro aprendizado foi na criação da branch para a tarefa específica do questionário: eu criei primeiro na minha máquina local e fiz os commits. Na hora de subir para o repositório remoto, apareceu a seguinte mensagem:
```
fatal: The current branch feat/capitulo-1-questionario-estatico has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream origin feat/capitulo-1-questionario-estatico

```
Consegui resolver simplesmente com o comano `git push -u origin feat/capitulo-1-questionario-estatico`, mas vou pesquisar mais o que exatamente significa o erro acima.

### Capítulo 2: 
"Você chega no dia seguinte ao trabalho. Você mal dormiu para conseguir terminar no prazo a tarefa que ele definiu em cima da hora e criou um senso de urgência desnecessário. Apesar disso, o animo está tomando conta de você. É a sua primeira entrega e você mostra seus avanços para Delipe Fylon. Após olhar sério, ele pergunta se a inteligência é algo que falta para você. Não importa de você fez exatamente o que ele falou, você fez errado. Quem liga para um questionário que tem sempre as mesmas perguntas? Você precisa criar um banco de perguntas e usar as perguntas desse banco. A ordem das respostas deve ser aleatória a cada execução. Nas palavras dele “A vida não é uma versão de meu primeiro amor onde as pessoas descobrem que estão apaixonados pelo melhor amigo. A vida é mais como Donnie Darko onde nada faz sentido. Como eu sou uma boa pessoa, vou lhe passar os requisitos para uma boa enquete bem como perguntas de qualidade:” "

* Altere o programa para consultar as perguntas do banco de perguntas
* A aplicação deverá escolher apenas 5 perguntas aleatórias desse banco, de tal forma que duas execuções seguidas tenham perguntas diferentes;
* A aplicação não pode repetir a pergunta, caso a pergunta escolhida já exista, a aplicação deverá escolher outra;
* Para cada pergunta respondida 'S', ele deve somar um ponto. Cada pergunta respondida 'N' ele não soma nada;
* Ao final da execução, o programa deve responder de acordo com a nota dada. 
* Você pode utilizar a mesma pontuação do Capítulo anterior.
* A lista para o banco de perguntas é:
```
"Você já sonhou em fazer uma viagem à Lua com seu melhor amigo?"
"Você acha que seu amigo é a reencarnação de um unicórnio?"
"Você já considerou mudar seu nome para Geleca apenas para combinar com o apelido do seu amigo?"
"Você acredita que seu amigo é secretamente um super-herói disfarçado?"
"Você já planejou uma festa surpresa de aniversário para o seu amigo no dia errado, só para ver a reação?"
"Você acha que seu amigo é a única pessoa capaz de decifrar porque o cocô das cabras é redondo e o do wombat é quadrado?"
"Você já pensou em criar um clube exclusivo para pessoas que usam pijamas de abacaxi nas segundas-feiras?"
"Você consegue segurar o tchan?"
"Você já considerou tatuar uma imagem de batata frita no braço em homenagem ao seu amigo?"
"Você já pensou em criar um podcast sobre teorias da conspiração envolvendo a vida secreta do seu melhor amigo?"
"Você acredita que seu amigo é a verdadeira inspiração por trás das músicas de karaokê?"
"Você acha que seu amigo possui um diploma honorário em Mímica Avançada?"
"Você acha que seu amigo é o verdadeiro criador das terríveis baratas voadoras?"
```
===================================
### Resolução
Para gerar números aleatórios eu sabia da existência da classe `Random`, e para o problema de não repetir a pergunta pensei em um conjunto (interface `Set`), especificamente a implementação `HashSet`, porque essa classe não permite elementos duplicados. Daí foi só juntar as duas coisas num método separado:
```
public static Set<String> obterPerguntasAleatorias(List<String> bancoDePerguntas) {
    // criando uma instância de HashSet
    Set<String> perguntasSelecionadas = new HashSet<>();

    // criando uma instância de Random
    Random random = new Random();

    // loop while para ir adicionando perguntas até atingir o tamanho especificado na constante NUMERO_DE_PERGUNTAS
    while(perguntasSelecionadas.size() != NUMERO_DE_PERGUNTAS) {

        // o método nextInt() da classe Random retorna um inteiro aleatório entre zero (inclusivo) e o número passado como argumento (exclusivo)
        // esse número aleatório retornado é usado como índice e argumento do método get() na lista que simula o banco de perguntas (uma List<String>)
        perguntasSelecionadas.add(bancoDePerguntas.get(random.nextInt(bancoDePerguntas.size())));
    }
    return perguntasSelecionadas; // retornando o HashSet com as perguntas selecionadas de modo aleatório
}
```

### Capítulo 3: 
Após a entrega, seu chefe apenas disse seu projeto estava tolerável e que ia levar para a diretoria. Semanas sem resposta. Muito pelo contrário. Delipe Fylon foi demitido por justa causas acusado de ter roubado o grampeador da firma e ter levado ele para as férias de verão tirando fotos do mesmo na frente de pontos turísticos. Com isso você acaba sendo promovido, passando a acumular funções sem aumento de salário. Sua nova função consiste em criar as enquetes para serem usadas. Meio sem uma orientação você acredita que pode utilizar a sua aplicação para facilitar sua vida. Após refletir um pouco você chega a conclusão de quais alterações no código você precisará escrever:

Altere o programa para ter 5 fases:

Fase 0) O programa perguntará qual é o título do questionário.
Fase 1) O programa perguntará quantas perguntas você deseja fazer.
Fase 2) Para cada pergunta, o programa perguntará quais são as opções e o peso da resposta de cada uma delas.
Fase 3) Em seguida, o programa perguntará quais são as respostas e quais são as faixas de valores utilizadas.
Fase 4) Por fim, o programa realizará a enquete ao usuário, usando como entrada os dados fornecidos nas etapas anteriores e respondendo ao que foi perguntado.

### Resolução
Nesse ponto da jornada, resolvi criar classes para representar as entidades do negócio, no caso, a Enquete. Para uma explicação um pouco mais detalhada, fiz esse vídeo:

https://www.youtube.com/watch?v=7EdSoZzXKnM

