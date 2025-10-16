package padroesestruturais.decorator;

public class NetflixInclusa extends PlanoDecorator {

    public NetflixInclusa(Plano plano) {
        super(plano);
    }

    @Override
    public double getAumentoPreco() {
        return 39.90;
    }

    @Override
    public String getNomeBeneficio() {
        return "Netflix Inclusa";
    }
}