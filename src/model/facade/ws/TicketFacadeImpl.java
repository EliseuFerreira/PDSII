package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.TicketDao;
import model.domain.Ticket;

@WebService(serviceName="ws/Ticket")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class TicketFacadeImpl implements TicketFacade {
	
	@Inject
	private TicketDao TicketDao;
	
	/* (non-Javadoc)
	 * @see model.facade.ws.TicketFacade#getTickets()
	 */
	
	@WebMethod
	public List<Ticket> getTickets() {
		return TicketDao.getTickets(new Ticket());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.TicketFacade#getTickets(model.domain.Ticket)
	 */
	
	@WebMethod(operationName="getTicketCodigo")
	public List<Ticket> getTickets(@WebParam(name="codTicket")Integer codigo) {
		Ticket Ticket = new Ticket();
		Ticket.setCodTicket(codigo);
		return TicketDao.getTickets(Ticket);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.TicketFacade#salvar(model.domain.Ticket)
	 */

	@WebMethod
	public Ticket salvar(@WebParam(name="Ticket")Ticket Ticket) {
		return TicketDao.salvar(Ticket);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.TicketFacade#atualizar(model.domain.Ticket)
	 */
	
	@WebMethod
	public void atualizar(@WebParam(name="Ticket")Ticket Ticket) {
		TicketDao.atualizar(Ticket);
	}
	/* (non-Javadoc)
	 * @see model.facade.ws.TicketFacade#excluir(model.domain.Ticket)
	 */
	
	@WebMethod
	public void deletarTicket(@WebParam(name="codTicket")Integer codigo){
		Ticket Ticket = new Ticket();
		Ticket.setCodTicket(codigo);
		TicketDao.excluir(Ticket);
	}


}

