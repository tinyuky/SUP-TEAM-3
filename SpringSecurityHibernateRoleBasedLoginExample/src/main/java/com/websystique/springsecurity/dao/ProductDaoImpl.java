package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import com.websystique.springsecurity.dao.AbstractDao;

import com.websystique.springsecurity.model.Product;

@Repository
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	@SuppressWarnings("unchecked")
	public List<Product> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("ten"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.
		List<Product> users = criteria.list();

		// No need to fetch userProfiles since we are not showing them on list
		// page. Let them lazy load.
		// Uncomment below lines for eagerly fetching of userProfiles if you
		// want.
		/*
		 * for(User user : users){ Hibernate.initialize(user.getUserProfiles());
		 * }
		 */
		return users;
	}

	public void Add(Product product) {
		persist(product);
	}

	public void Delete(Integer id) {
		Query query = getSession().createSQLQuery("Delete from PRODUCT_PROFILE where Product_profile.id = " + id);
		query.executeUpdate();
	}

	public Product findById(int id) {
		return getByKey(id);
	}

}
