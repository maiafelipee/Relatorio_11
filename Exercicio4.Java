import java.util.Scanner;
import java.util.ArrayList;

abstract class Monstro {
    private String nome;

    public Monstro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract String receita();
}

class Slime extends Monstro {

    public Slime(String nome) {
        super(nome);
    }

    @Override
    public String receita() {
        return "Fritar o slime ate ficar crocante.";
    }
}

class Mandragora extends Monstro {

    public Mandragora(String nome) {
        super(nome);
    }

    @Override
    public String receita() {
        return "Cozinhar a mandragora com temperos.";
    }
}

class Panela {
    private String material;

    public Panela(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}

class Cozinheiro {
    private String nome;
    private Panela panela;
    private ArrayList<Monstro> ingredientes;

    public Cozinheiro(String nome, String materialDaPanela) {
        this.nome = nome;
        panela = new Panela(materialDaPanela);
        ingredientes = new ArrayList<>();
    }

    public void adicionarIngrediente(Monstro monstro) {
        ingredientes.add(monstro);
    }

    public void servirBanquete() {
        System.out.println("\n--- BANQUETE ---");

        System.out.println("Cozinheiro: " + nome);
        System.out.println("Material da panela: " + panela.getMaterial());

        for (Monstro monstro : ingredientes) {
            System.out.println("\nMonstro: " + monstro.getNome());
            System.out.println("Receita: " + monstro.receita());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do Slime:");
        String nomeSlime = entrada.nextLine();

        Slime slime = new Slime(nomeSlime);

        System.out.println("Digite o nome da Mandragora:");
        String nomeMandragora = entrada.nextLine();

        Mandragora mandragora = new Mandragora(nomeMandragora);

        System.out.println("Digite o nome do cozinheiro:");
        String nomeCozinheiro = entrada.nextLine();

        System.out.println("Digite o material da panela:");
        String material = entrada.nextLine();

        Cozinheiro cozinheiro = new Cozinheiro(nomeCozinheiro, material);

        cozinheiro.adicionarIngrediente(slime);

        cozinheiro.adicionarIngrediente(mandragora);

        cozinheiro.servirBanquete();

        // composicao: a panela e criada dentro do construtor do cozinheiro.

        // agregacao:
        // os monstros sao criados antes do cozinheiro e depois sao adicionados a lista de ingredientes.

        entrada.close();
    }
}
