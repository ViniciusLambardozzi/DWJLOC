package br.edu.ifsuldeminas.dwjloc.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class FerramentaAluguel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Calendar dataLocacao;
    @Temporal(TemporalType.DATE)
    private Calendar prazoDevolucao;

    @ManyToOne
    private Ferramenta ferramenta;

    @ManyToOne
    private Usuario usuario;

    private Boolean entregue;
    private Boolean pago;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Calendar getDataLocacao()
    {
        return dataLocacao;
    }

    public void setDataLocacao(Calendar dataLocacao)
    {
        this.dataLocacao = dataLocacao;
    }

    public Calendar getPrazoDevolucao()
    {
        return prazoDevolucao;
    }

    public void setPrazoDevolucao(Calendar prazoDevolucao)
    {
        this.prazoDevolucao = prazoDevolucao;
    }

    public Ferramenta getFerramenta()
    {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta)
    {
        this.ferramenta = ferramenta;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Boolean getEntregue()
    {
        return entregue;
    }

    public void setEntregue(Boolean entregue)
    {
        this.entregue = entregue;
    }

    public Boolean getPago()
    {
        return pago;
    }

    public void setPago(Boolean pago)
    {
        this.pago = pago;
    }
}
