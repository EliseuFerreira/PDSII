package model.service;

import java.util.List;

import model.domain.Departamento;

public interface DepartamentoService {
	
	List<Departamento> getDepartamentos(Integer codigo);

	List<Departamento> getDepartamentos();

	Departamento salvar(Departamento departamento);

	void excluir(Departamento departamento);

	void atualizar(Departamento departamento);

}