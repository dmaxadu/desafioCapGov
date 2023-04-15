package dominio;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Create {

    public boolean create(String nome, String cpf, Timestamp data, String obs, int numPessoas) {
        try {
            Reserva er = new Reserva();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudagendamento");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            if (er.buscaCpf(cpf).isEmpty()) {
                Reserva rr = new Reserva(null, nome, cpf, data, obs, numPessoas);
                em.persist(rr);
                em.getTransaction().commit();
                em.close();
                System.out.println("Cheguei aqui");
            }
            else{
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
}
