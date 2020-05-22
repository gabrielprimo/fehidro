package br.unisantos.fehidro.model;

import java.util.Date;

import javax.faces.model.SelectItem;
import javax.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
//import javax.persistence.Entity;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

@Table(name = "tb_usuario")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "nm_pertence_a_classe", length = 256)
@NamedQueries({ @NamedQuery(name = "Usuario.listarTodos", query = "select u from Usuario u order by u.nome"),
		@NamedQuery(name = "Usuario.consultarPorId", query = "select u from Usuario u where u.id=?1"),
		@NamedQuery(name = "Usuario.consultarPorLogin", query = "select u from Usuario u where u.login=?1"),
		@NamedQuery(name = "Usuario.consultarPorCPF", query = "select u from Usuario u where u.cpf=?1"),
		@NamedQuery(name = "Usuario.consultarPorPerfilAcesso", query = "select u from Usuario u where u.perfilacesso=?1") })
public class Usuario extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_usuario", length = 256)
	private String nome;

	@Column(name = "nm_sobre_usuario", length = 256)
	private String sobrenome;

	@Column(name = "nr_cpf", length = 256)
	private String CPF;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	@Column(name = "ds_email", length = 256)
	private String email;

	@Column(name = "ds_login", length = 256)
	private String login;

	@Column(name = "ds_senha", length = 256)
	private String senha;

	@Column(name = "ic_ativo", length = 50)
	private Boolean ativo;

	@Column(name = "nr_telefone")
	private String telefone;

	@Column(name = "id_perfilacesso")
	private long perfilAcesso;

	public Usuario() {
	}
//	public Usuario(long id, String nome, String sobrenome, String cpf, String senha) {
////		 super();
//		setId(id);
//		setNome(nome);
//		setSobrenome(sobrenome);
//		setCPF(cpf);
//		setLogin();
//		setSenha();
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		// TODO
		CPF = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin() {
		char space = 32;
		String nomeUsuario = this.nome.replace(space, '.').toLowerCase();
		String sobrenomeUsuario = this.sobrenome.toLowerCase();
		String login = String.join(".", nomeUsuario, sobrenomeUsuario);

		/**
		 * Se existir um usuario com o mesmo login que outro usuario adicionar um valor
		 * inteiro no final
		 */

		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha() {
		this.senha = "JNFGADKJFGNAIDJEFNG";/** SENHA_RANDOMICA - 15 CARACTERES */
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo() {
		this.ativo = true;
	}

	public void setInativo() {
		this.ativo = false;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the perfilAcesso
	 */
	public long getPerfilAcesso() {
		return perfilAcesso;
	}
	
//	public String getPerfilAcessoDescricao() {
//		String descricaoPerfilAcesso = "";
//		switch ((int)this.perfilAcesso){
//		case 1:
//			descricaoPerfilAcesso = "Administrador Secretaria Executiva";
//		case 2:
//			descricaoPerfilAcesso = "Secretaria(o) Executiva(o)";
//		case 3:
//			descricaoPerfilAcesso = "Avaliador CT-PG";
//		}
//		return descricaoPerfilAcesso;
//	}

	/**
	 * @param perfilAcesso the perfilAcesso to set
	 */
	public void setPerfilAcesso(long perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", sobrenome=" + sobrenome + ", CPF=" + CPF + ", dataNascimento="
				+ dataNascimento + ", email=" + email + ", login=" + login + ", senha=" + senha + "]";
	}
}
