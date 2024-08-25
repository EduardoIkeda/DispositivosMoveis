import java.util.List;
import java.util.ArrayList;

public class Email {
    Integer id;
    String assunto;
    String mensagem;
    Usuario de;
    List<Usuario> listaPara = new ArrayList<Usuario>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getDe() {
        return de;
    }

    public void setDe(Usuario de) {
        this.de = de;
    }

    public List<Usuario> getListaPara() {
        return listaPara;
    }

    public void setListaPara(List<Usuario> listaPara) {
        this.listaPara = listaPara;
    }

    public boolean existeEmail(String email) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);

        for (Usuario u : listaPara) {
            if (u.equals(usuario)) {
                return true;
            }
        }

        return false;
    }

    public void adicionaListaParaUsuario(Usuario usuario) {
        if (existeEmail(usuario.getEmail())) {
            return;
        }

        listaPara.add(usuario);
    }

    @Override
    public String toString() {
        // Montagem "De"
        String stringRetorno = "De:" + de.toString() + "\n";

        // Montagem "Para"
        int tamanhoDaLista = listaPara.size();
        stringRetorno += "Para:[";
        for (Usuario usuario : listaPara) {
            tamanhoDaLista--;
            stringRetorno += usuario.toString();
            if (tamanhoDaLista > 0) {
                stringRetorno += ", ";
            }
        }
        stringRetorno += "]\n";

        // Montagem "Assunto"
        stringRetorno += "Assunto:" + assunto + "\n";

        // Montagem "Mensagem"
        stringRetorno += "Mensagem:" + mensagem + "\n";

        return stringRetorno;
    }

}
