package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.DepartamentoDao;
import model.domain.Departamento;

@WebService(serviceName="ws/Departamento")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class DepartamentoFacadeImpl implements DepartamentoFacade {
	
	@Inject
	private DepartamentoDao DepartamentoDao;
	
	/* (non-Javadoc)
	 * @see model.facade.ws.DepartamentoFacade#getDepartamentos()
	 */
	
	@WebMethod
	public List<Departamento> getDepartamentos() {
		return DepartamentoDao.getDepartamentos(new Departamento());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.DepartamentoFacade#getDepartamentos(model.domain.Departamento)
	 */
	
	@WebMethod(operationName="getDepartamentoCodigo")
	public List<Departamento> getDepartamentos(@WebParam(name="codDepartamento")Integer codigo) {
		Departamento Departamento = new Departamento();
		Departamento.setCodDepartamento(codigo);
		return DepartamentoDao.getDepartamentos(Departamento);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.DepartamentoFacade#salvar(model.domain.Departamento)
	 */

	@WebMethod
	public Departamento salvar(@WebParam(name="Departamento")Departamento Departamento) {
		return DepartamentoDao.salvar(Departamento);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.DepartamentoFacade#atualizar(model.domain.Departamento)
	 */
	
	@WebMethod
	public void atualizar(@WebParam(name="Departamento")Departamento Departamento) {
		DepartamentoDao.atualizar(Departamento);
	}
	/* (non-Javadoc)
	 * @see model.facade.ws.DepartamentoFacade#excluir(model.domain.Departamento)
	 */
	
	@WebMethod
	public void deletarDepartamento(@WebParam(name="codDepartamento")Integer codigo){
		Departamento Departamento = new Departamento();
		Departamento.setCodDepartamento(codigo);
		DepartamentoDao.excluir(Departamento);
	}


}
