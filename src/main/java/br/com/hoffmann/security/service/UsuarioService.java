package br.com.hoffmann.security.service;

import br.com.hoffmann.security.repository.UsuarioRepository;
import br.com.hoffmann.security.entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    UserDetails retorno = null;
    Optional<UsuarioEntity> entityExample = this.usuarioRepository
        .findOne(Example.of(UsuarioEntity.from(username)));
    if (entityExample.isPresent()) {
      UsuarioEntity usuarioEntity = entityExample.get();
      retorno = new User(usuarioEntity.getLogin(), usuarioEntity.getSenha(), new ArrayList<>());
      return retorno;
    }
    return retorno;
  }
}
