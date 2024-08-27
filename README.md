# RMI Calculator with GUI

Este projeto implementa uma calculadora distribuída usando RMI (Remote Method Invocation) em Java. O projeto inclui um servidor que oferece operações de cálculo básicas e um cliente com interface gráfica que permite aos usuários interagir com o servidor.

## Funcionalidades

- **Servidor RMI:** 
  - Fornece operações básicas de adição, subtração, multiplicação e divisão.
  - Registra as operações recebidas, incluindo os parâmetros e os resultados, em um log.
  
- **Cliente RMI:**
  - Interface gráfica simples para que o usuário insira números e selecione operações.
  - Mostra o resultado da operação realizada pelo servidor.

## Estrutura do Projeto

- **Calculator.java:** Interface remota que define as operações disponíveis.
- **CalculatorImpl.java:** Implementação da interface `Calculator`, onde as operações são realizadas e registradas.
- **CalculatorServer.java:** Classe que inicia o servidor RMI e registra a implementação da calculadora no registro RMI.
- **CalculatorClientGUI.java:** Classe que implementa o cliente RMI com uma interface gráfica usando Swing.

## Pré-requisitos

- **Java Development Kit (JDK)** instalado e configurado no PATH do sistema.
- Conhecimento básico de conceitos de RMI e Swing.

## Como Executar

### 1. Compilar as Classes Java

No diretório raiz do projeto, compile todas as classes Java:

```bash
javac *.java
```
### 2. Iniciar o Registro RMI
Abra um terminal e execute o rmiregistry:

```bash
rmiregistry
```
Deixe esta janela aberta. Este comando inicia o registro RMI na porta padrão 1099.

### 3. Executar o Servidor
Em outro terminal, execute o servidor RMI:

````bash
java CalculatorServer
````

O servidor estará pronto para receber chamadas de procedimentos remotos (RPC).

### 4. Executar o Cliente com Interface Gráfica
Em um novo terminal, execute o cliente GUI:

````bash
java CalculatorClientGUI
````
A interface gráfica será aberta, permitindo que você insira números, selecione uma operação e veja o resultado.

### Exemplo de Uso
Abra a interface gráfica.
Insira dois números nos campos de texto.
Clique em um dos botões de operação: "Adicionar", "Subtrair", "Multiplicar" ou "Dividir".
O resultado da operação aparecerá na interface gráfica.
Logs do Servidor
O servidor registra todas as operações realizadas no console, mostrando a data, hora, tipo de operação, parâmetros e o resultado.

### Exemplo de log:

```bash
2024-08-27T10:15:30.123 - Operação: Add, Parâmetros: [10.0, 5.0], Resultado: 15.0
```
