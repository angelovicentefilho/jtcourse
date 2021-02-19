package br.com.jt.commons.validator;

import java.util.Optional;

public interface JtValidator<T> {

	 T has(Optional<T> obj);
	
}
