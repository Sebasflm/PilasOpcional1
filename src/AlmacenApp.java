
import java.util.Stack;

public class AlmacenApp {
    private Stack<Caja>[] pilas;

    public AlmacenApp() {
        int numPilas = 3;

        pilas = new Stack[numPilas];
        for (int i = 0; i < numPilas; i++) {
            pilas[i] = new Stack<>();
        }
    }

    public boolean ingresarCaja(Caja caja) {
        for (Stack<Caja> pila : pilas) {
            if (pila.size() < 6) {
                pila.push(caja);
                return true;
            }
        }
        return false;
    }


    public String buscarCaja(String codigo) {
        for (int i = 0; i < pilas.length; i++) {
            Stack<Caja> pila = pilas[i];
            int posicion = 1;

            for (Caja caja : pila) {
                if (caja.getCodigo().equals(codigo)) {
                    return "Caja encontrada en la Pila " + (i + 1) + " en la posición " + posicion + ".\n";
                }
                posicion++;
            }
        }

        return "Caja no encontrada.\n";
    }

    public boolean sacarCaja(String codigo) {
        Stack<Caja> pilaAuxiliar = new Stack<>();

        for (int i = 0; i < pilas.length; i++) {
            Stack<Caja> pila = pilas[i];

            while (!pila.isEmpty()) {
                Caja caja = pila.pop();

                if (!caja.getCodigo().equals(codigo)) {
                    pilaAuxiliar.push(caja);
                }
            }

            while (!pilaAuxiliar.isEmpty()) {
                pila.push(pilaAuxiliar.pop());
            }
        }

        return true; // La caja se sacó con éxito
    }

    public String imprimirPilas() {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < pilas.length; i++) {
            Stack<Caja> pila = pilas[i];
                sb.append("Pila Numero " + (i + 1)+"\n");
            for (Caja caja : pila) {
               sb.append(caja.getNombre() + "\n");
            }
        }
        return sb.toString();
    }

}
