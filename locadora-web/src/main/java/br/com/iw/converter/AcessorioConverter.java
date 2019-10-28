package br.com.iw.converter;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.iw.entity.Acessorio;
import br.com.iw.service.AcessorioService;

@Named
@ApplicationScoped
public class AcessorioConverter implements Converter<Object>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioService acessorioService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Acessorio retorno = null;

		if (StringUtils.isNotBlank(value)) {
			retorno = (Acessorio) this.acessorioService.buscarAcessorioPorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Acessorio) value).getId();
			return codigo.toString();
		}
		return null;
	}

}
