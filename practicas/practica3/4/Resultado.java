public class Resultado {
    private int min;
    private int max;
    private float prom;

    public Resultado(int min, int max, float prom) {
        this.min = min;
        this.max = max;
        this.prom = prom;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public float getProm() {
        return prom;
    }

    @Override
    public String toString() {
        return "Resultado{" + "min=" + min + ", max=" + max + ", prom=" + prom + '}';
    }
}
