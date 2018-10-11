package br.edu.ifro.model;

 //@author 80923755268
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String calc_numero1;
    private String calc_numero2;
    private String calc_operacao;
    private String calc_resultado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalc_numero1() {
        return calc_numero1;
    }

    public void setCalc_numero1(String calc_numero1) {
        this.calc_numero1 = calc_numero1;
    }

    public String getCalc_numero2() {
        return calc_numero2;
    }

    public void setCalc_numero2(String calc_numero2) {
        this.calc_numero2 = calc_numero2;
    }

    public String getCalc_operacao() {
        return calc_operacao;
    }

    public void setCalc_operacao(String calc_operacao) {
        this.calc_operacao = calc_operacao;
    }

    public String getCalc_resultado() {
        return calc_resultado;
    }

    public void setCalc_resultado(String calc_resultado) {
        this.calc_resultado = calc_resultado;
    }
}
