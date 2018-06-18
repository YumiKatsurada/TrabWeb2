package br.ufscar.dc.SistemaMedico.views;

import br.ufscar.dc.SistemaMedico.beans.Paciente;
import br.ufscar.dc.SistemaMedico.dao.PacienteDAO;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Named
@SessionScoped
public class NovoPaciente implements Serializable {


	Paciente dadosPaciente;
	@Inject PacienteDAO pacienteDao;

	public NovoPaciente() {
    	dadosPaciente = new Paciente();
	}

	
        public Paciente getDadosPaciente() {
            return dadosPaciente;
	}
        


	public void setDadosPaciente(Paciente dadosPaciente) {
    	this.dadosPaciente = dadosPaciente;
	}
        
    public String recomecar() {
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       return "index?faces-redirect=true";
   }

   public String gravarPaciente() throws SQLException, NamingException {
       pacienteDao.gravarPaciente(dadosPaciente);
       FacesContext facesContext = FacesContext.getCurrentInstance();
       Flash flash = facesContext.getExternalContext().getFlash();
       flash.setKeepMessages(true);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paciente adicionado"));

       return recomecar();
   }
}
