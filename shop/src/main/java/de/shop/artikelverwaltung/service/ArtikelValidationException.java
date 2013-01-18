package de.shop.artikelverwaltung.service;

import java.util.Collection;

import javax.ejb.ApplicationException;
import javax.validation.ConstraintViolation;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.AbstractShopException;

@ApplicationException(rollback = true)
public class ArtikelValidationException extends AbstractShopException {
	private static final long serialVersionUID = 4255133082483647701L;
	private final Artikel artikel;
	private final Collection<ConstraintViolation<Artikel>> violations;
	
//	@Resource(lookup = "java:jboss/UserTransaction")
//	private UserTransaction trans;

	public ArtikelValidationException(Artikel artikel,
			                        Collection<ConstraintViolation<Artikel>> violations) {
		super("Ungueltiger Artikel: " + artikel + ", Violations: " + violations);
		this.artikel = artikel;
		this.violations = violations;
	}
	
//	@PostConstruct
//	private void setRollbackOnly() {
//		try {
//			if (trans.getStatus() == STATUS_ACTIVE) {
//				trans.setRollbackOnly();
//			}
//		}
//		catch (IllegalStateException | SystemException e) {
//			throw new InternalError(e);
//		}
//	}

	public Artikel getArtikel() {
		return artikel;
	}

	public Collection<ConstraintViolation<Artikel>> getViolations() {
		return violations;
	}
}

