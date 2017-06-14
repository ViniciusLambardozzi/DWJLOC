package br.edu.ifsuldeminas.dwjloc.controller;

import br.edu.ifsuldeminas.dwjloc.dao.Dao;
import br.edu.ifsuldeminas.dwjloc.dao.DaoFerramenta;
import br.edu.ifsuldeminas.dwjloc.lib.LibConstantes;
import br.edu.ifsuldeminas.dwjloc.model.EstadoFerramenta;
import br.edu.ifsuldeminas.dwjloc.model.TipoFerramenta;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@ManagedBean
@ViewScoped
public class AluguelController
{
    private Integer idCliente;
    private Integer idTipo;
    private Integer quantidade;

    private Calendar dataLocacao = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    private Calendar dataDevolucao = Calendar.getInstance();

    public void adicionarLocacao()
    {
        System.out.println(this);
    }

    public List<Integer> getQuantidadeDisponivel()
    {
        if(idTipo == null)
        {
            return new ArrayList<>();
        }

        TipoFerramenta tipo = new Dao<TipoFerramenta>(TipoFerramenta.class).getById(idTipo);
        EstadoFerramenta estado = new Dao<EstadoFerramenta>(EstadoFerramenta.class).getById(LibConstantes.Banco.ID_ESTADO_DISPONIVEL);

        Integer quantidade = new DaoFerramenta().getByTipoAndEstado(tipo, estado).size();
        List<Integer> quantidades = new ArrayList<>(quantidade);
        for(int i = 1; i <= quantidade; i++)
        {
            quantidades.add(i);
        }
        return quantidades;
    }

    public Integer getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente)
    {
        this.idCliente = idCliente;
    }

    public Integer getIdTipo()
    {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo)
    {
        this.idTipo = idTipo;
    }

    public Integer getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade)
    {
        this.quantidade = quantidade;
    }

    public Calendar getDataLocacao()
    {
        return dataLocacao;
    }

    public void setDataLocacao(Calendar dataLocacao)
    {
        this.dataLocacao = dataLocacao;
    }

    public Calendar getDataDevolucao()
    {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao)
    {
        this.dataDevolucao = dataDevolucao;
    }

    @Override public String toString()
    {
        return "AluguelController{" + "idCliente=" + idCliente + ", idTipo=" + idTipo + ", quantidade=" + quantidade + ", dataLocacao=" + dataLocacao.getTime() + ", dataDevolucao=" + dataDevolucao.getTime() + '}';
    }
}
