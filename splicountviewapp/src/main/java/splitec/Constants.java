package splitec;

public interface Constants {
    //Endpoints
    String AUTH = "http://localhost:8080/user/auth";
    String USER_UPSERT = "http://localhost:8080/user/upsert";
    String DEP_UPSERT = "http://localhost:8080/departamento/upsert";
    String EMP_UPSERT = "http://localhost:8080/empresa/upsert";

    //Campos do json de chamada
    String EMAIL = "email";
    String SENHA = "senha";
    String NOME = "nome";
    String EMPRESA = "empresa";
    String EMPRESA_ID = "empresaId";
    String ORCAMENTO = "orcamento";
    String DEPARTAMENTO = "departamento";

    //Mensagens
    String REQUEST_ERROR = "Erro ao realizar chamada. Código: ";
}
