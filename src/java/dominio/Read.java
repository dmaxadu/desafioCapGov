package dominio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Read {
    public Reserva read(Integer id) {
        
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudagendamento");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Reserva rr = em.find(Reserva.class, id);
            em.getTransaction().commit();
            em.close();
            emf.close();
            return rr;
        }
        catch(Exception e){
            System.err.println(e);
            Reserva r1 = new Reserva();
            return r1;
        }
    }
	
}
