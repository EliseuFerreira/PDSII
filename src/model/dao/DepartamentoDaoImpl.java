package model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Departamento;
public class DepartamentoDaoImpl implements DepartamentoDao{


	@PersistenceContext(unitName="SistemaTicket")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Departamento> getDepartamentos(Departamento departamento) {	
		StringBuffer hq1 = new StringBuffer("from Departamento c where 1 = 1");
		if (departamento.getCodDepartamento() != null) {
			hq1.append(" and c.codDepartamento = :codigo");
		}

		Query query = entityManager.createQuery(hq1.toString());
		if (departamento.getCodDepartamento() != null) {
			query.setParameter("codigo", departamento.getCodDepartamento());
		}
		return query.getResultList();

	}

	
	@Override
	@Transactional
	public void excluir(Departamento departamento){
		departamento = entityManager.merge(departamento);
		entityManager.remove(departamento);
	}

	@Override
	@Transactional
	public Departamento salvar(Departamento departamento){
		entityManager.persist(departamento);
		return departamento;
	}
	
	@Override
	@Transactional
	public void atualizar(Departamento departamento){
		departamento = entityManager.merge(departamento);
		entityManager.persist(departamento);
		
	}
}
