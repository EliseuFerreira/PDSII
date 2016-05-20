package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.TecnicoDaoImpl;
import model.domain.Tecnico;

public class TecnicoServiceImpl implements TecnicoService {

	@Inject
	private TecnicoDaoImpl tecnicoDaoImpl;
	
	
	@Override
	public List<Tecnico> getTecnicos() {
		return tecnicoDaoImpl.getTecnicos(new Tecnico());
	}
	
	public List<Tecnico> getTecnicos(Integer codigo){
		Tecnico tecnico = new Tecnico();
		tecnico.setCodTecnico(codigo);
		return tecnicoDaoImpl.getTecnicos(tecnico);
	}


	

	
	@Override
	@Transactional
	public Tecnico salvar(Tecnico tecnico) {
		return tecnicoDaoImpl.salvar(tecnico);
	}

	
	
	
	@Override
	@Transactional
	public void excluir(Tecnico tecnico) {
		tecnicoDaoImpl.excluir(tecnico);
		
	}

	

	@Override
	@Transactional
	public void atualizar(Tecnico tecnico) {
		tecnicoDaoImpl.atualizar(tecnico);
		
	}

}
