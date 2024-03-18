import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Usuarios {

    static boolean validarUsuario(String usuario, String password) {
        boolean bnd = false;
        try {
            String usuarios = new String(Files.readAllBytes(Paths.get("usuarios.txt")));
            String[] usuarioclave = usuarios.split(";");
            String[] us;

            for (int i = 0; i < usuarioclave.length; i++) {
                us = usuarioclave[i].split(",");
                if (us[0].equals(usuario) && us[1].equals(password)) {
                    bnd = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error en lectura");
        }
        return bnd;
    }
}

