package entities;

public class MessageResponse {

    private String mensagem;
    private boolean sucess;

    public MessageResponse(String mensagem, boolean sucess) {
        this.mensagem = mensagem;
        this.sucess = sucess;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }
}
