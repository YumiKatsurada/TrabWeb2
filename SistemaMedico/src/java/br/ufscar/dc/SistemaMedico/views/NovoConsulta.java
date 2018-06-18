package br.ufscar.dc.SistemaMedico.views;

import br.ufscar.dc.SistemaMedico.beans.Consulta;
import br.ufscar.dc.SistemaMedico.dao.ConsultaDAO;
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
public class NovoConsulta implements Serializable {


	
	Consulta dadosConsulta;
	@Inject ConsultaDAO consultaDao;

	public NovoConsulta() {
    	dadosConsulta = new Consulta();
	}

	
   public Consulta getDadosConsulta() {
    	return dadosConsulta;
	}


	public void setDadosConsulta(Consulta dadosConsulta) {
    	this.dadosConsulta = dadosConsulta;
	}
        
        public String recomecar() {
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       return "index?faces-redirect=true";
   }

   public String gravarConsulta() throws SQLException, NamingException {
       consultaDao.gravarConsulta(dadosConsulta);
       FacesContext facesContext = FacesContext.getCurrentInstance();
       Flash flash = facesContext.getExternalContext().getFlash();
       flash.setKeepMessages(true);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta adicionada"));

       return recomecar();
   }
}
