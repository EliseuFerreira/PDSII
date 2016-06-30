package model.facade.rs;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Ticket;

public interface TicketFacade {
	@ValidateOnExecution
	Ticket salvar(@Valid Ticket Ticket);
	List<Ticket> getTickets();
	List<Ticket> getTickets(Integer codigo);
	void atualizar(Ticket Ticket);
	void deletarTicket(Integer codigo);

}