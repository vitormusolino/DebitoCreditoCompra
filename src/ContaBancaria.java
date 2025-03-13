public class ContaBancaria extends CartaoCredito{

    private double saldo;
    private String nome;

    public double getSaldo() {
        return saldo;
    }

    public ContaBancaria(String nome, int saldo, int limite){
        super(limite);
        this.saldo = saldo;
        this.nome = nome;
    }
}
