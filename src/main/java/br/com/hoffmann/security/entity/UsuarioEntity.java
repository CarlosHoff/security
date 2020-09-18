package br.com.hoffmann.security.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "usuario")
public class UsuarioEntity {

  @Id
  @GeneratedValue
  private Long id;
  @Basic(optional = false)
  @Column(nullable = false)
  private String login;
  @Basic(optional = false)
  @Column(nullable = false)
  private String senha;

  private UsuarioEntity(String login) {
    this.login = login;
    id = null;
    senha = null;
  }

  public UsuarioEntity() {
  }

  public UsuarioEntity(Long id, String login, String senha) {
    this.id = id;
    this.login = login;
    this.senha = senha;
  }

  public static UsuarioEntity from(String login) {
    return new UsuarioEntity(login);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
