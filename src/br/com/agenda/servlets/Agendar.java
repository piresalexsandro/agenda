package br.com.agenda.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.IAgendaDAO;
import br.com.agenda.dao.imp.AgendaDAOImp;
import br.com.agenda.model.Agenda;

@WebServlet("/agendar")
public class Agendar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		Long telefone = Long.parseLong(req.getParameter("telefone"));
		String logradouro = req.getParameter("rua");
		Integer numeroResidencia = Integer.parseInt(req.getParameter("numeroResidencia"));
		String bairro = req.getParameter("bairro");
		String cidade = req.getParameter("cidade");
		String estado = req.getParameter("estado");
		String uf = req.getParameter("uf");
		Long cep = Long.parseLong(req.getParameter("cep"));
		
		Agenda agenda = new Agenda();
		agenda.setNome(nome);
		agenda.setEmail(email);
		agenda.setTelefone(telefone);
		agenda.setLogradouro(logradouro);
		agenda.setNumeroResidencia(numeroResidencia);
		agenda.setBairro(bairro);
		agenda.setCidade(cidade);
		agenda.setEstado(estado);
		agenda.setUf(uf);
		agenda.setCep(cep);
        
		IAgendaDAO dao = new AgendaDAOImp();
		dao.insert(agenda);
		
		resp.sendRedirect("index.html");
	}	
}
