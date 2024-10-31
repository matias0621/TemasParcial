package Clases.BonusTrack.Excepciones;

public class TamañoMaximo extends Exception {
    private String mensaje;

    public TamañoMaximo(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage(){
        return getMensaje();
    }
}
