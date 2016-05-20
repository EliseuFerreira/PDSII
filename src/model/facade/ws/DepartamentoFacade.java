package model.facade.ws;

import java.util.List;

import model.domain.Departamento;

public interface DepartamentoFacade {

	Departamento salvar(Departamento Departamento);
	List<Departamento> getDepartamentos();
	List<Departamento> getDepartamentos(Integer codigo);
	void atualizar(Departamento Departamento);
	void deletarDepartamento(Integer codigo);
	

}