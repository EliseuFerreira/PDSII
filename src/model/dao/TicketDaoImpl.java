package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import model.domain.Ticket;

public class TicketDaoImpl implements TicketDao {


	@PersistenceContext(unitName="SistemaTicket")
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Ticket> getTickets(Ticket Ticket){
		StringBuffer hql = new StringBuffer("from Ticket c" + " where 1 = 1");
		if(Ticket.getCodTicket()!= null){
			hql.append(" and c.codTicket = :codigo");
		}
		javax.persistence.Query query = em.createQuery(hql.toString());
		if(Ticket.getCodTicket() != null){
			((javax.persistence.Query) query).setParameter("codigo", Ticket.getCodTicket());
		}
		return ((javax.persistence.Query) query).getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Ticket Ticket){
		Ticket = em.merge(Ticket);
		em.remove(Ticket);
	}
	
	@Override
	@Transactional
	public Ticket salvar (Ticket Ticket){
		em.persist(Ticket);
		return Ticket;
	}
	
	@Override
	@Transactional
	public void atualizar (Ticket Ticket){
		if (Ticket.getCodTicket() != null) {
			Ticket = em.merge(Ticket);
		}
		em.persist(Ticket);

	}
}

