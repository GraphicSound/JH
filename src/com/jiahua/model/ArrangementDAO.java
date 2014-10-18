package com.jiahua.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Arrangement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Arrangement
 * @author MyEclipse Persistence Tools
 */

@Repository
@Transactional
public class ArrangementDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ArrangementDAO.class);
	// property constants
	public static final String THEATER = "theater";
	public static final String AMOUNT = "amount";
	public static final String BALANCE = "balance";
	public static final String PRICE = "price";
	public static final String STATUS = "status";
	public static final String MOVIE_ID = "movieId";

	public void save(Arrangement transientInstance) {
		log.debug("saving Arrangement instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Arrangement persistentInstance) {
		log.debug("deleting Arrangement instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Arrangement findById(Integer id) {
		log.debug("getting Arrangement instance with id: " + id);
		try {
			Arrangement instance = (Arrangement) getSession().get(
					"com.com.jiahua.model.Arrangement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Arrangement instance) {
		log.debug("finding Arrangement instance by example");
		try {
			List results = getSession()
					.createCriteria("com.com.jiahua.model.Arrangement")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Arrangement instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Arrangement as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTheater(Object theater) {
		return findByProperty(THEATER, theater);
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findByBalance(Object balance) {
		return findByProperty(BALANCE, balance);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByMovieId(Object movieId) {
		return findByProperty(MOVIE_ID, movieId);
	}

	public List findAll() {
		log.debug("finding all Arrangement instances");
		try {
			String queryString = "from Arrangement";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Arrangement merge(Arrangement detachedInstance) {
		log.debug("merging Arrangement instance");
		try {
			Arrangement result = (Arrangement) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Arrangement instance) {
		log.debug("attaching dirty Arrangement instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Arrangement instance) {
		log.debug("attaching clean Arrangement instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}