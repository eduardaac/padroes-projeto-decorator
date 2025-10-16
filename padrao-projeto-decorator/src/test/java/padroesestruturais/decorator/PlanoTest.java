package padroesestruturais.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals; // Adicionado import estático

class PlanoTest {

    // PREÇOS:
    // PlanoBasico = 79.90
    // InternetIlimitada = +49.90
    // NetflixInclusa = +39.90
    // SpotifyPremium = +21.90

    // Testes de Preço

    @Test
    void deveRetornarPrecoPlanoBasico() {
        Plano plano = new PlanoBasico(); // Preço padrão 79.90
        assertEquals(79.90, plano.getPrecoMensal(), 0.01);
    }

    @Test
    void deveRetornarPrecoComSpotifyPremium() {
        // 79.90 (Basico) + 21.90 (Spotify) = 101.80
        Plano plano = new SpotifyPremium(new PlanoBasico());
        assertEquals(101.80, plano.getPrecoMensal(), 0.01);
    }

    @Test
    void deveRetornarPrecoComNetflixInclusa() {
        // 79.90 (Basico) + 39.90 (Netflix) = 119.80
        Plano plano = new NetflixInclusa(new PlanoBasico());
        assertEquals(119.80, plano.getPrecoMensal(), 0.01);
    }

    @Test
    void deveRetornarPrecoComInternetIlimitada() {
        // 79.90 (Basico) + 49.90 (Ilimitada) = 129.80
        Plano plano = new InternetIlimitada(new PlanoBasico());
        assertEquals(129.80, plano.getPrecoMensal(), 0.01);
    }

    @Test
    void deveRetornarPrecoComSpotifyMaisNetflix() {
        // 79.90 + 39.90 + 21.90 = 141.70
        Plano plano = new SpotifyPremium(new NetflixInclusa(new PlanoBasico()));
        assertEquals(141.70, plano.getPrecoMensal(), 0.01);
    }

    @Test
    void deveRetornarPrecoComTodosAdicionais() {
        // 79.90 + 49.90 + 39.90 + 21.90 = 191.60
        Plano plano = new SpotifyPremium(new NetflixInclusa(new InternetIlimitada(new PlanoBasico())));
        assertEquals(191.60, plano.getPrecoMensal(), 0.01);
    }

    // Testes de Descrição

    @Test
    void deveRetornarDescricaoPlanoBasico() {
        Plano plano = new PlanoBasico();
        assertEquals("Plano Básico de Internet (100 Mbps)", plano.getDescricao());
    }

    @Test
    void deveRetornarDescricaoComSpotifyPremium() {
        Plano plano = new SpotifyPremium(new PlanoBasico());
        assertEquals("Plano Básico de Internet (100 Mbps) + Spotify Premium", plano.getDescricao());
    }

    @Test
    void deveRetornarDescricaoComNetflixInclusaMaisInternetIlimitada() {
        Plano plano = new NetflixInclusa(new InternetIlimitada(new PlanoBasico()));
        assertEquals("Plano Básico de Internet (100 Mbps) + Internet Ilimitada + Netflix Inclusa", plano.getDescricao());
    }

    @Test
    void deveRetornarDescricaoComTodosAdicionais() {
        Plano plano = new SpotifyPremium(new NetflixInclusa(new InternetIlimitada(new PlanoBasico())));
        assertEquals("Plano Básico de Internet (100 Mbps) + Internet Ilimitada + Netflix Inclusa + Spotify Premium", plano.getDescricao());
    }
}