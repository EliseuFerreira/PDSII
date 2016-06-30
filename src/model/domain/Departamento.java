package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="tb_departamento")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "codDepartamento")
	private Integer codDepartamento;
		

	@Size(min=6,message="Nome do departamento precisa ter pelo menos 6 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name="nome")
	private String nome;
	
	@OneToMany(mappedBy="departamento")
	private List<Tecnico>tecnicos;

	public Departamento(){
		this.tecnicos = new ArrayList<Tecnico>();
	}

	public Integer getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(Integer codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@XmlTransient
	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}
	
	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codDepartamento == null) ? 0 : codDepartamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (codDepartamento == null) {
			if (other.codDepartamento != null)
				return false;
		} else if (!codDepartamento.equals(other.codDepartamento))
			return false;
		return true;
	}
}
