package fiuba.algo3.model.arena;

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
