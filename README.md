# Gerenciador de Elevador

O sistema inclue o elevador em si, que possui sua fila de 
chamadas de cada andar, e uma lista de requisições para 
subida e descida. Para cada andar, um painel é criado onde 
ficam os botões de chamada de subida e descida, também é
criado um painel com os botões de dentro da "gaiola" do
elevador. Todas as requisições são feitas por uma 
fachada, feita para simplificar a interação com o elevador.

## Os padrões utilizados foram:

### Singleton

Para a atividade foi mencionado que seria criado apenas 1
elevador, logo, utilizamos o padrão singleton para sua 
criação. Como a fachada é utilizada apenas para gerenciar
o elevador, o qual só existe 1, nela também foi aplicada o
padrão singleton.

### State

O padrão state foi utilizado para representar os 3 diferentes
estados que o elevador pode assumir: Subindo, Descendo e Parado.
Eles gerenciam o movimento do elevador e alternam entre si
conforme a necessidade, mais detalhadas no pdf do professor.

### Facade

Para facilitar o uso do elevador foi criado uma fachada,
onde ocorre a instanciação tanto do elevador em si, como
de todos os painéis necessários para interagir com ele, 
poupando o usuário de ter que entender as regras de negócio
do elevador para poder utilizá-lo.
