package br.com.hoffmann.security.domain.response;

import br.com.hoffmann.security.entity.UsuarioEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "UsuarioResponse")
public class UsuarioResponse implements Serializable {

  @ApiModelProperty(value = "idUsuario")
  private Long idUsuario;

  @ApiModelProperty(value = "nome")
  private String nome;

  @ApiModelProperty(value = "email")
  private String email;

  @ApiModelProperty(value = "senha")
  private String senha;

  @ApiModelProperty(value = "rua")
  private String rua;

  @ApiModelProperty(value = "cidade")
  private String cidade;

  @ApiModelProperty(value = "bairro")
  private String bairro;

  @ApiModelProperty(value = "cep")
  private String cep;

  @ApiModelProperty(value = "estado")
  private String estado;

  public UsuarioResponse() {
  }

  public UsuarioResponse(UsuarioEntity usuarioEntity) {
    this.idUsuario = usuarioEntity.getId();
    this.nome = usuarioEntity.getNome();
    this.email = usuarioEntity.getEmail();
    this.senha = usuarioEntity.getSenha();
    this.rua = usuarioEntity.getRua();
    this.cidade = usuarioEntity.getCidade();
    this.bairro = usuarioEntity.getBairro();
    this.cep = usuarioEntity.getCep();
    this.estado = usuarioEntity.getEstado();
  }

  public Long getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Long idUsuario) {
    this.idUsuario = idUsuario;
  }

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
