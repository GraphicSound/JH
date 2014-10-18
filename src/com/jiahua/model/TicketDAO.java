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
 * Ticket entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Ticket
 * @author MyEclipse Persistence Tools
 */

@Repository
@Transactional
public class TicketDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TicketDAO.class);
	// property constants
	public static final String DESC = "desc";
	public static final String AMOUNT = "amount";
	public static final String BALANCE = "balance";
	public static final String PRICE = "price";
	public static final String STATUS = "status";

	public void save(Ticket transientInstance) {
		log.debug("saving Ticket instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ticket persistentInstance) {
		log.debug("deleting Ticket instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ticket findById(Integer id) {
		log.debug("getting Ticket instance with id: " + id);
		try {
			Ticket instance = (Ticket) getSession().get(
					"com.com.jiahua.model.Ticket", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ticket instance) {
		log.debug("finding Ticket instance by example");
		try {
			List results = getSession()
					.createCriteria("com.com.jiahua.model.Ticket")
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
		log.debug("finding Ticket instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ticket as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDesc(Object desc) {
		return findByProperty(DESC, desc);
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

	public List findAll() {
		log.debug("finding all Ticket instances");
		try {
			String queryString = "from Ticket";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ticket merge(Ticket detachedInstance) {
		log.debug("merging Ticket instance");
		try {
			Ticket result = (Ticket) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ticket instance) {
		log.debug("attaching dirty Ticket instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ticket instance) {
		log.debug("attaching clean Ticket instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}