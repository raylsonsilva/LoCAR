package br.com.iw.view;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ViewsRouter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String home = "Home";
	private String cadastroLancamento = "CadastroLancamento";
	private String consultaLancamento = "ConsultaLancamento";
	private String editarLancamento = "EditarLancamento";
	
	public String getEditarLancamento() {
		return editarLancamento;
	}

	public String getHome() {
		return home;
	}
	
	public String getCadastroLancamento() {
		return cadastroLancamento;
	}
	
	public String getConsultaLancamento() {
		return consultaLancamento;
	}

}
