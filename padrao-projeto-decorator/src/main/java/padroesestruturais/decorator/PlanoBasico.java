package padroesestruturais.decorator;

public class PlanoBasico implements Plano {

    private double precoMensal;

    public PlanoBasico() {
        this.precoMensal = 79.90; // preço base padrão
    }

    public PlanoBasico(double precoMensal) {
        this.precoMensal = precoMensal;
    }

    @Override
    public double getPrecoMensal() {
        return precoMensal;
    }

    @Override
    public String getDescricao() {
        return "Plano Básico de Internet (100 Mbps)";
    }
}
