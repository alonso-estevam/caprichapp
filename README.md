# CaprichApp
Repositório dedicado aos exercícios propostos por João Lucas Scharf neste link: https://aleatorio.dev.br/posts/ideias-programar/.
Em cada item, trarei o enunciado do exercício e os requisitos, depois algumas observações sobre minha resolução e o que aprendi com o exercício.

<details>
    <summary><h2>Capítulo 1: questionário com perguntas estáticas</h2></summary>
    <h3>Contexto</h3>
    <p><em>
"Você foi recém contratado para estagiar na revista Capriche. É a revista jovem mais balada do Brasil, o carro chefe da revista são os questionários que respondem perguntas extremamente importantes como: “será que o Crush está afim de você”, “Qual profissão é mais a sua cara” e “De qual casa de hogwarts você seria”.

Você chega no seu primeiro dia de trabalho cheio de energia e vontade de programar. Por uma série de problemas na contratação, o seu chefe, Delipe Fylon, não estava preparado para fazer uma recepção apropriada. Por causa disso, ele inventa uma atividade em cima da hora, sem muito planejamento e com a cobrança de prazo para o quanto antes. Você precisa automatizar a execução desses questionários para ele apresentar para a diretoria."
</em></p>
<h3>Requisitos</h3>

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

<h3>Resolução</h3>
Para essa primeira tarefa, criei um projeto Maven visando a evolução da aplicação e possibilitando a implementação de testes desde o início.
As perguntas foram armazenadas em um ArrayList de String, para facilitar a iteração. Através do enhanced for loop, cada pergunta é exibida no console, junto com o método do Scanner para pegar o input do usuário, verificar se é S ou N e somar ou não um ponto.
Fiz um método separado para calcular o resultado, facilitando a legibilidade e separação de responsabilidades.
### Aprendizados
Em relação ao versionamento, tentei seguir o "Feature Branch Workflow", então cada tarefa/feature terá sua própria branch. Um erro que aconteceu foi que o git na minha máquina está com o nome default da branch principal de "master", mas aqui no meu github está "main". Assim, quando tentei fazer outro commit inicial e dar merge, a branch "master" da minha máquina apareceu aqui como uma branch à parte. 
Para renomear a minha branch local que estava com o nome "master", usei o comando: `git branch -m master main`
Outro aprendizado foi na criação da branch para a tarefa específica do questionário: eu criei primeiro na minha máquina local e fiz os commits. Na hora de subir para o repositório remoto, apareceu a seguinte mensagem:

<code>
fatal: The current branch feat/capitulo-1-questionario-estatico has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream origin feat/capitulo-1-questionario-estatico

</code>
Consegui resolver simplesmente com o comano <code>git push -u origin feat/capitulo-1-questionario-estatico</code>, mas vou pesquisar mais o que exatamente significa o erro acima.

</details>
 
<details>
    <summary><h2>Capítulo 2: questionário com perguntas dinâmicas</h2></summary>
<h3>Contexto</h3>
"Você chega no dia seguinte ao trabalho. Você mal dormiu para conseguir terminar no prazo a tarefa que ele definiu em cima da hora e criou um senso de urgência desnecessário. Apesar disso, o animo está tomando conta de você. É a sua primeira entrega e você mostra seus avanços para Delipe Fylon. Após olhar sério, ele pergunta se a inteligência é algo que falta para você. Não importa de você fez exatamente o que ele falou, você fez errado. Quem liga para um questionário que tem sempre as mesmas perguntas? Você precisa criar um banco de perguntas e usar as perguntas desse banco. A ordem das respostas deve ser aleatória a cada execução. Nas palavras dele “A vida não é uma versão de meu primeiro amor onde as pessoas descobrem que estão apaixonados pelo melhor amigo. A vida é mais como Donnie Darko onde nada faz sentido. Como eu sou uma boa pessoa, vou lhe passar os requisitos para uma boa enquete bem como perguntas de qualidade:” "
    
<h3>Requisitos</h3>
    
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

<h3>Resolução</h3>
Para gerar números aleatórios eu sabia da existência da classe `Random`, e para o problema de não repetir a pergunta pensei em um conjunto (interface `Set`), especificamente a implementação `HashSet`, porque essa classe não permite elementos duplicados. Daí foi só juntar as duas coisas num método separado:
<pre><code>
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
</code></pre>

</details>

<details>
    <summary><h2>Capitulo 3: criando questionários</h2></summary>
    <h3>Contexto</h3>
Após a entrega, seu chefe apenas disse seu projeto estava tolerável e que ia levar para a diretoria. Semanas sem resposta. Muito pelo contrário. Delipe Fylon foi demitido por justa causas acusado de ter roubado o grampeador da firma e ter levado ele para as férias de verão tirando fotos do mesmo na frente de pontos turísticos. Com isso você acaba sendo promovido, passando a acumular funções sem aumento de salário. Sua nova função consiste em criar as enquetes para serem usadas. Meio sem uma orientação você acredita que pode utilizar a sua aplicação para facilitar sua vida. Após refletir um pouco você chega a conclusão de quais alterações no código você precisará escrever:

<h3>Requisitos</h3>
Altere o programa para ter 5 fases:

Fase 0) O programa perguntará qual é o título do questionário.
Fase 1) O programa perguntará quantas perguntas você deseja fazer.
Fase 2) Para cada pergunta, o programa perguntará quais são as opções e o peso da resposta de cada uma delas.
Fase 3) Em seguida, o programa perguntará quais são as respostas e quais são as faixas de valores utilizadas.
Fase 4) Por fim, o programa realizará a enquete ao usuário, usando como entrada os dados fornecidos nas etapas anteriores e respondendo ao que foi perguntado.

<h3>Resolução</h3>
Nesse ponto da jornada, resolvi criar classes para representar as entidades do negócio, no caso, a Enquete. Cada enquete precisaria ter um título, um número de perguntas, as perguntas em si e as faixas de valores com as respectivas respostas. Alguns desses atributos poderiam ser objetos java simples, como int (o número de perguntas) ou String (o título). Porém, outros tinham seus próprios atributos e, portanto, seria melhor transformá-los em classes.
Por exemplo, uma pergunta é composta pelo texto do enunciado e uma ou mais opções. Cada opção, por sua vez, tem um textinho e o peso, que será usado para calcular a pontuação e o resultado. Outro exemplo é a faixa de valores: cada faixa de valor tem um valor mínimo, um valor máximo e uma resposta correspondente (algo como "de 0 a 5: você seria o power ranger laranja"). E assim, fazendo esse exercício de pensar nas classes e atributos, cheguei a esse esquema:

![uml](https://github.com/alonso-estevam/caprichapp/assets/86576674/92b503dc-693c-4c1f-aced-e7343dd38476)

Para uma explicação um pouco mais detalhada, fiz <a href="https://www.youtube.com/watch?v=7EdSoZzXKnM" target="_blank">esse vídeo</a>:

[![Watch the video](https://img.youtube.com/vi/7EdSoZzXKnM/maxresdefault.jpg)](https://youtu.be/7EdSoZzXKnM)

</details>

<details>   

<summary><h2>Capítulo 4: "CRUD" e manuseio de arquivos </h2> </summary>
<h3>Contexto</h3>
Contrataram um novo gerente para substituir Delipe Fylon. No lugar dele entrou um cara simpático e meio tímido chamado Clark. Ele é alto, usa óculos, meio corpulento, tem olhos claros e tinha o apelido de super chefe na outra firma. Na primeira semana de trabalho, Clark conversa para você para entender o que você estava fazendo. Ele se impressiona bastante com o seu trabalho de até então com a aplicação. Por brincadeira, ele dá o nome de CaprichApp.

Clark diz que gostou tanto do CaprichApp que vai apresentá-lo para a diretoria (isso deixa no ar a dúvida Delipe Fylon realmente havia feito isso ou estava apenas pensando na Musa do Verão). Antes de transfomar o CaprichApp como um programa completo, Clark sugere criar um menu e deixar os questionários salvos em arquivos. Para conseguir fazer esse processo, ele pergunta se você sabe converter um objeto para json e domina o processo de manipular.

“Caso você não saiba fazer isso, é recomendado estudar essas duas habilidades ou não será possível fazer um programa legal para apresentar para a diretoria.”
<h3>Requisitos</h3>

Após confirmar que você entende bem esses conteúdos, Clark te passa os requisitos da sua nova atividade:
```
* Adicione um menu iterativo na sua aplicação. O menu terá as seguintes opções:
A) Cadastrar um questionário
B) Listar todos os questionários
C) Excluir um questionário
D) Descrever um questionário
E) Editar um questionário

* Todo questionário terá um id numérico, único e incremental
* Os questionários serão salvos em um diretório temporário (/tmp/caprichapp ou C://temp/caprichapp) chamado de *diretório base*
* Cada questionário será salvo em formato json como um arquivo separado
* No começo da execução, o aplicativo vai percorrer todos os arquivos do diretório base para saber qual é o valor atual do id
* Quando o usuário selecionar a opção cadastrar, ele terá que entrar com os dados para criar o questionário, após isso a aplicação transformará o questionário em um json e irá salvar no diretório base informando que a operação ocorreu com sucesso
* Quando o usuário selecionar a opção listar todos os questionários, a aplicação listar apenas o id e o nome do questionário
* Quando o usuário selecionar a opção excluir, ele informará um id. Após isso, a aplicação vai excluir o arquivo do diretório base e informar que o questionário foi excluído com sucesso
* Quando o usuário selecionar a opção descrever um questionário a aplicação pedirá um id. Tendo esse id, ela irá abrir o arquivo do questionário e escrever na tela o arquivo json
* Quando o usuário selecionar a opção editar, precisará informar um id. Após isso, ele terá que cadastrar as informações de um questionário como se fosse cadastrar, a aplicação excluirá o questionário e cadastrará um novo
```
<h3>Resolução</h3>
Registrei a resolução desse capítulo <a href="https://youtube.com/playlist?list=PLjo6ymz9jJsqZAKq38PLB4-0tZMtlY6gl&feature=shared" target="_blank">nessa playlist</a>
</details>

<details>
    <summary><h2>Capitulo 5: API</h2></summary>
    <h3>Contexto</h3>
Clark chega extremamente empolgado na sua mesa. Sucesso é pouco para definir o resultado da apresentação do seu protótipo. A diretoria amou o resultado. Um dos diretores é sócio de um grande portal de variedades chamado Fuzz Beed e quer utilizar o CaprichApp o quanto antes no portal. Para que tudo funcione corretamente, o CaprichApp será transformado num servidor REST. Um dos sobrinhos dos diretores estava na reunião e já definou a assinatura das APIs que você deverá usar.

Clark pergunta se você fez o CaprichApp em Java. Caso você tenha feito, ele consegue te indicar uma série tutoriais para te auxiliar nesse processo para auxiliar no trabalho. Além disso, ele te explica que num servidor REST cada requisição já vem meio que “completa” e usuário é quem irá passar os dados necessários em uma requisição sem interação com menu. Os testes da API podem ser feitos usando uma ferramenta como o curl ou o Postman.

<h3>Requisitos</h3>
Altere o CaprichApp removendo o menu e permitindo que ele atenda requisições REST conforme a especificação abaixo.

    POST: /caprichapp/create -> Deve aceitar um JSON com a descrição do questionário e cadastrar ele (semelhante ao menu cadastrar)
    GET: /caprichapp/ -> Deve retornar como um json todos questionários existentes (igual ao menu listar tudo)
    DELETE: /caprichapp/{id} - Deve excluir um questionário (igual ao menu excluir)
    GET: /caprichapp/{id} -> Deve retornar como um json os dados de um único questionár (igual ao menu descrever questionário)
    PUT: /caprichapp/{id} -> Deve aceitar um JSON com a descrição do questionário e cadastrar ele (semelhante ao menu editar)


<h3>Resolução</h3>
Parte 1 - organizando o código com DAO

A primeira coisa que tentei fazer foi organizar os métodos CRUD que estavam todos jogados na classe principal. Para isso, lembrei do padrão DAO - Data Access Object, que eu já tinha visto ser feito em aplicações que fazem conexão com banco de dados. 

Nesse padrão, para cada domínio do negócio temos uma interface com os métodos CRUD e a respectiva implementação da interface e dos métodos, fazendo uma abstração do acesso ao banco de dados. No projeto ainda não estamos trabalhando com database, mas ainda estamos persistindo dados - no caso, no sistema de arquivos do computador. Assim, criei um pacote chamado `dao`, e dentro dele criei a interface `QuestionarioDao` com os métodos:
```
List<Questionario> findAll();
Questionario findById(Integer id);
void insert(Questionario questionario);
void update(Questionario questionario);
void deleteById(Integer id);
```
No mesmo pacote, criei a classe `QuestionarioDaoFileSystem` implementando a interface `QuestionarioDao`. Além de sobrescrever os métodos para as operações CRUD, também coloquei na classe `QuestionarioDaoFileSystem` as constantes:
```
private static final Path DIRETORIO_BASE = Path.of("C:\\temp\\caprichapp");
private static final String TEMPLATE_NOME_DO_ARQUIVO = 
			DIRETORIO_BASE.toString() + File.separator + "questionario_${id}.txt";
private static final Gson GSON = new Gson();
```
Além disso, coloquei os métodos auxiliares de converter json em questionário e vice-versa e o de extrair o conteúdo de um arquivo, e refatorei os métodos para usar as classes Files e Path, do pacote java.nio.

Parte 2 - o servidor

A parte mais difícil foi pensar em como fazer um servidor para receber as requisições HTTP sem usar nenhum framework como o Spring, porque eu acho que não fazia sentido nessa etapa da trilha de estudos pular do manuseio de arquivos direto pra um framework, ainda mais sabendo que o próximo exercício é usar banco de dados (e farei primeiro com JDBC).

Nesse cenário, pesquisei como fazer um servidor simples em java e encontrei duas alternativas. A primeira era com as classes do pacote `java.net`, que é parte da biblioteca padrão do Java SE. Nesse pacote estão classes úteis para operações de rede de baixo nível, como por exemplo manusear sockets, URLs e conexões de rede. Essa alternativa me pareceu um pouco mais trabalhosa.

A outra opção estava no pacote `com.sun.net.httpserver`, que não faz parte da Java Standard Library oficial. Na verdade, é um pacote fornecido pela Oracle (Sun) JDK - que eu não fazia ideia - para a criação de servidores HTTP simples, fornecendo abstrações de alto nível para lidar com solicitações e respostas HTTP, facilitando a construção de servidores HTTP básicos. Nesse pacote estão classes como `HttpServer` e `HttpHandler` para simplificar a implementação do servidor. Em resumo, e nas palavras do ChatGPT, "a principal diferença é que o pacote `java.net` é um pacote de rede geral, enquanto o pacote `com.sun.net.httpserver` é especificamente adaptado para a criação de servidores HTTP simples".

Nesse contexto, tentei construir o servidor da API com o pacote `com.sun.net.httpserver`. Na classe principal, quem orquestra o baile é o `HttpServer`, cujo método `create` recebe um `InetSocketAddress` - aqui, basicamente passamos um endereço IP e uma porta para que seja feito um bind com a instância do servidor. 
Em seguida, usamos o método `createContext` do `HttpServer` para especificar a URI e sua respectiva `HttpHandler`, ou seja, a classe que vai lidar com as requisições para aquela determinada URI. 

Por fim, temos o método `setExecutor`, que não entendi o que faz, mas aparentemente, quando está parâmetro `null`, utiliza a implementação padrão; e o método `start`, responsável por "iniciar este servidor em um novo thread em segundo plano".

O código ficou assim:
```
HttpServer server = HttpServer.create(new InetSocketAddress(PORTA), 0);
System.out.println("Servidor rodando na porta " + PORTA);
server.createContext("/caprichapp", new QuestionarioHandler.SemParametro());
server.createContext("/caprichapp/", new QuestionarioHandler.ComParametro());
server.setExecutor(null);
server.start();
```

Uma vez criada a instância do servidor e estabelecidas as URIs, passei para a implementação dos handlers. Como todos eles se referiam à mesma entidade - o questionário - concentrei tudo na mesma classe, chamada `QuestionarioHandler`. Nela, criei uma constante para armazenar uma instância do `QuestionarioDaoFileSystem`:

`private static final QuestionarioDaoFileSystem DAO = new QuestionarioDaoFileSystem();`

e fiz uso de nested classes (classes aninhadas estáticas): dentro de `QuestionarioHandler`, criei a classe `SemParametro` para lidar com as requisições GET e POST (as que não tem id na URI, como `/caprichapp`) e a `ComParametro` para lidar com as requisições DELETE, PUT e GET by id (ou seja, as que precisariam seguir o modelo`/caprichapp/2` ). Ambas as classes aninhadas implementam a interface `HttpHandler`, que só tem um método abstrato chamado `handle` - aliás, acho que se tivesse sido criada mais recente, a `HttpHandler` seria anotada como uma interface funcional. De todo modo, o método `handle` recebe um `HttpExchange`, que, conforme a documentação, "encapsula uma solicitação HTTP recebida e uma resposta a ser gerada em uma troca. Ele fornece métodos para examinar a solicitação do cliente e para construir e enviar a resposta."

Um ponto importante é que a classe `HttpServer` não suporta diretamente a definição de rotas dinâmicas como "/caprichapp/{id}" com parâmetros de caminho, como encontramos no Spring, por exemplo. Por isso, uma solução foi extrair a parte dinâmica (o id em "/caprichapp/{id}") manualmente no handler. Gambiarristicamente, a classe `ComParametro`  ficou assim:

```
public static class ComParametro implements HttpHandler{
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String requestURI = exchange.getRequestURI().getPath();
			Integer id = null;
			
			String[] parts = requestURI.split("/");
			if(parts.length > 0) {
				id = Integer.valueOf(parts[2]);
			}
			
			if("DELETE".equals(exchange.getRequestMethod())) {
				DAO.deleteById(id);
				String response = "Questionario com id %d deletado com sucesso!".formatted(id);
				exchange.getResponseHeaders().set("Content-Type", "text/html, application/json; charset=UTF-8");
				exchange.sendResponseHeaders(200, response.getBytes().length);
				OutputStream outputStream = exchange.getResponseBody();
				outputStream.write(response.getBytes());
				outputStream.flush();
				outputStream.close();
				
			} else if("PUT".equals(exchange.getRequestMethod())) {
				StringBuilder requestBody = new StringBuilder();
				try(BufferedReader br = new BufferedReader(new InputStreamReader(
						exchange.getRequestBody(), StandardCharsets.UTF_8))){
					String linha = null;
					while((linha = br.readLine()) != null) {
						requestBody.append(linha);
					}
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
				Questionario questionario = 
						QuestionarioDaoFileSystem.converterJsonEmQuestionario(requestBody.toString());
				
				DAO.update(id, questionario);
				
				String response = "Questionario com id %d atualizado com sucesso!".formatted(questionario.getId());
				exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
				exchange.sendResponseHeaders(201, response.getBytes().length);
		        OutputStream outputStream = exchange.getResponseBody();
		        outputStream.write(response.getBytes());
		        outputStream.flush();
		        outputStream.close();
		        
			} else {
				String response = QuestionarioDaoFileSystem.converterQuestionarioEmJson(DAO.findById(id));
				exchange.getResponseHeaders().set("Content-Type", "text/html, application/json; charset=UTF-8");
				exchange.sendResponseHeaders(200, response.getBytes().length);
				OutputStream outputStream = exchange.getResponseBody();
				outputStream.write(response.getBytes());
				outputStream.flush();
				outputStream.close();
			}
		}
	}
```

E a classe `SemParametro`:
```
	public static class SemParametro implements HttpHandler{
		private List<Questionario> questionarios;
		private String response;
		
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			if("POST".equals(exchange.getRequestMethod())) {
				StringBuilder requestBody = new StringBuilder();
				try(BufferedReader br = new BufferedReader(new InputStreamReader(
						exchange.getRequestBody(), StandardCharsets.UTF_8))){
					String linha = null;
					while((linha = br.readLine()) != null) {
						requestBody.append(linha);
					}
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
				Questionario questionario = 
						QuestionarioDaoFileSystem.converterJsonEmQuestionario(requestBody.toString());
				
				questionarios = DAO.findAll();
				
				int ultimoId = getUltimoId(questionarios);
				
				questionario.setId(++ultimoId);
				
				DAO.insert(questionario);
				
				response = "Questionario com id %d criado com sucesso!".formatted(questionario.getId());
				exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
				exchange.sendResponseHeaders(201, response.getBytes().length);
		        OutputStream outputStream = exchange.getResponseBody();
		        outputStream.write(response.getBytes());
		        outputStream.flush();
		        outputStream.close();
		        
			} else {
				questionarios = DAO.findAll();
				response = parseResponse(questionarios);
				exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
				exchange.sendResponseHeaders(200, response.getBytes().length);
		        OutputStream outputStream = exchange.getResponseBody();
		        outputStream.write(response.getBytes());
		        outputStream.flush();
		        outputStream.close();
			}
		}

		private Integer getUltimoId(List<Questionario> questionarios) {
			return questionarios.stream()
				.mapToInt(Questionario::getId)
				.max()
				.orElse(0);
		}
		
		private String parseResponse(List<Questionario> questionarios) {
			StringBuilder sb = new StringBuilder();
			for(Questionario ques : questionarios) {
				sb.append(QuestionarioDaoFileSystem.converterQuestionarioEmJson(ques));
			}
			return sb.toString();
		}
	}
```
Fiz os testes das requisições no Postman:


https://github.com/alonso-estevam/caprichapp/assets/86576674/7afe1453-a5fa-4830-a066-2808596b4b77

<h3>Aprendizados</h3>
Esse exercício me fez pesquisar bastante para encontrar um meio de fazer um servidor Java sem framework, e minha recompensa foi descobrir a existência dos pacotes `java.net` e `com.sun.net.httpserver`, sobre os quais nunca tinha ouvido falar nos cursos comuns sobre Java. Igualmente, tive que estudar mais sobre o funcionamento de servidores web, o que me fez assistir pela trigésima vez o super vídeo do Fabio Akita sobre sockets, servidor, client e web, disponível <a href="https://www.youtube.com/watch?v=lc6U93P4Sxw&pp=ygUUZmFiaW8gYWtpdGEgc2Vydmlkb3I%3D)">aqui</a> - e finalmente entendi um pouco do que diabos ele estava falando. 

(Re)aprendi que um servidor é simplesmente um programa que "pede um bind de uma porta para o sistema operacional e fica em modo listen, de escuta, esperando para dar accept e abrir uma conexão com outro computador" (Akita, 2022). Aprendi que processos são instância de um programa em execução, e para enviar ou receber dados de um processo, precisamos saber em qual porta esse processo está rodando. Quando dois processos precisam se comunicar no mesmo computador, eles podem usar arquivos ou pipes, mas quando se trata de comunicação entre computadores diferentes, será preciso saber o número do endereço IP e da porta na qual o processo está rodando - por isso que pra fazer um servidor precisamos dessas duas informações, endereço IP (o famoso localhost, quando estamos trabalhando só na máquina local) e porta (que são só números escolhidos por convenção, como 3000 no Node ou 8080 no Apache Tomcat). Aprendi que até o número 1024 tem algumas portas pré-estabelecidas, como a 80 para o HTTP e 443 para o HTTPS (e que, por serem padrão, não precisamos digitar no navegador, por exemplo). Relembrei pontos importantes sobre o protocolo HTTP, e acabei me aprofundando um pouco mais sobre entrada e saída de dados no java, quando tive que resolver um problema com o charset do texto. 

Falando agora mais especificamente sobre este item, o problema se deu porque, num primeiro momento, eu tinha usado o InputStream para receber os dados do corpo da requisição:
```
InputStream inputStream = exchange.getRequestBody();
StringBuilder requestBody = new StringBuilder();
int b;
while((b = inputStream.read()) != -1) {
	requestBody.append((char) b);
}
```
Na verdade eu não entendi muito bem como esse código funcionou, porque depois descobri que a classe `InputStream` é abstrata (ou seja, não pode ser instanciada), assim como o método `getRequestBody()` é um método abstrato, sem implementação (mas que retorna um InputStream). Mas enfim, nesse código, o método `getRequestBody()` da classe `HttpExchange` retorna um stream (a documentação só diz que é um stream), que é lido com o método `read()` e atribuído a um inteiro b, e enquanto esse `int` representando o byte lido for diferente de -1, vamos convertendo-no em `char` e anexando ao `StringBuilder` que chamei de requestBody. 

Porém, isso fazia com que o texto dos arquivos ficasse com os caracteres de acentuação, til, etc. meio bugados, assim:
`VocÃª tem fÃ©?`

Então me lembrei que alguns caracteres não são representados apenas por um byte e, por isso, converter direto o byte de int pra char pode dar problema. Para resolver esse tipo de situação, quando se trata de leitura e escrita de fluxo de dados, o Java nos fornece classes específicas para lidar com bytes e classes específicas para lidar com caracteres.

Assim, devemos usar `FileInputStream` na leitura e `FileOutputStream` na escrita de arquivos orientados a bytes, por exemplo, e usar `FileReader` e `FileWriter`, respectivamente, na leitura e escrita de arquivos orientados a caracteres.

No contexto da nossa API, não estamos lidando com arquivos nesse trecho em especial, mas sim com um fluxo de dados transferidos via rede. No entanto, de modo análogo aos arquivos, temos a classe `InputStreamReader` e `OutputStreamWriter` que, conforme a documentação, fazem a "ponte" entre byte streams e character streams (e vice-versa).

Como nosso interesse é ler os dados do corpo da requisição, temos que usar um `InputStreamReader`. Essa classe vai ler os bytes da fonte de entrada (o corpo da requisição) e vai decodificar em caracteres usando Charset especificado, como o famoso UTF-8 ou o UTF-16. Podemos informar um Charset no construtor do `InputStreamReader` como String ou como Charset. Se não informarmos nada, será usado o Charset padrão, que "é determinado durante a inicialização da máquina virtual e normalmente depende da localidade e do conjunto de caracteres do sistema operacional subjacente." (<a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/charset/Charset.html#defaultCharset()">Java Docs</a>)

Voltando ao nosso código, já pensando em otimizar essa leitura, instanciei um `BufferedReader`, seguindo o exemplo da própria documentação que orienta a colocar um `InputStreamReader` dentro de um `BufferedReader`, assim: (<a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/charset/Charset.html#defaultCharset()">Java Docs</a>)():
```
BufferedReader in
   = new BufferedReader(new InputStreamReader(anInputStream));
```
O `BufferedReader` também tem o método `read()`, que lê um único caractere por vez e retorna o char ou -1 ao terminar de ler. Mas tem outro método mais otimizado: o `readLine()`, que lê uma linha de texto e retorna a String lida e `null` quando atinge o fim do stream. Desse modo, o código alterado ficou assim (e só pra garantir, coloquei o charset UTF-8):
```
StringBuilder requestBody = new StringBuilder();
try(BufferedReader br = new BufferedReader(new InputStreamReader (exchange.getRequestBody(), StandardCharsets.UTF_8))){
String linha = null;
	while((linha = br.readLine()) != null) {
		requestBody.append(linha);
	}
} catch(IOException e) {
	throw new RuntimeException(e);
}
```
E ao fazer a requisição POST com caracteres especiais da nossa língua portuguesa, tudo funcionou perfeitamente. 

Esse foi um resumo de tudo que tive de pesquisar e estudar para fazer esse exercício. Ainda há muito o que melhorar, principalmente em relação a tratamento de exceções (nesse momento, apenas o "caminho feliz" funciona). Mas acho que por ora é suficiente.

</details>
