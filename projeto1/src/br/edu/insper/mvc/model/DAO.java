package br.edu.insper.mvc.model;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
	private Connection connection = null;

	public DAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
		"jdbc:mysql://localhost/projeto1", "root", "123ana456");
		
	}

	public List<Atividades> getLista() throws SQLException {
		List<Atividades> atividades = new ArrayList<Atividades>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM quadro");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Atividades atividade = new Atividades();
			atividade.setId(rs.getInt("id"));
			atividade.setTarefa(rs.getString("atividades"));
			atividade.setTipo(rs.getString("tipo"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("tempo"));
			atividade.setDificuldade(rs.getDouble("dificuldade"));
			atividade.setTempo(data);
	
			atividades.add(atividade);
		}
		rs.close();
		stmt.close();
		return atividades;
	}
	
	public List<Cadastros> getLogin() throws SQLException {
		List<Cadastros> cadastros = new ArrayList<Cadastros>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM login");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Cadastros cadastro = new Cadastros();
			cadastro.setUsuario(rs.getString("usuario"));
			cadastro.setSenha(rs.getString("senha"));
			cadastros.add(cadastro);
		}
		rs.close();
		stmt.close();
		return cadastros;
	}
	
	public void adiciona(Atividades atividade) throws SQLException {
		String sql = "INSERT INTO quadro" + " (atividades,tipo,tempo,dificuldade) values(?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt = connection.prepareStatement(sql);
		stmt.setNString(1,atividade.getTarefa());
		stmt.setNString(2,atividade.getTipo());
		stmt.setDate(3,new java.sql.Date(atividade.getTempo().getTimeInMillis()));
		stmt.setDouble(4, atividade.getDificuldade());
		stmt.execute();
		stmt.close();
		
	}
	
	public List<Atividades> order(String option) throws SQLException{
		List<Atividades> atividades = new ArrayList<Atividades>();
		String sql = "SELECT * FROM quadro ORDER BY ";
		if (option.equals("1")){
			sql+="atividades";
		} else if (option.equals("2")){
			sql+="tempo";
		} else if (option.equals("3")){
			sql+="tipo";
		} else if (option.equals("4")){
			sql+="dificuldade";
			sql+=" DESC";
		} 

		
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Atividades atividade = new Atividades();
			atividade.setId(rs.getInt("id"));
			atividade.setTarefa(rs.getString("atividades"));
			atividade.setTipo(rs.getString("tipo"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("tempo"));
			atividade.setTempo(data);
			atividade.setDificuldade(rs.getDouble("dificuldade"));
			atividades.add(atividade);
		}
		rs.close();
		stmt.close();
		return atividades;
		
	}
	
	
	
	public void add(Cadastros cadastro) throws SQLException {
		String sql = "INSERT INTO login" + " (usuario,senha) values(?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt = connection.prepareStatement(sql);
		stmt.setNString(1,cadastro.getUsuario());
		stmt.setNString(2,cadastro.getSenha());
		stmt.execute();
		stmt.close();
	}
	
	public void atualiza(Atividades atividade) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE quadro SET atividades=?,tipo=? WHERE id=?");
		stmt.setNString(1, atividade.getTarefa());
		stmt.setNString(2,atividade.getTipo());
		stmt.setInt(3,atividade.getId());
		stmt.execute();
		stmt.close();
		
	}
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM quadro WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	
	public void close() throws SQLException {
		connection.close();
	}
}