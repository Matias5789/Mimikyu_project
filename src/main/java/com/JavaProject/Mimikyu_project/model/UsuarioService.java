package com.JavaProject.Mimikyu_project.Model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
	UsuarioDAO udao;
	
	public void inserirUsuario(Usuario usuario) {
		udao.inserirUsuario(usuario);
	}

    public List<Map<String, Object>> listarUsuario() {
		return udao.listarUsuario();
	}

	public void atualizarUsuario(int id, Usuario usu){
		udao.atualizarUsuario(id, usu);
	}

	public List<Map<String, Object>> obterUsuario(int id){
		return udao.obterUsuario(id);
	}

	public void apagarUsuario(int id){
		udao.apagarUsuario(id);
	}
}
