import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GerenciaEmail {
    Map<Integer, Email> cEmail = new HashMap<>();
    Map<String, Usuario> cUsuario = new HashMap<>();

    boolean adicionaContato(Usuario usuario) {
        if (cUsuario.containsKey(usuario.getEmail())) {
            return false;
        }

        cUsuario.put(usuario.getEmail(), usuario);
        return true;
    }

    public boolean adicionaEmail(Email e, String emailDe, String emailPara) {
        Usuario usuarioDe = cUsuario.get(emailDe);

        String[] emailsParaList = emailPara.split(";");

        for (String email : emailsParaList) {
            Usuario usuarioPara = cUsuario.get(email);
            if (usuarioPara != null) {
                e.getListaPara().add(usuarioPara);
            } else {
                System.out.println("Email não encontrado: " + email + ".\n");
            }
        }

        if (cEmail.containsKey(e.getId())) {
            return false;
        }

        if (usuarioDe == null || e.getListaPara().isEmpty()) {
            return false;
        }

        e.setDe(usuarioDe);

        cEmail.put(e.getId(), e);
        return true;
    }

    public ArrayList<Email> listaEmailPara(String emailPara) {
        ArrayList<Email> emailsComEmailPara = new ArrayList<Email>();
        for (var email : cEmail.values()) {
            if (email.existeEmail(emailPara)) {
                emailsComEmailPara.add(email);
            }
        }

        return emailsComEmailPara;
    }

    public ArrayList<Email> listaEmailNomePara(String nome) {
        ArrayList<Email> emailsComNome = new ArrayList<Email>();
        for (var email : cEmail.values()) {
            for (var usuario : email.getListaPara()) {
                if (usuario.getNome().equals(nome)) {
                    emailsComNome.add(email);
                    break;
                }
            }
        }

        return emailsComNome;
    }

}
