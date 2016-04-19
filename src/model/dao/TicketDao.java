package model.dao;

import java.util.List;

import model.domain.Ticket;

public interface TicketDao {
	
	List<Ticket> getTickets(Ticket Ticket);
	public void excluir(Ticket Ticket);
	public Ticket salvar (Ticket Ticket);
	public void atualizar(Ticket Ticket);
}
