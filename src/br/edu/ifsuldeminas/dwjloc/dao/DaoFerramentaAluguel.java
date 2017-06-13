package br.edu.ifsuldeminas.dwjloc.dao;

import br.edu.ifsuldeminas.dwjloc.model.Ferramenta;
import br.edu.ifsuldeminas.dwjloc.model.FerramentaAluguel;
import br.edu.ifsuldeminas.dwjloc.util.JPAUtil;

import javax.persistence.Query;
import java.util.List;

public class DaoFerramentaAluguel
{
    public List<FerramentaAluguel> getLocacoes(Integer idCliente, boolean entregue, boolean pago)
    {
        List<FerramentaAluguel> result = null;

        String jpql = "SELECT f FROM FerramentaAluguel f WHERE f.usuario.id = :pUsuarioId AND (f.entregue = :pEntregue OR f.pago = :pPago)";
        Query query = JPAUtil.getEntityManager().createQuery(jpql, FerramentaAluguel.class);

        query.setParameter("pUsuarioId", idCliente);
        query.setParameter("pEntregue", entregue);
        query.setParameter("pPago", pago);

        result = query.getResultList();

        return result;
    }
}
