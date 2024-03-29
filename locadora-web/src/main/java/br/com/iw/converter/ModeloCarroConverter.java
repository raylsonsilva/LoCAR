package br.com.iw.converter;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.iw.entity.ModeloCarro;
import br.com.iw.service.ModeloCarroService;

@Named
@ApplicationScoped
public class ModeloCarroConverter implements Converter<Object>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModeloCarroService modeloCarroService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ModeloCarro retorno = null;

		if (StringUtils.isNotBlank(value)) {
			retorno = (ModeloCarro) this.modeloCarroService.buscarModeloPorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((ModeloCarro) value).getId();
			return codigo.toString();
		}
		return null;
	}

}
