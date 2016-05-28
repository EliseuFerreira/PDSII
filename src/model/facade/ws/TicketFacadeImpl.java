package model.facade.ws;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.domain.Ticket;
import model.service.TicketService;

@WebService(serviceName="ws/Ticket")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class TicketFacadeImpl implements TicketFacade {
	
	@Inject
	private TicketService ticketService;
	
	Date dataSistema = new Date();
	
	/* (non-Javadoc)
	 * @see model.facade.ws.TicketFacade#getTickets()
	 */
	
	@WebMethod
	public List<Ticket> getTickets() {
		return ticketService.getTickets();
	}
	
	@WebMethod(operationName="getTicketCodigo")
	public List<Ticket> getTickets(@WebParam(name="codTicket")Integer codigo) {
		Ticket Ticket = new Ticket();
		Ticket.setCodTicket(codigo);
		return ticketService.getTickets(codigo);	
	}
	
	@WebMethod
	public Ticket salvar(@WebParam(name="Ticket")Ticket Ticket) {
		return ticketService.salvar(Ticket);
	}
	
	
	@WebMethod
	public void atualizar(@WebParam(name="Ticket")Ticket Ticket) {
		ticketService.atualizar(Ticket);
	}
	
	@WebMethod
	public void deletarTicket(@WebParam(name="codTicket")Integer codigo){
		Ticket Ticket = new Ticket();
		Ticket.setCodTicket(codigo);
		ticketService.excluir(Ticket);
	}
}

