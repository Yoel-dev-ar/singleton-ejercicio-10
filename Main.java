public class Main {
    public static void main(String[] args) {
        ControlPresupuestoAsistenteIA chatWeb = ControlPresupuestoAsistenteIA.getInstancia();
        ControlPresupuestoAsistenteIA chatWhatsApp = ControlPresupuestoAsistenteIA.getInstancia();

        chatWeb.consumirCreditos("WEB", 400);
        chatWhatsApp.consumirCreditos("WHATSAPP", 450);

        // Intenta consumir 300 cuando solo quedan 150 -> debe bloquearse
        chatWeb.consumirCreditos("WEB", 300);

        System.out.println("¿Mismo controlador de presupuesto?: " + (chatWeb == chatWhatsApp));
    }
}