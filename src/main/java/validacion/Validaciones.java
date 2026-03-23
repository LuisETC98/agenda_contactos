package validacion;

import dominio.Contacto;

public class Validaciones {
    public static boolean emailValidacion(String email) {
            // Retorna true solo si el email no es nulo Y no está en blanco Y posee un arroba
            return email != null && !email.isBlank() && email.contains("@");
        }
    }
