package br.com.hoffmann.security.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.hoffmann.security.domain.request.UsuarioRequest;
import br.com.hoffmann.security.domain.response.UsuarioResponse;
import br.com.hoffmann.security.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javassist.NotFoundException;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "API - Cadastro de usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = "/v1/security")
public class UsuarioController {

  @Autowired
  private UsuarioService service;

  @ApiOperation(value = "Cadastro de Usuarios", nickname = "cadastraUsuario")
  @PostMapping(value = "/cadastraUsuario", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<UsuarioResponse> cadastraUsuario(@RequestBody UsuarioRequest request) {
    service.cadastraUsuario(request);
    return new ResponseEntity<>(CREATED);
  }

  @ApiOperation(value = "Exclusão de Usuarios", nickname = "deletaUsuario")
  @DeleteMapping(value = "/deletaUsuario/{id}")
  public void deletaUsuario(
      @PathVariable(value = "id") @NotNull Long id) {
    service.deletaUsuario(id);
  }

  @ApiOperation(value = "Busca de Usuarios", nickname = "buscaUsuarios")
  @GetMapping(value = "/buscaUsuarios", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<UsuarioResponse>> buscaUsuarios() {
    List<UsuarioResponse> response = service.buscaUsuarios();
    return ResponseEntity.ok().body(response);
  }

  @ApiOperation(value = "Busca de Usuarios pelo ID", nickname = "buscaUsuariosPeloID")
  @GetMapping(value = "/buscaUsuariosPeloID", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<UsuarioResponse> buscaUsuariosPeloID(
      @RequestParam(value = "id") Long id) throws NotFoundException {
    UsuarioResponse response = service.buscaUsuariosPeloID(id);
    return ResponseEntity.ok().body(response);
  }
}
