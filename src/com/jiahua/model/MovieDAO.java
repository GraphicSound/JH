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
 * A data access object (DAO) providing persistence and search support for Movie
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see Movie
 * @author MyEclipse Persistence Tools
 */

@Repository
@Transactional
public class MovieDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MovieDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String DESC = "desc";
	public static final String DURATION = "duration";
	public static final String STATUS = "status";

	public void save(Movie transientInstance) {
		log.debug("saving Movie instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Movie persistentInstance) {
		log.debug("deleting Movie instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movie findById(Integer id) {
		log.debug("getting Movie instance with id: " + id);
		try {
			Movie instance = (Movie) getSession().get("com.com.jiahua.model.Movie",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Movie instance) {
		log.debug("finding Movie instance by example");
		try {
			List results = getSession()
					.createCriteria("com.com.jiahua.model.Movie")
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
		log.debug("finding Movie instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Movie as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByDesc(Object desc) {
		return findByProperty(DESC, desc);
	}

	public List findByDuration(Object duration) {
		return findByProperty(DURATION, duration);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Movie instances");
		try {
			String queryString = "from Movie";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Movie merge(Movie detachedInstance) {
		log.debug("merging Movie instance");
		try {
			Movie result = (Movie) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movie instance) {
		log.debug("attaching dirty Movie instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movie instance) {
		log.debug("attaching clean Movie instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}