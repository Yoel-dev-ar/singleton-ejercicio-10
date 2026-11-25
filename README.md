Ejercicio 10: Contenedor de Estado Global y Auditoría de Seguridad

Contexto del problema: En una aplicación de alta seguridad, todas las acciones críticas realizadas por operadores (como transferencias o modificaciones de privilegios) deben pasar por un auditor central de seguridad que registre la traza inmutable de auditoría con identificadores de sesión y marcas temporales.

Objetivo de aprendizaje: Diseñar un Singleton robusto de grado empresarial que combine seguridad contra alteraciones, consistencia de estado y trazabilidad estricta.

Requisitos funcionales:

Registrar eventos de auditoría asegurando que guarden un orden cronológico estricto e inalterable.

Permitir la validación de la cantidad total de registros almacenados y la consulta de la traza completa de eventos.

Restricciones técnicas:

La implementación del Singleton debe ser resistente a intentos de duplicación mediante mecanismos avanzados de protección de instancias.

La gestión interna del estado de auditoría debe ser totalmente segura ante entornos de ejecución multihilo avanzados.

# Ejercicio 10: Control de Presupuesto del Asistente IA (Patrón Singleton)

## Temática

Banca Digital y Tradicional — Administración centralizada de créditos de consumo para canales de atención con IA.

## Consigna

El banco dispone de un cupo compartido de 1000 créditos para que su asistente de inteligencia artificial responda consultas tanto desde la Web como desde WhatsApp. Si cada canal llevara su propia cuenta por separado, se podría exceder el presupuesto disponible del día.

El objetivo es aplicar el patrón Singleton para centralizar el saldo de créditos en un único controlador compartido, descontando cada consumo y bloqueando nuevas respuestas cuando el saldo disponible no alcance.

## Explicación lógica

1. Atributos: En la clase ControlPresupuestoAsistenteIA se declara creditosDisponibles (private int) para guardar el saldo restante del asistente, y instancia (private static ControlPresupuestoAsistenteIA), que va a conservar la única referencia en memoria para que todos los canales descuenten sobre el mismo presupuesto.


2. Instancia única: El constructor se define como private para impedir que otros módulos creen controladores independientes usando new, dejando creditosDisponibles en 1000 cuando se crea por primera vez. El método getInstancia() controla el acceso: revisa si instancia es null (es decir, si todavía no se creó), la instancia una sola vez y en las siguientes llamadas devuelve siempre ese mismo objeto ya existente.


3. Asignación y Acceso: En Main, se obtiene la instancia desde dos canales (chatWeb y chatWhatsApp) y se invoca consumirCreditos(...) para verificar si creditosDisponibles alcanza, restar la cantidad solicitada y devolver true, o emitir una alerta y devolver false si el saldo es insuficiente. Tras consumir 400 desde la web y 450 desde WhatsApp quedan 150 créditos, por lo que el intento posterior de consumir 300 queda bloqueado, y la comparación chatWeb == chatWhatsApp confirma que ambas variables apuntan exactamente al mismo objeto en memoria.



## Estructura del ejercicio

* ControlPresupuestoAsistenteIA.java: Implementa el Singleton con el saldo de créditos y el método consumirCreditos(...)
* Main.java: Simula consumos desde Web y WhatsApp, prueba el bloqueo por saldo insuficiente y verifica que comparten la misma instancia

