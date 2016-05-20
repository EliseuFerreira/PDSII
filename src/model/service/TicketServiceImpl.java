package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.TicketDaoImpl;
import model.domain.Ticket;

public class TicketServiceImpl implements TicketService {

	@Inject
	private TicketDaoImpl ticketDaoImpl;
	
	
	@Override
	public List<Ticket> getTickets() {
		return ticketDaoImpl.getTickets(new Ticket());
	}
	
	public List<Ticket> getTickets(Integer codigo){
		Ticket ticket = new Ticket();
		ticket.setCodTicket(codigo);
		return ticketDaoImpl.getTickets(ticket);
	}


	

	
	@Override
	@Transactional
	public Ticket salvar(Ticket ticket) {
		return ticketDaoImpl.salvar(ticket);
	}

	
	
	
	@Override
	@Transactional
	public void excluir(Ticket ticket) {
		ticketDaoImpl.excluir(ticket);
		
	}

	

	@Override
	@Transactional
	public void atualizar(Ticket ticket) {
		ticketDaoImpl.atualizar(ticket);
		
	}

}