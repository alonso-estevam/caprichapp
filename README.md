# CaprichApp
Repositório dedicado aos exercícios propostos por João Lucas Scharf neste link: https://aleatorio.dev.br/posts/ideias-programar/.
Em cada item, trarei o enunciado do exercício e os requisitos, depois algumas observações sobre minha resolução e o que aprendi com o exercício.

### Capítulo 1: Prova de conceito
Você foi recém contratado para estagiar na revista Capriche. É a revista jovem mais balada do Brasil, o carro chefe da revista são os questionários que respondem perguntas extremamente importantes como: “será que o Crush está afim de você”, “Qual profissão é mais a sua cara” e “De qual casa de hogwarts você seria”.

Você chega no seu primeiro dia de trabalho cheio de energia e vontade de programar. Por uma série de problemas na contratação, o seu chefe, Delipe Fylon, não estava preparado para fazer uma recepção apropriada. Por causa disso, ele inventa uma atividade em cima da hora, sem muito planejamento e com a cobrança de prazo para o quanto antes. Você precisa automatizar a execução desses questionários para ele apresentar para a diretoria.

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
Outro aprendizado foi na criação da branch para a tarefa específica do questionário: eu criei primeiro na minha máquina local e fiz os commits. Na hora de subir para o repositório remoto, apareceu a seguinte mensagem:
```
fatal: The current branch feat/capitulo-1-questionario-estatico has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream origin feat/capitulo-1-questionario-estatico

```
Consegui resolver simplesmente com o comano `git push -u origin feat/capitulo-1-questionario-estatico`, mas vou pesquisar mais o que exatamente significa o erro acima.
