package br.ufscar.dc.SistemaMedico.views;

import br.ufscar.dc.SistemaMedico.beans.Consulta;
import br.ufscar.dc.SistemaMedico.dao.ConsultaDAO;
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
public class ListaConsultas implements Serializable {
	List<Consulta> listaConsultas;
	@Inject ConsultaDAO consultaDAO;


	public List<Consulta> getListaConsultas() {
    	return listaConsultas;
	}


	public void setListaConsultas (List<Consulta> listaConsultas) {
    	this.listaConsultas = listaConsultas;
	}
    
	public String verTodosConsultasPaciente (String _CPF) throws SQLException, NamingException {
            int CPF = Integer.parseInt(_CPF);
            listaConsultas = consultaDAO.listarTodasConsultasPorPaciente(CPF);
            return "listaConsultas";
	}
        
    	public String verTodosConsultasMedico (int CRM) throws SQLException, NamingException {
    	listaConsultas = consultaDAO.listarTodasConsultasPorMedico(CRM);
    	return "listaConsultas";
	}
        
        public String recomecar() {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "index?faces-redirect=true";
        }
}
