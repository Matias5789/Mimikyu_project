package com.JavaProject.Mimikyu_project.Model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class UsuarioDAO {
    	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome,sobren,email)" +
	                 " VALUES (?,?,?)";
		Object[] obj = new Object[3];
		//primeiro ?
		obj[0] = usuario.getNome();
		//segundo ?
		obj[1] = usuario.getSobren();
        //terceiro ?
        obj[2] = usuario.getEmail();
		jdbc.update(sql, obj);
	}

    public List<Map<String, Object>> listarUsuario() {
    	String sql = "SELECT * FROM usuarios";
    	return jdbc.queryForList(sql);
    }

	//Lista de 1
	public List<Map<String,Object>> obterUsuario(int id){
		String sql = "SELECT * FROM usuarios where id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForList(sql, obj);
	}

	public void atualizarUsuario(int id, Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, sobren = ?, email = ? WHERE id = ?";
        Object[] obj = new Object[4];
		//primeiro ?
		obj[0] = usuario.getNome();
		//segundo ?
		obj[1] = usuario.getSobren();
        //terceiro ?
        obj[2] = usuario.getEmail();
		//quarto ?
		obj[3] = id;
		jdbc.update(sql, obj);
    }

	public void apagarUsuario(int id){
		String sql = "DELETE FROM usuarios WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}

}
