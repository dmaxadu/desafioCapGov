package dominio;

import java.sql.Timestamp;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Update {

    public boolean Update(int id, String nome, String cpf, Timestamp data, String obs, Integer numPessoas) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudagendamento");
            EntityManager em = emf.createEntityManager();
            Calendar calendar = Calendar.getInstance();
            calendar.set(1899, Calendar.DECEMBER, 31, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            long timestamp = calendar.getTimeInMillis();
            Timestamp date = new Timestamp(timestamp);
            int comparison = data.compareTo(date);
            em.getTransaction().begin();
            Reserva rr = em.find(Reserva.class, id);
            if (nome != null && !nome.isEmpty()) {
                rr.setNome(nome);
            } else {
                rr.setNome(rr.getNome());
            }

            if (cpf != null && !cpf.isEmpty()) {
                rr.setCpf(cpf);
            } else {
                rr.setCpf(rr.getCpf());
            }

            if (data != null && comparison != 0) {
                rr.setTs(data);
            } else {
                rr.setTs(rr.getTs());
            }

            if (obs != null && !obs.isEmpty()) {
                rr.setObs(obs);
            } else {
                rr.setObs(rr.getObs());
            }

            if (numPessoas != null && numPessoas != 0) {
                rr.setNumPessoas(numPessoas);
            } else {
                rr.setNumPessoas(rr.getNumPessoas());
            }

            em.getTransaction().commit();
            em.close();
            System.out.println("Deu certo!");
        } catch (Exception e) {
            System.out.println("Deu errado!");
            return false;
        }
        return true;
    }
}
