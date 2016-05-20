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
import model.facade.ws.TecnicoFacade;

@Path("/tecnico")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class TecnicoFacadeImpl implements TecnicoFacade {
	
	//@Inject
		//private CategoriaService tecnicoService;
		
		@Inject
		private TecnicoDao tecnicoDao;

		
		@Override
		@POST
		public Tecnico salvar(Tecnico tecnico) {
		//	return tecnicoService.salvar(tecnico);
			return tecnicoDao.salvar(tecnico);
		}
		
		
		@Override
		@GET
		public List<Tecnico> getTecnicos() {
			//return tecnicoService.getCategorias();
			return tecnicoDao.getTecnicos(new Tecnico());
		}
		
		
		@Override
		@GET
		@Path("/{codigo}")
		public List<Tecnico> getTecnicos(@PathParam("codigo") Integer codigo) {
			Tecnico tecnico = new Tecnico();
			tecnico.setCodTecnico(codigo);
			return tecnicoDao.getTecnicos(tecnico);	
		}
		
		
		
		@Override
		@DELETE
		@Path("/{codigo}")
		public void deletarTecnico(@PathParam("codigo") Integer codigo) {
			
				Tecnico tecnico = new Tecnico();
				tecnico.setCodTecnico(codigo);
			//	tecnicoService.excluir(tecnico);
				tecnicoDao.excluir(tecnico);
				
		}


		@Override
		@PUT
		public void atualizar(Tecnico tecnico){
			//tecnicoService.atualizar(tecnico);
			tecnicoDao.atualizar(tecnico);

		}
}



