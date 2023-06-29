# Simulador de pix - tratamento de erros  :dollar: :x:
>Projeto que simula um sitema de pix que se conecta a um servidor em nuvem.<br>
>O projeto trata os possíveis erros de validação, indisponibilidade de recursos ou usuário, conexão e erros internos com classes personalizada de erro.<br>

As exceções personalizada utilizada são:

- Erros de aplicação validados localmente
    - Valor a ser transferido menor ou igual a zero
    - Chave Pix em branco

- Erros de aplicação validados pelo servidor
    - Saldo insuficiente
    - Chave Pix não encontrada
    - Erro interno (por exemplo, falha no servidor)

- Erros de comunicação (por exemplo, timeout de conexão)
