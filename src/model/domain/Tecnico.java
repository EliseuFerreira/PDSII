package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="tb_tecnico")
public class Tecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codTecnico")
	private Integer codTecnico;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="status")
	private Boolean status;
	
	@OneToMany(mappedBy="tecnico")
	private List<Ticket>tickets;
	
	@ManyToOne
	@JoinColumn(name="departamento", referencedColumnName="codDepartamento")
	private Departamento departamento;
	
	
	public Tecnico(){
		this.tickets = new ArrayList<Ticket>();
	}


	/**
	 * @return the codTecnico
	 */
	public Integer getCodTecnico() {
		return codTecnico;
	}


	/**
	 * @param codTecnico the codTecnico to set
	 */
	public void setCodTecnico(Integer codTecnico) {
		this.codTecnico = codTecnico;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}


	/**
	 * @return the tickets
	 */
	@XmlTransient
	public List<Ticket> getTickets() {
		return tickets;
	}


	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}


	/**
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}


	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codTecnico == null) ? 0 : codTecnico.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tecnico other = (Tecnico) obj;
		if (codTecnico == null) {
			if (other.codTecnico != null)
				return false;
		} else if (!codTecnico.equals(other.codTecnico))
			return false;
		return true;
	}



	

}
