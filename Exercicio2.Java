import java.util.Scanner;
import java.util.ArrayList;

class ItemDoCardapio {
    private String nome;
    private double preco;

    public ItemDoCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double precoFinal() {
        return preco;
    }
}

class ComboLeblanc extends ItemDoCardapio {

    public ComboLeblanc(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double precoFinal() {
        return getPreco() * 0.9;
    }
}

class CafeLeblanc {
    private ArrayList<ItemDoCardapio> cardapio;

    public CafeLeblanc() {
        cardapio = new ArrayList<>();
    }

    public void adicionar(ItemDoCardapio item) {
        cardapio.add(item);
    }

    public void mostrarCardapio() {
        for (ItemDoCardapio item : cardapio) {
            System.out.println("Nome: " + item.getNome());
            System.out.printf("Preco: R$ %.2f%n", item.precoFinal());
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        CafeLeblanc cafe = new CafeLeblanc();

        for (int i = 1; i <= 2; i++) {
            System.out.println("Digite o nome do item " + i + ":");
            String nome = entrada.nextLine();

            System.out.println("Digite o preco do item:");
            double preco = entrada.nextDouble();
            entrada.nextLine();

            ItemDoCardapio item = new ItemDoCardapio(nome, preco);

            cafe.adicionar(item);
        }

        System.out.println("Digite o nome do combo:");
        String nomeCombo = entrada.nextLine();

        System.out.println("Digite o preco do combo:");
        double precoCombo = entrada.nextDouble();

        ComboLeblanc combo = new ComboLeblanc(nomeCombo, precoCombo);

        cafe.adicionar(combo);

        System.out.println("\n--- CARDAPIO DO CAFE LEBLANC ---");

        cafe.mostrarCardapio();

        entrada.close();
    }
}
