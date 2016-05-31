package fiuba.algo3.model.espacio;

public class Punto {

    private int x;
    private int y;
    private int nivel;


    public Punto(int x, int y, int nivel) {
        this.x = x;
        this.y = y;
        this.nivel = nivel;
    }


    public int distanciaAl(Punto other) {
        return Math.max(Math.abs(this.x - other.x), Math.abs(this.y - other.y));    // Distancia de Chebyshov
    }


    public Punto obtenerPuntoEn(Direccion direccion) {
        return new Punto(this.x + direccion.x, this.y + direccion.y, this.nivel);
    }


    public Punto ascender() {
        return new Punto(x, y, nivel + 1);
    }


    public Punto descender() {
        return new Punto(x, y, nivel - 1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Punto punto = (Punto) o;

        if (x != punto.x) return false;
        if (y != punto.y) return false;
        return nivel == punto.nivel;

    }


    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + nivel;
        return result;
    }

}
