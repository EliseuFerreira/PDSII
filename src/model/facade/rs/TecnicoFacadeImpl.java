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

import model.dao.TecnicoDao;
import model.domain.Tecnico;

@Path("/Tecnico")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class TecnicoFacadeImpl implements TecnicoFacade {

	@Inject
	private TecnicoDao TecnicoDao;
	
	@GET
	public List<Tecnico> getTecnicos() {
		return TecnicoDao.getTecnicos(new Tecnico());
	}

	@GET
	@Path("/{codigo}")
	public List<Tecnico> getTecnicos(@PathParam("codigo") Integer codigo) {
		Tecnico Tecnico = new Tecnico();
		Tecnico.setCodTecnico(codigo);
		return TecnicoDao.getTecnicos(Tecnico);
	}
	

	@POST 
	public Tecnico salvar(Tecnico Tecnico) { 
		Tecnico = TecnicoDao.salvar(Tecnico);
	 	return Tecnico;
	}

	@PUT 
	public void atualizar(Tecnico Tecnico) { 
		TecnicoDao.atualizar(Tecnico);
	}

	@DELETE
	@Path("/{codigo}")
	public void deletarTecnico(@PathParam("codigo") Integer codigo) {
		Tecnico Tecnico = new Tecnico();
		Tecnico.setCodTecnico(codigo);
		TecnicoDao.excluir(Tecnico);
	}

}
