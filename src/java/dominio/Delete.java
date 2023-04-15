package dominio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Delete {
    public void delete(Integer id) {
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudagendamento");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Reserva rr = em.find(Reserva.class, id);
            em.remove(rr);
            em.getTransaction().commit();
            em.close();
            emf.close();
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
}
