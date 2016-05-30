package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import model.domain.Ticket;

public class TicketDaoImpl implements TicketDao {

	Date dataSistema = new Date();

	@PersistenceContext(unitName="SistemaTicket")
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Ticket> getTickets(Ticket Ticket){
		StringBuffer hql = new StringBuffer("from Ticket c" + " where 1 = 1");
		if(Ticket.getCodTicket()!= null){
			hql.append(" and c.codTicket = :codigo");
			hql.append(" ORDER BY dataAbertura desc");
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
		Ticket ticke = new Ticket(null, Ticket.getAssunto(),dataSistema,Ticket.getDataFechamento(),Ticket.getDescricao(),Ticket.getEmail(),Ticket.getNomeResponsavel(),Ticket.getOsBeany(),Ticket.getPrioridade(), Ticket.getSituacao(),Ticket.getStatus(),Ticket.getTecnico());
		
		em.persist(ticke);
		return ticke;
	}
	
	@Override
	@Transactional
	public void atualizar (Ticket Ticket){
		if (Ticket.getCodTicket() != null) {
			//incluir data se foi fechado
			if(Ticket.getStatus().getStatus()=="Fechado"){
				Ticket ticke = new Ticket(Ticket.getCodTicket(), Ticket.getAssunto(),Ticket.getDataAbertura(),dataSistema,Ticket.getDescricao(),Ticket.getEmail(),Ticket.getNomeResponsavel(),Ticket.getOsBeany(),Ticket.getPrioridade(), Ticket.getSituacao(),Ticket.getStatus(),Ticket.getTecnico());
				em.merge(ticke);
			}else{
				em.merge(Ticket);
			}

		}else{
			//Incluir data se o ticket foi aberto
			Ticket ticke = new Ticket(null, Ticket.getAssunto(),dataSistema,Ticket.getDataFechamento(),Ticket.getDescricao(),Ticket.getEmail(),Ticket.getNomeResponsavel(),Ticket.getOsBeany(),Ticket.getPrioridade(), Ticket.getSituacao(),Ticket.getStatus(),Ticket.getTecnico());
			em.persist(ticke);
		}
		

	}

}

