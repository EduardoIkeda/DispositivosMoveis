public class Usuario {
    String nome;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario usuario = (Usuario) obj;
            return usuario.getEmail().equals(this.getEmail());
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "Nome: " + nome + " Email: " + email;
    }
}
