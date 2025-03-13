import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria("Vitor Musolino", 5000, 2000);

        Scanner leitura = new Scanner(System.in);
        double saldo = conta.getSaldo();
        int tipoCartao;
        int operacao = 1;

        System.out.println("Você quer realizar uma compra no crédito ou no débito? CRÉDITO - 1; DÉBITO - 2");
        tipoCartao = leitura.nextInt();
        while(operacao != 0){
            if(tipoCartao == 1){
                List<Compra> listaCompras = new ArrayList<>();

                System.out.println("Você quer realizar uma compra? (1 para SIM,0 para NÃO)");
                operacao = leitura.nextInt();

                int limite = conta.getLimite();

                while(operacao != 0){
                    if (operacao == 1){
                        System.out.println("Qual é o produto que você quer comprar?");
                        String produto = leitura.next();

                        System.out.println("Qual o valor desse produto?");
                        int valor = leitura.nextInt();

                        if(valor > limite){
                            System.out.println("Valor acima do limite");
                            System.out.println("Deseja tentar comprar outro produto? 1 - SIM; 0 - NÃO");
                            operacao = leitura.nextInt();
                        }else{
                            System.out.println( produto + " comprado, você ainda tem R$" + (limite - valor) + " de limite.");
                            Compra compra = new Compra(valor, produto);
                            listaCompras.add(compra);
                            limite -= valor;

                            System.out.println("Quer realizar outra compra? COMPRAR MAIS = 1; SAIR = 0");
                            operacao = leitura.nextInt();
                        }
                    }else{
                        System.out.println("Número inválido");
                        break;
                    }
                }
                Collections.sort(listaCompras);
                System.out.println("Produtos comprados:");
                for(Compra compra : listaCompras){
                    System.out.println(compra);
                }
            }else if(tipoCartao == 2){
                ArrayList<Compra> listaDebito = new ArrayList<>();

                System.out.println("Escolha: Débito. Quer realizar uma compra? SIM - 1; NÃO - 0");
                operacao = leitura.nextInt();

                while(operacao != 0){
                    System.out.println("Diga o que quer comprar: ");
                    String produto = leitura.next();

                    System.out.println("Diga o preço: ");
                    int valor = leitura.nextInt();

                    if(valor > saldo){
                        System.out.println("Saldo insuficiente! Se quiser tentar novamente. TENTAR NOVAMENTE - 1; SAIR - 0 ");
                        operacao = leitura.nextInt();
                    }else{
                        saldo -= valor;
                        System.out.println("Compra de R$" + valor + " realizada, o seu saldo agora é de R$" + saldo);
                        Compra compraDebito = new Compra(valor, produto);
                        listaDebito.add(compraDebito);
                        System.out.println("Deseja comprar mais? SIM - 1; NÃO - 0");
                        operacao = leitura.nextInt();
                    }

                }
                Collections.sort(listaDebito);
                System.out.println("Produtos comprados:");
                for(Compra compra : listaDebito){
                    System.out.println(compra);
                }
            }else{
                System.out.println("Número inválido. Tente novamente");
                System.out.println("Você quer realizar uma compra no crédito ou no débito? CRÉDITO - 1; DÉBITO - 2");
                tipoCartao = leitura.nextInt();
                }
        }



    }
}