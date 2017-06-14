package br.edu.ifsuldeminas.dwjloc.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifsuldeminas.dwjloc.dao.Dao;
import br.edu.ifsuldeminas.dwjloc.dao.UsuarioDao;
import br.edu.ifsuldeminas.dwjloc.lib.LibConstantes;
import br.edu.ifsuldeminas.dwjloc.model.Grupo;
import br.edu.ifsuldeminas.dwjloc.model.Usuario;
import br.edu.ifsuldeminas.dwjloc.util.Utils;


@ManagedBean
@ViewScoped
public class UsuarioController
{
	protected String senhaBd;
	protected Integer idGrupo;
	
	
	public String getSenhaBd() {
		return senhaBd;
	}

	public void setSenhaBd(String senhaBd) {
		this.senhaBd = senhaBd;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public void gravar(Usuario usuario)
	{		FacesContext.getCurrentInstance().addMessage("pessoafisica", new FacesMessage(String.valueOf(idGrupo)));

		Grupo grupo = new Dao<Grupo>(Grupo.class).getById(idGrupo);
		usuario.setGrupo(grupo);
		
		if(!usuario.getSenha().equals(senhaBd))
		{
			usuario.setSenha(Utils.toMD5(usuario.getSenha()));
		}
		
		if(usuario.getId() == null)
		{
			new Dao<Usuario>(Usuario.class).add(usuario);			
		}else
		{
			new Dao<Usuario>(Usuario.class).update(usuario);
		}
	}
	
	public void carregar(Usuario usuario)
	{
		senhaBd = usuario.getSenha();
	}
	
	public void remover(Usuario usuario)
	{
		new Dao<Usuario>(Usuario.class).remove(usuario);
	}
	
	public List<Usuario> getUsuarios()
	{
		return new Dao<Usuario>(Usuario.class).getAll();
	}
	
	public List<Usuario> getClientes()
	{
		Grupo grupo = new Grupo();
		grupo.setId(LibConstantes.Banco.ID_GRUPO_CLIENTES);
		return new UsuarioDao().getByGroup(grupo);
	}
	
	public List<Grupo> getGrupos()
	{
		return new Dao<Grupo>(Grupo.class).getAll();
	}
}