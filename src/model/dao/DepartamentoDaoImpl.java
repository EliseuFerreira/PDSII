package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import model.domain.Departamento;

public class DepartamentoDaoImpl implements DepartamentoDao {

	@PersistenceContext(unitName="SistemaTicket")
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Departamento> getDepartamentos(Departamento departamento){
		StringBuffer hql = new StringBuffer("from Departamento c" + " where 1 = 1");
		if(departamento.getCodDepartamento()!= null){
			hql.append(" and c.codDepartamento = :codigo");
		}
		javax.persistence.Query query = em.createQuery(hql.toString());
		if(departamento.getCodDepartamento() != null){
			((javax.persistence.Query) query).setParameter("codigo", departamento.getCodDepartamento());
		}
		return ((javax.persistence.Query) query).getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Departamento departamento){
		departamento = em.merge(departamento);
		em.remove(departamento);
	}
	
	@Override
	@Transactional
	public Departamento salvar (Departamento departamento){
		em.persist(departamento);
		return departamento;
	}
	
	@Override
	@Transactional
	public void atualizar (Departamento departamento){
		if (departamento.getCodDepartamento() != null) {
			departamento = em.merge(departamento);
		}
		em.persist(departamento);

	}
}
