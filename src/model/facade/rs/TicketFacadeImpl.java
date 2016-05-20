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
import model.facade.ws.TicketFacade;


@Path("/ticket")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class TicketFacadeImpl implements TicketFacade {
	
	//@Inject
		//private TicketService ticketService;
		
		@Inject
		private TicketDao ticketDao;

		
		@Override
		@POST
		public Ticket salvar(Ticket ticket) {
		//	return ticketService.salvar(ticket);
			return ticketDao.salvar(ticket);
		}
		
		
		@Override
		@GET
		public List<Ticket> getTickets() {
			//return ticketService.getTickets();
			return ticketDao.getTickets(new Ticket());
		}
		
		
		@Override
		@GET
		@Path("/{codigo}")
		public List<Ticket> getTickets(@PathParam("codigo") Integer codigo) {
			Ticket ticket = new Ticket();
			ticket.setCodTicket(codigo);
			return ticketDao.getTickets(ticket);	
		}
		
		
		
		@Override
		@DELETE
		@Path("/{codigo}")
		public void deletarTicket(@PathParam("codigo") Integer codigo) {
			
				Ticket ticket = new Ticket();
				ticket.setCodTicket(codigo);
			//	ticketService.excluir(ticket);
				ticketDao.excluir(ticket);
				
		}


		@Override
		@PUT
		public void atualizar(Ticket ticket){
			//ticketService.atualizar(ticket);
			ticketDao.atualizar(ticket);
		}
}




