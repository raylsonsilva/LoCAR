package br.com.iw.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.iw.entity.ModeloCarro;
import br.com.iw.service.ModeloCarroService;

@FacesConverter("modeloCarroConverter")
public class ModeloCarroConverter implements Converter<Object> {
	
	@Inject
	private ModeloCarroService modeloCarroService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ModeloCarro retorno = null;

		if (StringUtils.isNotBlank(value)) {
			retorno = (ModeloCarro) this.modeloCarroService.buscarFabricantePorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((ModeloCarro) value).getId();
			return codigo == null ? null : codigo.toString();
		}
		return "";
	}
	
}
