package de.shop.bestellverwaltung.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.util.AbstractDao;
import de.shop.util.Log;

@Log
public class BestellungDao extends AbstractDao<Bestellung, Long> {
	private static final long serialVersionUID = -6739243612185905236L;

	public List<Bestellung> findBestellungenByIds(List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return null;
		}
		
		// SELECT b
		// FROM   Bestellung b LEFT JOIN FETCH b.lieferungen
		// WHERE  b.id = <id> OR ...

		final EntityManager em = getEntityManager();
		final CriteriaBuilder builder = em.getCriteriaBuilder();
		final CriteriaQuery<Bestellung> criteriaQuery  = builder.createQuery(Bestellung.class);
		final Root<Bestellung> b = criteriaQuery.from(Bestellung.class);
		b.fetch("versand", JoinType.LEFT);
		
		// Die Vergleichen mit "=" als Liste aufbauen
		final Path<Long> idPath = b.get("id");
		final List<Predicate> predList = new ArrayList<>();
		for (Long id : ids) {
			final Predicate equal = builder.equal(idPath, id);
			predList.add(equal);
		}
		// Die Vergleiche mit "=" durch "or" verknuepfen
		final Predicate[] predArray = new Predicate[predList.size()];
		final Predicate pred = builder.or(predList.toArray(predArray));
		criteriaQuery.where(pred).distinct(true);

		final TypedQuery<Bestellung> query = em.createQuery(criteriaQuery);
		final List<Bestellung> bestellungen = query.getResultList();
		return bestellungen;
	}
}