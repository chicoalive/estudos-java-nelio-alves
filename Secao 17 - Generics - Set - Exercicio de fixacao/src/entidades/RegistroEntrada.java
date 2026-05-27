package entidades;

import java.util.Date;
import java.util.Objects;

public class RegistroEntrada {
    private String usuario;
    private Date momento;

    public RegistroEntrada(String usuario, Date momento) {
        this.usuario = usuario;
        this.momento = momento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    // Implementação de equals e hashCode baseada apenas no usuário
    // Permite que objetos RegistroEntrada sejam comparados e usados em estruturas como HashSet


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RegistroEntrada that)) return false;
        return Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usuario);
    }
}
