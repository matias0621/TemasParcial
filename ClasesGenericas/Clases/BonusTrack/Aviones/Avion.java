package Clases.BonusTrack.Aviones;

public class Avion {
    protected String nombreDeModelo;
    protected String marca;
    protected Double capacidadDeCombustible;
    protected String tipoDeMotor;
    protected int cantidadDeAsientos;

    public Avion(String nombreDeModelo, String marca, Double capacidadDeCombustible, String tipoDeMotor, int cantidadDeAsientos) {
        this.nombreDeModelo = nombreDeModelo;
        this.marca = marca;
        this.capacidadDeCombustible = capacidadDeCombustible;
        this.tipoDeMotor = tipoDeMotor;
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public String getNombreDeModelo() {
        return nombreDeModelo;
    }

    public void setNombreDeModelo(String nombreDeModelo) {
        this.nombreDeModelo = nombreDeModelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCapacidadDeCombustible() {
        return capacidadDeCombustible;
    }

    public void setCapacidadDeCombustible(Double capacidadDeCombustible) {
        this.capacidadDeCombustible = capacidadDeCombustible;
    }

    public String getTipoDeMotor() {
        return tipoDeMotor;
    }

    public void setTipoDeMotor(String tipoDeMotor) {
        this.tipoDeMotor = tipoDeMotor;
    }

    public int getCantidadDeAsientos() {
        return cantidadDeAsientos;
    }

    public void setCantidadDeAsientos(int cantidadDeAsientos) {
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public void despegar(){
        System.out.println("El avion " + nombreDeModelo + " esta despegando");
    }

    public void aterrizar(){
        System.out.println("El avion " + nombreDeModelo + " esta aterrizando");
    }

    public void volar(){
        System.out.println("El avion " + nombreDeModelo + " esta volando");
    }
}
