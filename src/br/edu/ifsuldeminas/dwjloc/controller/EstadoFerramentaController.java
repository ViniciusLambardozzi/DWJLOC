package br.edu.ifsuldeminas.dwjloc.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dwjloc.dao.Dao;
import br.edu.ifsuldeminas.dwjloc.model.EstadoFerramenta;

@ManagedBean
@ViewScoped
public class EstadoFerramentaController
{
	private EstadoFerramenta estadoFerramenta = new EstadoFerramenta();

	public EstadoFerramenta getEstadoFerramenta() {
		return estadoFerramenta;
	}

	public void setEstadoFerramenta(EstadoFerramenta estadoFerramenta) {
		this.estadoFerramenta = estadoFerramenta;
	}
	
	public List<EstadoFerramenta> getEstadosFerramentas()
	{
		return new Dao<EstadoFerramenta>(EstadoFerramenta.class).getAll();
	}
	
	public void carregar(EstadoFerramenta estadoFerramenta)
	{
		this.estadoFerramenta = estadoFerramenta;
	}
	
	public void gravar(EstadoFerramenta estadoFerramenta)
	{
		if(estadoFerramenta.getId() == null)
		{
			new Dao<EstadoFerramenta>(EstadoFerramenta.class).add(estadoFerramenta);			
		}else
		{
			new Dao<EstadoFerramenta>(EstadoFerramenta.class).update(estadoFerramenta);
		}
		this.estadoFerramenta = new EstadoFerramenta();
	}
	
	public void remover(EstadoFerramenta estadoFerramenta)
	{
		new Dao<EstadoFerramenta>(EstadoFerramenta.class).remove(estadoFerramenta);
	}
}
