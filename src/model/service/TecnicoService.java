package model.service;

import java.util.List;

import model.domain.Tecnico;

public interface TecnicoService {

	List<Tecnico> getTecnicos(Integer codigo);

	List<Tecnico> getTecnicos();

	Tecnico salvar(Tecnico tecnico);

	void excluir(Tecnico tecnico);

	void atualizar(Tecnico tecnico);

}