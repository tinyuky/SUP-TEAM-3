package com.websystique.springsecurity.dao;

import java.util.ArrayList;
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

	
	@SuppressWarnings("unchecked")
	public List<Product> Search(String ten) {
		List<Object[]> websystiqueObjects = getSession().createSQLQuery("SELECT * FROM PRODUCT_PROFILE WHERE ten like '%"+ ten +"%'").list();
		List<Product> Diadiem = new ArrayList<Product>();
		for(Object[] websystiqueObject: websystiqueObjects) {
			Product diadiem = new Product();			
			String tenproduct = (String) websystiqueObject[1];
			String diachi = (String) websystiqueObject[2];
			int sdt = (Integer) websystiqueObject[3];
			Float gia1 = (Float) websystiqueObject[4];
			Float gia2 = (Float) websystiqueObject[5];
			String hinh = (String) websystiqueObject[6];
			diadiem.setTen(tenproduct);
			diadiem.setDiachi(diachi);
			diadiem.setSdt(sdt);
			diadiem.setGia1(gia1);
			diadiem.setGia2(gia2);
			diadiem.setHinh(hinh);
			Diadiem.add(diadiem);
		}
		System.out.println(Diadiem);
		return Diadiem;
	}
}
	


