package br.edu.ifsuldeminas.dwjloc.model;

import com.sun.xml.internal.ws.client.ClientTransportException;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Calendar;

@Entity
public class FerramentaAluguel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    private Ferramenta ferramenta;

    @ManyToOne
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    private Calendar dataLocacao;
    @Temporal(TemporalType.DATE)
    private Calendar prazoDevolucao;

    private Float valorDiario;

    private Boolean entregue;
    private Boolean pago;

    public Integer getId()
    {
        return Id;
    }

    public void setId(Integer id)
    {
        Id = id;
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

    public Float getValorDiario()
    {
        return valorDiario;
    }

    public void setValorDiario(Float valorDiario)
    {
        this.valorDiario = valorDiario;
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

    @Override
    public String toString()
    {
        return "FerramentaAluguel{" +
                "ferramenta=" + ferramenta.getTipo() +
                ", usuario=" + usuario.getId() +
                '}';
    }
}
