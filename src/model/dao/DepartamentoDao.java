package model.dao;

import java.util.List;

import model.domain.Departamento;

public interface DepartamentoDao {
	
	List<Departamento> getDepartamentos(Departamento Departamento);
	public void excluir(Departamento Departamento);
	Departamento salvar (Departamento Departamento);
	public void atualizar(Departamento Departamento);
}

