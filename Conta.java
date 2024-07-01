

public abstract class Conta implements IConta {
    //sequencial, gera numero automatico
    private static int AgenciaPadrao = 1;
    private static int SEQUENCIAL = 1;
    //atributos
    protected int agencia;
    protected int conta;
    protected double saldo;
    protected static Cliente cliente;
    
    


    public Conta(Cliente cliente) {
		this.agencia = Conta.AgenciaPadrao;
		this.saldo = SEQUENCIAL++;
		Conta.cliente = cliente;
	}



    @Override
    public void sacar(double valor) {
        if (saldo < valor) {
            this.saldo -= valor;
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= valor;
            System.out.println("saque feito com sucesso");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }


    public int getAgencia() {
        return agencia;
    }
 
    public int getConta() {
        return conta;
    }
 
    public double getSaldo() {
        return saldo;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns() {
     
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.conta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }



    protected abstract String getNome();
}
 

