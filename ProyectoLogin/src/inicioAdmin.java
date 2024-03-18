import java.time.LocalDate;
import java.time.LocalTime;

public class inicioAdmin {

    public static void main(String[] args) {
        // No necesitamos un main aquí
    }

    static void saludar(String usuario) {
        System.out.println("Hola Admin " + usuario);
        String ingreso = LocalDate.now() + "-" + LocalTime.now() + "-" + usuario;
        escribirTxt.escribir(ingreso);
    }
}