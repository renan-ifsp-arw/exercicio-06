package br.edu.ifsp.dw2.exercicio05.execptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ControllerAdvice
public class Exercicio05ExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = Optional.ofNullable(ex.getCause()).orElse(ex).toString();
        Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor);
        return super.handleExceptionInternal(ex, erro, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<Erro> erroList = criarListaDeErros(ex.getBindingResult()); 
        return handleExceptionInternal(ex, erroList, headers, status, request);
    }

    private List<Erro> criarListaDeErros(BindingResult bindingResult) {
        List<Erro> erros = new ArrayList<>();
        for(FieldError fieldError: bindingResult.getFieldErrors()){
            String mensagemUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            String mensagemDesenvolvedor = fieldError.toString();
            erros.add(new Erro(mensagemUsuario, mensagemDesenvolvedor));
        }
        return erros;
    }

    public static class Erro {
        private final String mensagemUsuario;
        private final String mensagemDesenvolvedor;

        public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
            this.mensagemUsuario = mensagemUsuario;
            this.mensagemDesenvolvedor = mensagemDesenvolvedor;
        }

        public String getMensagemDesenvolvedor() {
            return mensagemDesenvolvedor;
        }
        public String getMensagemUsuario() {
            return mensagemUsuario;
        }
    }
}
