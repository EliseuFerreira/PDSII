package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.DepartamentoDaoImpl;
import model.domain.Departamento;

public class DepartamentoServiceImpl implements DepartamentoService  {

	@Inject
	private DepartamentoDaoImpl departamentoDaoImpl;
	
	
	@Override
	public List<Departamento> getDepartamentos() {
		return departamentoDaoImpl.getDepartamentos(new Departamento());
	}
	
	public List<Departamento> getDepartamentos(Integer codigo){
		Departamento departamento = new Departamento();
		departamento.setCodDepartamento(codigo);
		return departamentoDaoImpl.getDepartamentos(departamento);
	}


	

	
	@Override
	@Transactional
	public Departamento salvar(Departamento departamento) {
		return departamentoDaoImpl.salvar(departamento);
	}

	
	
	
	@Override
	@Transactional
	public void excluir(Departamento departamento) {
		departamentoDaoImpl.excluir(departamento);
		
	}

	

	@Override
	@Transactional
	public void atualizar(Departamento departamento) {
		departamentoDaoImpl.atualizar(departamento);
		
	}

}
