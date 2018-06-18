/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.SistemaMedico.views;

import br.ufscar.dc.SistemaMedico.beans.Medico;
import br.ufscar.dc.SistemaMedico.dao.MedicoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;

/**
 *
 * @author Noteuser
 */
@Named
@RequestScoped
public class ListaMedicos implements Serializable {
    List<Medico> listaMedicos;
    @Inject MedicoDAO medicoDAO;


    public List<Medico> getListaMedicos() {
        return listaMedicos;
    }
    
    public void setListaMedicos(List<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }
    
    public String verTodosMedicos() throws SQLException, NamingException {
        listaMedicos = medicoDAO.listarTodosMedicos();
        return "listaMedicos";
    }
    
     public String verTodosMedicos(String especialidade) throws SQLException, NamingException {
        listaMedicos = medicoDAO.listarMedicosPorEspecialidade(especialidade);
        return "listaMedicos";
    }
     
    public String recomecar() {
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       return "index?faces-redirect=true";
   }
     
    public String autentica(String login, String senha)  throws SQLException, NamingException {
        if(medicoDAO.buscarMedico(login, senha)!= null){
            return "escolhaMedico";
        }
        else{
            return "index";
        }
        
    }
}
