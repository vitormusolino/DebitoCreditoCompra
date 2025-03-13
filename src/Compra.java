public class Compra implements Comparable<Compra>{

    private int valor;
    private String produto;

    public int getValor() {
        return valor;
    }

    public Compra(int valor, String produto){
        this.valor = valor;
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Produto:" + produto + " no valor de R$" + valor;
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Integer.compare(this.getValor(), outraCompra.valor) ;
    }
}
