package padroesestruturais.decorator;

public class InternetIlimitada extends PlanoDecorator {

    public InternetIlimitada(Plano plano) {
        super(plano);
    }

    @Override
    public double getAumentoPreco() {
        return 49.90; // Aumento de preço da Internet Ilimitada
    }

    @Override
    public String getNomeBeneficio() {
        return "Internet Ilimitada"; // Nome do benefício
    }
}