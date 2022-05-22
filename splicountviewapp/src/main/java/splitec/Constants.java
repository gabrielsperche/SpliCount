package splitec;

public interface Constants {
    //Endpoints
    String AUTH = "http://localhost:8080/user/auth";
    String UPSERT = "http://localhost:8080/user/upsert";

    //Campos do json de chamada
    String EMAIL = "email";
    String SENHA = "senha";
    String NOME = "nome";

    //Mensagens
    String REQUEST_ERROR = "Erro ao realizar chamada. Código: ";
}
