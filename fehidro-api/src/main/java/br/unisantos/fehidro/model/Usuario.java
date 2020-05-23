package br.unisantos.fehidro.model;

import java.util.Date;
import java.util.Random;

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
		@NamedQuery(name = "Usuario.consultarPorCPF", query = "select u from Usuario u where u.CPF=?1"),
		@NamedQuery(name = "Usuario.consultarPorPerfilAcesso", query = "select u from Usuario u where u.perfilAcesso=?1") })
public class Usuario extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_usuario", length = 256)
	private String nome;

	@Column(name = "nm_sobrenome", length = 256)
	private String sobrenome;

	@Column(name = "nr_cpf", length = 256)
	private String CPF;

	@Column(name = "ds_email", length = 256)
	private String email;

	@Column(name = "ds_login", length = 256)
	private String login;

	@Column(name = "ds_senha", length = 256)
	private String senha;

	@Column(name = "ic_ativo", length = 50)
	private Boolean ativo;

	@Column(name = "nr_celular")
	private String celular;

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
		Random rnd = new Random();
		String chars  = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String senha = "";
		
		for(int i = 0; i < 6; i++) 
		{
			if (i % 2 == 0) 
			{
				senha += chars.charAt(rnd.nextInt(chars.length()));
			}
			else 
			{
				senha += Integer.toString(rnd.nextInt(10));
			}
		}
		
		this.senha = senha;
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
	public String getCelular() {
		return celular;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
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
		return "Usuario [nome=" + nome + ", sobrenome=" + sobrenome + ", CPF=" + CPF + 
				", email=" + email + ", login=" + login + ", senha=" + senha + "]";
	}
}
