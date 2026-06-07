package br.com.curso.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Tax Number invalido", "ON-0001"),
    ON0002("Tax Number indisponivel", "ON-0002"),

    ON0003("Email indisponivel", "ON-0003"),

    ON0004("Houve um erro na criação do usuario", "ON-0004"),

    TR0001("Usuario lojista não tem a função transferencia disponivel", "TR-0001"),
    TR0002("Saldo indisponivel", "TR0002"),
    TR0003("Houve um erro ao realizar a transferencia", "TR-0003"),
    TR0004("Transferencia não autorizada", "TR-0004"),


    TRP0001("Pin invalido", "TRP-0001"),

    WA0001("Carteira não encontrada", "WA-0001"),

    NO0001("Houve um erro na notificação do usuario",  "NO-0001"),

    AUT0001("Usuario não autorizado", "AUT-0001"),

    PIN0001("Pin de transação bloqueado", "PIN-0001"),
    PIN0002("Pin incorreto, %d tentativa(s) restantes", "PIN-0002"),

    ;
    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {

        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static String pin0002GetMessage(Integer attempt) {

        return String.format(PIN0002.message, attempt);

    }
}
