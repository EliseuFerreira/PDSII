package model.dao;

import java.util.List;

import model.domain.Ticket;

public interface TicketDao {


	public List<Ticket> getTickets(Ticket ticket);

	public void excluir(Ticket ticket);
	
	public Ticket salvar(Ticket ticket);
	
	public void atualizar(Ticket ticket);
}
