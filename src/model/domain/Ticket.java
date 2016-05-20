package model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="tb_ticket")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codTicket")
	private Integer codTicket;
	
	@Column(name = "assunto")
	private String assunto;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dataAbertura")
	private Date dataAbertura;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dataFechamento")
	private Date dataFechamento;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nomeResponsavel")
	private String nomeResponsavel;
	
	@Column(name = "osBeany")
	private Integer osBeany;

	@Column(name = "prioridade")
	private String prioridade;
	
	@Column(name = "situacao")
	private String situacao;
	
	@Column(name = "status")
	private Boolean status;

	@ManyToOne
	@JoinColumn(name="tecnico", referencedColumnName="codTecnico")
	private Tecnico tecnico;
	
	
	
	public Ticket(){
	}



	public Integer getCodTicket() {
		return codTicket;
	}

	public void setCodTicket(Integer codTicket) {
		this.codTicket = codTicket;
	}


	public Integer getOsBeany() {
		return osBeany;
	}

	public void setOsBeany(Integer osBeany) {
		this.osBeany = osBeany;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}


	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the assunto
	 */
	public String getAssunto() {
		return assunto;
	}



	/**
	 * @param assunto the assunto to set
	 */
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}



	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}



	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	/**
	 * @return the prioridade
	 */
	public String getPrioridade() {
		return prioridade;
	}



	/**
	 * @param prioridade the prioridade to set
	 */
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}



	/**
	 * @return the dataAbertura
	 */
	public Date getDataAbertura() {
		return dataAbertura;
	}



	/**
	 * @param dataAbertura the dataAbertura to set
	 */
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}



	/**
	 * @return the dataFechamento
	 */
	public Date getDataFechamento() {
		return dataFechamento;
	}



	/**
	 * @param dataFechamento the dataFechamento to set
	 */
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}



	/**
	 * @return the situacao
	 */
	public String getSituacao() {
		return situacao;
	}



	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
	 * @return the tecnico
	 */
	public Tecnico getTecnico() {
		return tecnico;
	}



	/**
	 * @param tecnico the tecnico to set
	 */
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codTicket == null) ? 0 : codTicket.hashCode());
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
		Ticket other = (Ticket) obj;
		if (codTicket == null) {
			if (other.codTicket != null)
				return false;
		} else if (!codTicket.equals(other.codTicket))
			return false;
		return true;
	}

}
