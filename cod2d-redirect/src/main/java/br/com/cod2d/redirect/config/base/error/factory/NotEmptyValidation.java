package br.com.cod2d.redirect.config.base.error.factory;

import br.com.cod2d.redirect.config.base.error.ErrorDTO;
import br.com.cod2d.redirect.config.base.error.ErrorDTOFactory;
import org.springframework.validation.FieldError;


public class NotEmptyValidation implements HandleValidationType {

	@Override
	public ErrorDTO create(final FieldError fieldError) {
		return ErrorDTOFactory.getMissingParameter("value", fieldError.getField());
	}

}
