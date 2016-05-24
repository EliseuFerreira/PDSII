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

import model.domain.Ticket;
import model.facade.ws.TicketFacade;
import model.service.TicketService;


@Path("/ticket")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class TicketFacadeImpl implements TicketFacade {
	
	//@Inject
		//private TicketService ticketService;
		
		@Inject
		private TicketService ticketService;

		
		@Override
		@POST
		public Ticket salvar(Ticket ticket) {
			
			return ticketService.salvar(ticket);

		}
		
		
		@Override
		@GET
		public List<Ticket> getTickets() {
			return ticketService.getTickets();
		}
		
		
		@Override
		@GET
		@Path("/{codigo}")
		public List<Ticket> getTickets(@PathParam("codigo") Integer codigo) {
			Ticket ticket = new Ticket();
			ticket.setCodTicket(codigo);
			return ticketService.getTickets(codigo);	
		}
		
		
		
		@Override
		@DELETE
		@Path("/{codigo}")
		public void deletarTicket(@PathParam("codigo") Integer codigo) {
			
				Ticket ticket = new Ticket();
				ticket.setCodTicket(codigo);
				ticketService.excluir(ticket);
				
		}


		@Override
		@PUT
		public void atualizar(Ticket ticket){
			ticketService.atualizar(ticket);
		}
}




