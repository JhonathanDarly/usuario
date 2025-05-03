package com.gestaotamias.usuario.infrastructure.security;

import com.gestaotamias.usuario.infrastructure.entity.Membro;
import com.gestaotamias.usuario.infrastructure.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Repositório para acessar dados de usuário no banco de dados
    @Autowired
    private MembroRepository membroRepository;

    // Implementação do método para carregar detalhes do usuário pelo login
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // Busca o usuário no banco de dados pelo e-mail
        Membro membro = membroRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));

        // Cria e retorna um objeto UserDetails com base no usuário encontrado
        return org.springframework.security.core.userdetails.User
                .withUsername(membro.getLogin()) // Define o nome de usuário como o login
                .password(membro.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
