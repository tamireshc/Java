## Sistema de caixa eletrônico :moneybag:
>Aplicaçao de Console que implementa um sistema de caixa eletrônico  <br>
>É possível realizar as seguintes operações: Mostras extrato, sacar, depositar, transferir e sair do sistema.<br>
>A aplicação foi testada utilizando testes unitário por meio do JUnit5.<br>

❗ As tecnologias utilizadas foram: Java e JUnit5.

:arrow_forward: Exemplo de fluxo da aplicação:

```

Bem-vindo ao Banco da Trybe


Entre com seu CPF: 433.892.200-11
Entre com sua senha: 1234


Resumo das Contas da pessoa Camaragibe Oliveira:

1) 1376245820 : R$0.00 : Poupança

2) 1400842111 : R$0.00 : Corrente


O que você gostaria de fazer?
  1) Mostrar Extrato
  2) Sacar
  3) Depositar
  4) Transferir
  5) Sair

Entre com sua opção: 3
Entre com o número (1-2) para selecionar a conta para depósito: 1
Entre com a quantia de depósito: R$ 2000


Resumo das Contas da pessoa Camaragibe Oliveira:

1) 1376245820 : R$2000.00 : Poupança

2) 1400842111 : R$0.00 : Corrente


O que você gostaria de fazer?
  1) Mostrar Extrato
  2) Sacar
  3) Depositar
  4) Transferir
  5) Sair

Entre com sua opção: 3
Entre com o número (1-2) para selecionar a conta para depósito: 2
Entre com a quantia de depósito: R$ 4000


Resumo das Contas da pessoa Camaragibe Oliveira:

1) 1376245820 : R$2000.00 : Poupança

2) 1400842111 : R$4000.00 : Corrente


O que você gostaria de fazer?
  1) Mostrar Extrato
  2) Sacar
  3) Depositar
  4) Transferir
  5) Sair

Entre com sua opção: 4
Entre o número (1-2) para retirar o valor para transferência: 2
Entre o número (1-2) para selecionar a conta que receberá a transferência: 1
Entre com a quantia para ser transferida (máximo R$4000.00): R$ 2000


Resumo das Contas da pessoa Camaragibe Oliveira:

1) 1376245820 : R$4000.00 : Poupança

2) 1400842111 : R$2000.00 : Corrente


O que você gostaria de fazer?
  1) Mostrar Extrato
  2) Sacar
  3) Depositar
  4) Transferir
  5) Sair

Entre com sua opção: 1
Entre com o número (1-2) para a conta
que o extrato será impresso: 1

Extrato da conta 1376245820

21/01/2022 14:21:52 -------- Transferência recebida: R$ 2000.00 +
21/01/2022 14:21:32 -------- Depósito recebido: R$ 2000.00 +



Resumo das Contas da pessoa Camaragibe Oliveira:

1) 1376245820 : R$4000.00 : Poupança

2) 1400842111 : R$2000.00 : Corrente


O que você gostaria de fazer?
  1) Mostrar Extrato
  2) Sacar
  3) Depositar
  4) Transferir
  5) Sair

Entre com sua opção: 
```
