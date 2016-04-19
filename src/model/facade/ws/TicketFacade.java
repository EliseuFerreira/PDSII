package model.facade.ws;

import java.util.List;

import model.domain.Ticket;

public interface TicketFacade {

	Ticket salvar(Ticket Ticket);
	List<Ticket> getTickets();
	List<Ticket> getTickets(Integer codigo);
	void atualizar(Ticket Ticket);
	void deletarTicket(Integer codigo);
	
}