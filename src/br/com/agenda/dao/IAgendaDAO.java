package br.com.agenda.dao;

import java.util.List;

import br.com.agenda.model.Agenda;


/**
 * Interface do Usuario.
 * @author Alexsandro Pires.
 */
public interface IAgendaDAO {

	/**
	 * Insere um registro na tabela de Funcionario
	 * @param Objeto Funcionario .
	 * @return nao ha retorno a ser tratado
     * @throws Exception 
	 */	
	void insert(Agenda obj);
	
	/**
	 * Atualiza dados na tabela de Funcionarios
	 * @param Objeto Funcionario .
	 * @return nao ha retorno a ser tratado
     * @throws Exception 
	 */	
	void update(Agenda obj);

	/**
	 * Exclui um registro na tabela de Funcionario
	 * @param Id do Funcionario.
	 * @return nao ha retorno a ser tratado
     * @throws Exception 
	 */	
	void deleteById(Long id);
	
	/**
	 * Obtem um registro na tabela de Funcionario
	 * @param Id do Funcionario .
	 * @return O objeto Funcionario 
     * @throws Exception 
	 */	
	Agenda findById(Long id);
	
	/**
	 * Obtem todos os objetos gravados no arquivo em disco. 
	 * @param null.
	 * @return a lista de Funcionarios gravada no aquivo fisico.
     * @throws Exception 
	 */	
	List<Agenda> findAll();
	
}
