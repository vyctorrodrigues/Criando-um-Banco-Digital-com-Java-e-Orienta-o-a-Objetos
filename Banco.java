
import java.util.ArrayList;
import java.util.List;

public class Banco extends Conta {
    //atributo
    
    
    private List<Cliente> clienteList;

    

    public Banco() {
        super(cliente);
        this.clienteList = new ArrayList<>();
    }

    public void adicionarCliente(String nome) {
        Cliente cliente = new Cliente(nome);

        this.clienteList.add(cliente);
    }

    public void removerCliente(String nome){
        List<Cliente> clientesParaRemover = new ArrayList<>();

        if (!clientesParaRemover.isEmpty()) {
            for (Cliente c : clienteList) {
                if (c.getNome().equalsIgnoreCase(nome)) {
                    clientesParaRemover.add(c);
                }
            }
            clienteList.removeAll(clientesParaRemover);
        } else {
            System.out.println("Lista vazia");
        }
        
    }

    public void exibirCliente(){
        if (!clienteList.isEmpty()) {
            System.out.println(clienteList);
        } else {
            System.out.println("Lista vazia");
        }
    }

    public static void main(String[] args) {
        Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);
        Banco banco = new Banco();


      banco.adicionarCliente("vyctor");
      banco.exibirCliente();
      cc.depositar(100);
      cc.transferir(100, poupanca);
      poupanca.imprimirExtrato();
      banco.exibirCliente();
      poupanca.sacar(100);
    }

    @Override
    public void imprimirExtrato() {
        
    }

    @Override
    protected String getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }
}