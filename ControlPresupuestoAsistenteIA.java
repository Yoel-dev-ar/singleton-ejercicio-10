public class ControlPresupuestoAsistenteIA {
    private static ControlPresupuestoAsistenteIA instancia;
    private int creditosDisponibles;

    private ControlPresupuestoAsistenteIA() {
        this.creditosDisponibles = 1000;
    }

    public static ControlPresupuestoAsistenteIA getInstancia() {
        if (instancia == null) {
            instancia = new ControlPresupuestoAsistenteIA();
        }
        return instancia;
    }

    public boolean consumirCreditos(String canal, int cantidad) {
        if (creditosDisponibles >= cantidad) {
            creditosDisponibles -= cantidad;
            System.out.println("[IA-" + canal + "] Respuesta generada (-" + cantidad + " créditos). Quedan: " + creditosDisponibles);
            return true;
        } else {
            System.out.println("[ALERTA IA] Presupuesto agotado. No se puede responder en " + canal);
            return false;
        }
    }
}