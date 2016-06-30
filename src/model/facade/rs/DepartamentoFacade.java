package model.facade.rs;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Departamento;

public interface DepartamentoFacade {
	
	@ValidateOnExecution
	Departamento salvar(@Valid Departamento Departamento);
	List<Departamento> getDepartamentos();
	List<Departamento> getDepartamentos(Integer codigo);
	void atualizar(Departamento Departamento);
	void deletarDepartamento(Integer codigo);

}