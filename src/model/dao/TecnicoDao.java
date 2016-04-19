package model.dao;

import java.util.List;

import model.domain.Tecnico;

public interface TecnicoDao {
	
	List<Tecnico> getTecnicos(Tecnico Tecnico);
	public void excluir(Tecnico Tecnico);
	Tecnico salvar (Tecnico Tecnico);
	public void atualizar(Tecnico Tecnico);
}
