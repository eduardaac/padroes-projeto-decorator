package padroesestruturais.decorator;

public abstract class PlanoDecorator implements Plano {

    private Plano plano;
    public String beneficios;

    public PlanoDecorator(Plano plano) {
        this.plano = plano;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    // Cada decorador define quanto o preço vai aumentar
    public abstract double getAumentoPreco();

    @Override
    public double getPrecoMensal() {
        return this.plano.getPrecoMensal() + this.getAumentoPreco();
    }

    // Cada decorador define o benefício que será adicionado
    public abstract String getNomeBeneficio();

    @Override
    public String getDescricao() {
        return this.plano.getDescricao() + " + " + this.getNomeBeneficio();
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
}
