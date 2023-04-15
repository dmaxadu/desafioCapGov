package com.br.agendamento;

import javax.faces.bean.ManagedBean;
import dominio.Create;
import dominio.Delete;
import dominio.Reserva;
import dominio.Update;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class AgendamentoBean {

    private String nome;
    private String cpf;
    private String ts;
    private String obs;
    private int numPessoas;
    private String resultado;
    private List<Reserva> lista;
    private Integer id;

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

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static Timestamp convertStringToTimestamp(String datetime) {
        Timestamp data1 = new Timestamp(0, 0, 0, 0, 0, 0, 0);
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            java.util.Date data = fmt.parse(datetime);
            data1 = new Timestamp(data.getTime());
        } catch (Exception e) {
            System.err.println(e);
        }
        return data1;
    }

    public void criar() {
        Create cr = new Create();
        Timestamp st = convertStringToTimestamp(ts);
        Calendar cl = Calendar.getInstance();
        long timestamp = cl.getTimeInMillis();
        Timestamp date = new Timestamp(timestamp);
        int comparison = st.compareTo(date);
        if (comparison < 0) {
            resultado = "Esta data já passou!";
        } else if (comparison == 0) {
            resultado = "A reserva deve ser agendada com pelo menos 30 minutos de antecedência.";
        } else {
            if (cr.create(nome, cpf, st, obs, numPessoas)) {
                resultado = "Operação realizada com Sucesso!";
            } else {
                resultado = "Tente novamente!";
            }
        }
    }

    public List<Reserva> getLista() {
        Reserva rs = new Reserva();
        lista = rs.listarTodos();
        return lista;
    }

    public void deletar() {
        Delete dl = new Delete();
        dl.delete(id);

    }

    public void atualizar() {
        Timestamp st = convertStringToTimestamp(ts);
        Update upt = new Update();
        if (upt.Update(id, nome, cpf, st, obs, numPessoas)) {
            resultado = "Operação realizada com sucesso";
        } else {
            resultado = "Tente novamente";
        }
    }

}
