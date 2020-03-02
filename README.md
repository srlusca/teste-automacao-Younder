teste-automacao-Younder

Foi utilizado:
IntelliJ IDEA, Java, Seleniumm, Cucumber, BDD, Gherkin, Page Objects, Page Factory, Maven, Allure Reports, Chrome, ChromeDriver.

Para gerar o relatório de testes, entre na raiz do projeto, utilize o terminal (GIT BASH ou PROMPT DE COMANDO) e digite o seguinte comando: mvn clean test
Logo após, este comando: mvn site
Entre na pasta "target/site/" e clique em "project-reports"
Ele abrirá uma pagina explorer, haverá uma coluna com o nome "Document", clique no nome "Allure" e você estará sendo direcionado a página de reports.


AGIL
6.	Em qual momento você realizaria a modelagem/construção de seus casos de teste?
    - A partir do momento em que a tela está desenvolvida
7.	Forneça um exemplo deste caso de teste contendo todas as informações que você julgar necessárias?
    - Perfilamento, regras de negócio.
8.	Como você realizaria a captura e execução de seus testes automatizados?
    - Print da tela durante a execução, ou gravando video.
9.	Em qual momento isto seria realizado?
    - Durante a execução
10.	Você automatizaria casos progressivos ou somente os regressivos pós-encerramento das sprints?
    - Progressivo e regressivo.

MOBILE
1.	Uma aplicação responsiva pode ser testada diretamente em um navegador web ou somente no dispositivo? Existe diferença? Qual o nível de confiabilidade?
    - Tanto na WEB, tanto no dispositivo.
    - Uma das diferenças é que o Chrome consegue emular qualquer tela de dispositivos incluse internet e processador que é usado em tais celulares
    - Nivel de confiabilidade alto
2.	Qual melhor forma e possíveis ferramentas para realizar um teste automatizado mobile?
    - Java e appium para Android (Não trabalhei com IOS)

PERFORMANCE
    1.	Qual a diferença entre testes de desempenho, carga e stress?
        - Desempenho: Qual rápido o sistema é
        - Carga: Quanto o seu sistema aguenta
        - Stress: Carrega muita carga de dados e faz inumeras vezes até entender o comportamento acima do limite do sistema
    2.	Quais pré-requisitos mais importantes para realização de um teste de performance?
        - Quando todos seus componentes são finalmente integrados
    3.	Em qual ambiente deve ser realizado este tipo de testes?
        - Pré-Produção
    4.	Quais fatores devem ser analisados após o teste?
        - Tempo, desempenho, limite do sistema, quantidade decarga utilizada.
