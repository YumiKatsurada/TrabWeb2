/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.SistemaMedico.views;

import br.ufscar.dc.SistemaMedico.beans.Paciente;
import br.ufscar.dc.SistemaMedico.dao.PacienteDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;

/**
 *
 * @author Noteuser
 */

@Named
@SessionScoped
public class Autenticacao implements Serializable{
    //String login, senha;
    
    public String admin(String login, String senha){
        if(login.equals("admin") && senha.equals("admin")){
            return "medicoForm";
        }else{
            return "index";
        }
    }
    
    public String adminPaciente(String login, String senha){
        if(login.equals("admin") && senha.equals("admin")){
            return "pacienteForm";
        }else{
            return "index";
        }
    }
    
    List<Paciente> listaPacientes;
    @Inject PacienteDAO pacienteDAO;

     
    public String autenticaPaciente(String login, String senha)  throws SQLException, NamingException {
        if(pacienteDAO.buscarPaciente(login, senha)!= null){
            return "escolhaPaciente";
        }
        else{
            return "index";
        }
        
    }
    
    public String autenticaPacienteAgenda(String login, String senha)  throws SQLException, NamingException {
        if(pacienteDAO.buscarPaciente(login, senha)!= null){
            return "consultaForm";
        }
        else{
            return "index";
        }
        
    }
   
    
    
    
    
}
