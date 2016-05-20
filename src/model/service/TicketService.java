package model.service;

import java.util.List;

import model.domain.Ticket;

public interface TicketService {

	List<Ticket> getTickets(Integer codigo);

	List<Ticket> getTickets();

	Ticket salvar(Ticket ticket);

	void excluir(Ticket ticket);

	void atualizar(Ticket ticket);

}