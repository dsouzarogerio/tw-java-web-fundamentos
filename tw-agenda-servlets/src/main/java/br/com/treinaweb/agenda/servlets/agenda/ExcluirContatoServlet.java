package br.com.treinaweb.agenda.servlets.agenda;

import java.io.IOException;
import java.sql.SQLException;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorios.impl.ContatoRepositorioJDBC;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/agenda/excluir"})
public class ExcluirContatoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1468519669640783161L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idContato = Integer.parseInt(req.getParameter("id"));
		Contato contatoExcluido = new Contato();
		contatoExcluido.setId(idContato);
		AgendaRepositorio<Contato> agendaRepositorio = new ContatoRepositorioJDBC();
		try {
			agendaRepositorio.excluir(contatoExcluido);
		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
		}
		
		resp.sendRedirect(req.getContextPath() + "/agenda/listar");
	}
	
	

}
