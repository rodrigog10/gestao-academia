package com.academia.gestao.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandartError {
    private Instant timestamp;//registra o momento exato do acionamento da exceção
    private Integer status;//o número do código http
    private String error;//descrição curta do tipo do erro
    private String message;//mensagem principal do erro
    private String path;//rota da requisição

}
