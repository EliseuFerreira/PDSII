package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.TecnicoDao;
import model.domain.Tecnico;

@WebService(serviceName="ws/Tecnico")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class TecnicoFacadeImpl implements TecnicoFacade {
	
	@Inject
	private TecnicoDao TecnicoDao;
	
	/* (non-Javadoc)
	 * @see model.facade.ws.TecnicoFacade#getTecnicos()
	 */
	
	@WebMethod
	public List<Tecnico> getTecnicos() {
		return TecnicoDao.getTecnicos(new Tecnico());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.TecnicoFacade#getTecnicos(model.domain.Tecnico)
	 */
	
	@WebMethod(operationName="getTecnicoCodigo")
	public List<Tecnico> getTecnicos(@WebParam(name="codTecnico")Integer codigo) {
		Tecnico Tecnico = new Tecnico();
		Tecnico.setCodTecnico(codigo);
		return TecnicoDao.getTecnicos(Tecnico);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.TecnicoFacade#salvar(model.domain.Tecnico)
	 */

	@WebMethod
	public Tecnico salvar(@WebParam(name="Tecnico")Tecnico Tecnico) {
		return TecnicoDao.salvar(Tecnico);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.TecnicoFacade#atualizar(model.domain.Tecnico)
	 */
	
	@WebMethod
	public void atualizar(@WebParam(name="Tecnico")Tecnico Tecnico) {
		TecnicoDao.atualizar(Tecnico);
	}
	/* (non-Javadoc)
	 * @see model.facade.ws.TecnicoFacade#excluir(model.domain.Tecnico)
	 */
	
	@WebMethod
	public void deletarTecnico(@WebParam(name="codTecnico")Integer codigo){
		Tecnico Tecnico = new Tecnico();
		Tecnico.setCodTecnico(codigo);
		TecnicoDao.excluir(Tecnico);
	}


}
