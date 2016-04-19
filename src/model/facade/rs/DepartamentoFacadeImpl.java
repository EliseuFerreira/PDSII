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

@Path("/Departamento")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class DepartamentoFacadeImpl implements DepartamentoFacade {

	@Inject
	private DepartamentoDao DepartamentoDao;
	
	@GET
	public List<Departamento> getDepartamentos() {
		return DepartamentoDao.getDepartamentos(new Departamento());
	}

	@GET
	@Path("/{codigo}")
	public List<Departamento> getDepartamentos(@PathParam("codigo") Integer codigo) {
		Departamento departamento = new Departamento();
		departamento.setCodDepartamento(codigo);
		return DepartamentoDao.getDepartamentos(departamento);
	}
	
	@POST 
	public Departamento salvar(Departamento Departamento) { 
		Departamento = DepartamentoDao.salvar(Departamento);
	 	return Departamento;
	}
	
	@PUT 
	public void atualizar(Departamento departamento) { 
		DepartamentoDao.atualizar(departamento);
	}

	@DELETE
	@Path("/{codigo}")
	public void deletarDepartamento(@PathParam("codigo") Integer codigo) {
		Departamento departamento = new Departamento();
		departamento.setCodDepartamento(codigo);
		DepartamentoDao.excluir(departamento);
	}

}
