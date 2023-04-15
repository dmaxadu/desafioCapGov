package aplicacao;

import static com.br.agendamento.AgendamentoBean.convertStringToTimestamp;
import dominio.Create;
import java.sql.Timestamp;
import java.util.Date;
import dominio.Reserva;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dominio.Update;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.persistence.TypedQuery;

public class programa {

    public static void main(String[] args) {
        String ts = "Sat Apr 15 17:58:00 BRT 2023";
        Timestamp st = convertStringToTimestamp(ts);
        Calendar cl = Calendar.getInstance();
        long timestamp = cl.getTimeInMillis();
        Timestamp date = new Timestamp(timestamp);
        int comparison = st.compareTo(date);
        if (comparison < 0) {
            System.out.println("A data e hora a ser comparada é anterior a " + date);
        } else if (comparison == 0) {
            System.out.println("A data e hora a ser comparada é igual a " + date);
        } else {
            System.out.println("A data e hora a ser comparada é posterior a " + date);
        }

    }
}
