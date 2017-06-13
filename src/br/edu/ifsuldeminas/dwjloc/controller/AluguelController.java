package br.edu.ifsuldeminas.dwjloc.controller;

import br.edu.ifsuldeminas.dwjloc.dao.Dao;
import br.edu.ifsuldeminas.dwjloc.dao.DaoFerramenta;
import br.edu.ifsuldeminas.dwjloc.dao.DaoFerramentaAluguel;
import br.edu.ifsuldeminas.dwjloc.dao.UsuarioDao;
import br.edu.ifsuldeminas.dwjloc.lib.LibConstantes;
import br.edu.ifsuldeminas.dwjloc.model.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.*;

@ManagedBean
@ViewScoped
public class AluguelController
{
    private Integer idUsuario;
    private Integer idTipo;

    private Integer quantidade;

    private Calendar dataLocacao = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    private Calendar prazoDevolucao = Calendar.getInstance();

    public List<Integer> locar()
    {
        System.out.println("locar");
        FerramentaAluguel locacao = new FerramentaAluguel();

        Usuario usuario = new Dao<Usuario>(Usuario.class).getById(idUsuario);

        TipoFerramenta tipo = new TipoFerramenta();
        tipo.setId(idTipo);

        EstadoFerramenta estado = new EstadoFerramenta();
        estado.setId(LibConstantes.Banco.ID_ESTADO_DISPONIVEL);

        //TODO turn into list
        Ferramenta ferramenta = new DaoFerramenta().getByTipoAndEstado(tipo, estado).get(0);

        locacao.setValorDiario(ferramenta.getPrecoAluguel());
        locacao.setFerramenta(ferramenta);
        locacao.setDataLocacao(dataLocacao);
        locacao.setPrazoDevolucao(prazoDevolucao);
        locacao.setUsuario(usuario);
        locacao.setEntregue(false);
        locacao.setPago(false);

        new Dao<FerramentaAluguel>(FerramentaAluguel.class).add(locacao);

        return new ArrayList<>();
    }

    public List<FerramentaAluguel> getPendencias()
    {
        System.out.println("Pendencias");
        return new DaoFerramentaAluguel().getLocacoes(idUsuario, false, false);
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

    public Integer getIdTipo()
    {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo)
    {
        this.idTipo = idTipo;
    }

    public Integer getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario)
    {
        this.idUsuario = idUsuario;
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

    public Calendar getPrazoDevolucao()
    {
        return prazoDevolucao;
    }

    public void setPrazoDevolucao(Calendar prazoDevolucao)
    {
        this.prazoDevolucao = prazoDevolucao;
    }
}
