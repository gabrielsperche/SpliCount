package entities;

public class Conta {
    private static String idEmpresa;

    public Conta(String idEmpresa) {
        Conta.idEmpresa = idEmpresa;
    }

    public Conta() {

    }

    public static String getIdEmpresa() {
        return idEmpresa;
    }

    public static void setIdEmpresa(String idEmpresa) {
        Conta.idEmpresa = idEmpresa;
    }
}
