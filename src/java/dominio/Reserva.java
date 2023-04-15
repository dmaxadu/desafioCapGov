package dominio;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Entity
public class Reserva implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private Timestamp ts;
    private String obs;
    private int numPessoas;

    public Reserva() {

    }

    public Reserva(Integer id, String nome, String cpf, Timestamp ts, String obs, int numPessoas) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.ts = ts;
        this.obs = obs;
        this.numPessoas = numPessoas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", data=" + ts + ", obs=" + obs + ", numPessoas=" + numPessoas + '}';
    }

    public List<Reserva> listarTodos(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudagendamento");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT * FROM Reserva";
        TypedQuery<Reserva> query = (TypedQuery<Reserva>) em.createNativeQuery(jpql, Reserva.class);
        List<Reserva> lista = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return lista;
    }
    
    public List<Reserva> buscaCpf(String cpf){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudagendamento");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT * FROM Reserva WHERE cpf = :cpf";
        TypedQuery<Reserva> query = (TypedQuery<Reserva>) em.createNativeQuery(jpql, Reserva.class);
        query.setParameter("cpf", cpf);
        List<Reserva> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
    }
}
