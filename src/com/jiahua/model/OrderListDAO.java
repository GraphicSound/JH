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
 * OrderList entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see OrderList
 * @author MyEclipse Persistence Tools
 */

@Repository
@Transactional
public class OrderListDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderListDAO.class);
	// property constants
	public static final String PRICE = "price";
	public static final String QUANTITY = "quantity";
	public static final String AMOUNT = "amount";
	public static final String ARRANGEMENT_ID = "arrangementId";
	public static final String ORDERS_ID = "ordersId";
	public static final String STATUS = "status";

	public void save(OrderList transientInstance) {
		log.debug("saving OrderList instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderList persistentInstance) {
		log.debug("deleting OrderList instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderList findById(Integer id) {
		log.debug("getting OrderList instance with id: " + id);
		try {
			OrderList instance = (OrderList) getSession().get(
					"com.com.jiahua.model.OrderList", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrderList instance) {
		log.debug("finding OrderList instance by example");
		try {
			List results = getSession()
					.createCriteria("com.com.jiahua.model.OrderList")
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
		log.debug("finding OrderList instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrderList as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findByArrangementId(Object arrangementId) {
		return findByProperty(ARRANGEMENT_ID, arrangementId);
	}

	public List findByOrdersId(Object ordersId) {
		return findByProperty(ORDERS_ID, ordersId);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all OrderList instances");
		try {
			String queryString = "from OrderList";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrderList merge(OrderList detachedInstance) {
		log.debug("merging OrderList instance");
		try {
			OrderList result = (OrderList) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderList instance) {
		log.debug("attaching dirty OrderList instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderList instance) {
		log.debug("attaching clean OrderList instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}