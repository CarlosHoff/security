package br.com.hoffmann.security.service;

import static java.lang.String.format;

import br.com.hoffmann.security.cripto.CriptografiaUtils;
import br.com.hoffmann.security.domain.request.UsuarioRequest;
import br.com.hoffmann.security.domain.response.UsuarioResponse;
import br.com.hoffmann.security.entity.UsuarioEntity;
import br.com.hoffmann.security.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "transactionManager")
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private CriptografiaUtils criptografiaUtils;

  public void cadastraUsuario(UsuarioRequest request) {
    UsuarioEntity usuarioEntity = new UsuarioEntity(request);
    usuarioEntity.setSenha(this.criptografiaUtils.encode(request.getSenha()));
    usuarioRepository.save(usuarioEntity);
  }

  public void deletaUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }

  public List<UsuarioResponse> buscaUsuarios() {
    List<UsuarioEntity> usuario = usuarioRepository.findAll();
    return usuario.stream().map(UsuarioResponse::new)
        .peek(user -> user.setSenha("**********")).collect(Collectors.toList());
  }

  public UsuarioResponse buscaUsuariosPeloID(Long id) throws NotFoundException {
    Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
    if (!usuario.isPresent()) {
      throw new NotFoundException(format("Usuario: [%s] não foi encontrado", id));
    }
    return new UsuarioResponse(usuario.get());
  }
}
