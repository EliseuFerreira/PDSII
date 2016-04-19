package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import model.domain.Tecnico;

public class TecnicoDaoImpl implements TecnicoDao {


	@PersistenceContext(unitName="SistemaTicket")
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Tecnico> getTecnicos(Tecnico Tecnico){
		StringBuffer hql = new StringBuffer("from Tecnico c" + " where 1 = 1");
		if(Tecnico.getCodTecnico()!= null){
			hql.append(" and c.codTecnico = :codigo");
		}
		javax.persistence.Query query = em.createQuery(hql.toString());
		if(Tecnico.getCodTecnico() != null){
			((javax.persistence.Query) query).setParameter("codigo", Tecnico.getCodTecnico());
		}
		return ((javax.persistence.Query) query).getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Tecnico Tecnico){
		Tecnico = em.merge(Tecnico);
		em.remove(Tecnico);
	}
	
	@Override
	@Transactional
	public Tecnico salvar (Tecnico Tecnico){
		em.persist(Tecnico);
		return Tecnico;
	}
	
	@Override
	@Transactional
	public void atualizar (Tecnico Tecnico){
		if (Tecnico.getCodTecnico() != null) {
			Tecnico = em.merge(Tecnico);
		}
		em.persist(Tecnico);

	}
}
