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

import model.dao.DepartamentoDao;
import model.domain.Departamento;
import model.facade.ws.DepartamentoFacade;

@Path("/departamento")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class DepartamentoFacadeImpl implements DepartamentoFacade {
	
	//@Inject
	//private DepartamentoService departamentoService;
	
	@Inject
	private DepartamentoDao departamentoDao;

	
	@Override
	@POST
	public Departamento salvar(Departamento departamento) {
	//	return departamentoService.salvar(departamento);
		return departamentoDao.salvar(departamento);
	}
	
	
	@Override
	@GET
	public List<Departamento> getDepartamentos() {
		//return departamentoService.getDepartamentos();
		return departamentoDao.getDepartamentos(new Departamento());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Departamento> getDepartamentos(@PathParam("codigo") Integer codigo) {
		Departamento departamento = new Departamento();
		departamento.setCodDepartamento(codigo);
		return departamentoDao.getDepartamentos(departamento);	
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarDepartamento(@PathParam("codigo") Integer codigo) {
		
			Departamento departamento = new Departamento();
			departamento.setCodDepartamento(codigo);
		//	departamentoService.excluir(departamento);
			departamentoDao.excluir(departamento);
			
	}


	@Override
	@PUT
	public void atualizar(Departamento departamento){
		//departamentoService.atualizar(departamento);
		departamentoDao.atualizar(departamento);
	}

	

}
