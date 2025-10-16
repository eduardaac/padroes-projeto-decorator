package padroesestruturais.decorator;

public class SpotifyPremium extends PlanoDecorator {

    public SpotifyPremium(Plano plano) {
        super(plano);
    }

    @Override
    public double getAumentoPreco() {
        return 21.90; // Custo do Spotify Premium
    }

    @Override
    public String getNomeBeneficio() {
        return "Spotify Premium"; // Descrição do benefício
    }

}