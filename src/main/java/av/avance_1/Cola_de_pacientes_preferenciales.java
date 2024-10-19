package av.avance_1;

public class Cola_de_pacientes_preferenciales extends Cola {

    private void fichas(NodoC x) {
        if (x != null) {
            Paciente paciente = x.getDatos();

            fichas(x.getAtras());

        }
    }
}
