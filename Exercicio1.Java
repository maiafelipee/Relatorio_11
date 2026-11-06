import java.util.Scanner;

abstract class Morador {
    private String nome;

    public Morador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void apresentar();
}

class Mago extends Morador {
    private String feitico;

    public Mago(String nome, String feitico) {
        super(nome);
        this.feitico = feitico;
    }

    @Override
    public void apresentar() {
        System.out.println("Mago: " + getNome());
        System.out.println("Feitico: " + feitico);
    }
}

class DemonioDoFogo extends Morador {

    public DemonioDoFogo(String nome) {
        super(nome);
    }

    @Override
    public void apresentar() {
        System.out.println("Demonio do fogo: " + getNome());
        System.out.println("Ele faz o castelo andar!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do mago:");
        String nomeMago = entrada.nextLine();

        System.out.println("Digite o feitico do mago:");
        String feitico = entrada.nextLine();

        System.out.println("Digite o nome do demonio do fogo:");
        String nomeDemonio = entrada.nextLine();

        Morador mago = new Mago(nomeMago, feitico);
        Morador demonio = new DemonioDoFogo(nomeDemonio);

        System.out.println("\n--- MORADORES DO CASTELO ---");

        mago.apresentar();

        System.out.println();

        demonio.apresentar();

        // Morador morador = new Morador("Teste");

        entrada.close();
    }
}
