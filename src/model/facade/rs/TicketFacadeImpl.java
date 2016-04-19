package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.TicketDao;
import model.domain.Ticket;

@Path("/Ticket")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class TicketFacadeImpl implements TicketFacade {

	@Inject
	private TicketDao TicketDao;
	
	@GET
	public List<Ticket> getTickets() {
		return TicketDao.getTickets(new Ticket());
	}

	@GET
	@Path("/{codigo}")
	public List<Ticket> getTickets(@PathParam("codigo") Integer codigo) {
		Ticket Ticket = new Ticket();
		Ticket.setCodTicket(codigo);
		return TicketDao.getTickets(Ticket);
	}
	
	@POST 
	public Ticket salvar(Ticket Ticket) { 
		Ticket = TicketDao.salvar(Ticket);
	 	return Ticket;
	}
	
	@PUT 
	public void atualizar(Ticket Ticket) { 
		TicketDao.atualizar(Ticket);
	}

	@DELETE
	@Path("/{codigo}")
	public void deletarTicket(@PathParam("codigo") Integer codigo) {
		Ticket Ticket = new Ticket();
		Ticket.setCodTicket(codigo);
		TicketDao.excluir(Ticket);
	}

}
