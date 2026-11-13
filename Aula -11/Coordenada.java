
public record Coordenada(double latitude, double longitude) {

    public Coordenada {

        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude invalida!");
        }

        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude invalida!");
        }

    }

}

public record Endereco(String rua, int numero, String cidade) {

    public Endereco {

        if (rua == null || rua.isBlank()) {
            throw new IllegalArgumentException("Rua invalida!");
        }

        if (numero < 0) {
            throw new IllegalArgumentException("Numero invalido!");
        }

        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("Cidade invalida!");
        }

    }

}
