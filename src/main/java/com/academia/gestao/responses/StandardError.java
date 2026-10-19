package com.academia.gestao.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Instant timestamp; // registra o momento exato do acionamento da exceção
    private Integer status; // o número do código http
    private String error; // descrição curta do tipo do erro
    private String message; // mensagem principal do erro
    private String path; // rota da requisição

}
