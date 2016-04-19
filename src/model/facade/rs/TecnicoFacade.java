package model.facade.rs;

import java.util.List;

import model.domain.Tecnico;

public interface TecnicoFacade {

	Tecnico salvar(Tecnico Tecnico);
	List<Tecnico> getTecnicos();
	List<Tecnico> getTecnicos(Integer codigo);
	void atualizar(Tecnico Tecnico);
	void deletarTecnico(Integer codigo);

}