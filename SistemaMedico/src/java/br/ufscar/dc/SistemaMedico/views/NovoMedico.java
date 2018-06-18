package br.ufscar.dc.SistemaMedico.views;

import br.ufscar.dc.SistemaMedico.beans.Medico;
import br.ufscar.dc.SistemaMedico.dao.MedicoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.sql.DataSource;


@Named
@SessionScoped
public class NovoMedico implements Serializable {
   

	//@Resource(name = "jdbc/SistemaMedicoDBLocal")
	//DataSource dataSource;
    
	Medico dadosMedico;
	@Inject MedicoDAO medicoDao;


	public NovoMedico() {
            dadosMedico = new Medico();;
	}


        public Medico getDadosMedico() {
            return dadosMedico;
	}


	public void setDadosMedico(Medico dadosMedico) {
            this.dadosMedico = dadosMedico;
	}
        
    	public String recomecar() {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "index?faces-redirect=true";
        }

        public String gravarMedico() throws SQLException, NamingException {
            medicoDao.gravarMedico(dadosMedico);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Flash flash = facesContext.getExternalContext().getFlash();
            flash.setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Medico adicionado"));

            return recomecar();
        }
        
        
       

}
