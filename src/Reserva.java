public class Reserva {
    private Usuario usuario;
    private String destino;
    private String fecha;
    private String hora;

    public Reserva(Usuario usuario, String destino, String fecha, String hora) {
        this.usuario = usuario;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDestino() {
        return destino;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void mostrarReserva() {
        System.out.println("Reserva:");
        System.out.println("Usuario: " + usuario.getCorreo());
        System.out.println("Destino: " + destino);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
    }
}
