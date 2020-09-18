package br.com.hoffmann.security.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@ApiModel(value = "UsuarioRequest")
public class UsuarioRequest implements Serializable {

  @ApiModelProperty(value = "Nome do Usuario")
  @NotNull
  private String nome;

  @ApiModelProperty(value = "Email")
  @NotNull
  @Email
  private String email;

  @ApiModelProperty(value = "Senha")
  @NotNull
  private String senha;

  @ApiModelProperty(value = "Rua")
  @NotNull
  private String rua;

  @ApiModelProperty(value = "Cidade")
  @NotNull
  private String cidade;

  @ApiModelProperty(value = "Bairro")
  @NotNull
  private String bairro;

  @ApiModelProperty(value = "Cep")
  @NotNull
  private String cep;

  @ApiModelProperty(value = "Estado")
  @NotNull
  private String estado;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
