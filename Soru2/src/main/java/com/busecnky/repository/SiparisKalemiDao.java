package com.busecnky.repository;



import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.busecnky.entity.SiparisKalemi;

public class SiparisKalemiDao implements ICrud<SiparisKalemi> {

		@Override
		public void save(SiparisKalemi t) {
			Transaction transaction = null;

			try (Session session = dataBaseConnectionHibernate()) {

				transaction = session.beginTransaction();
				session.save(t);
				transaction.commit();
				session.close();

			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();

				}
				System.out.println("Saved Error");
			}

		}

		@Override
		public void update(SiparisKalemi siparisKalemi) {
			Session session = null;
			try {
			
				if (siparisKalemi != null) {
					
					session = dataBaseConnectionHibernate();
					session.getTransaction().begin();
					session.merge(siparisKalemi);
					session.getTransaction().commit();
					System.out.println("Kullanıcı güncellendi");
				}
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}

		@Override
		public void delete(long id) {

			Transaction transaction = null;

			try (Session session = dataBaseConnectionHibernate()) {
				SiparisKalemi siparisKalemi = findById(id);
				if (siparisKalemi != null) {

					transaction = session.beginTransaction();
					session.delete(siparisKalemi);
					transaction.commit();
					System.out.println("SiparisKalemi silindi---> " + siparisKalemi.getId());
				} else {
					System.out.println("ID ye ait kullanıcı bulunamadı");
				}

			} catch (Exception e) {
				e.printStackTrace();
				if (transaction != null) {
					transaction.rollback();
				}
			}

		}

		@Override
		public List<SiparisKalemi> findAll() {
			Transaction transaction = null;
			List<SiparisKalemi> siparisKalemis = null;
			try (Session session = dataBaseConnectionHibernate()) {
				transaction = session.beginTransaction();
				siparisKalemis = session.createQuery("from SiparisKalemi", SiparisKalemi.class).list();
				transaction.commit();


			}
			return siparisKalemis;
		}
		


		@Override
		public SiparisKalemi findById(long id) {

			Session session = dataBaseConnectionHibernate();

			SiparisKalemi siparisKalemi;

			try {
				siparisKalemi = session.find(SiparisKalemi.class, id);
				if (siparisKalemi != null) {
					System.out.println("SiparisKalemi bulundu -->" + siparisKalemi);
					return siparisKalemi;
				} else {
					System.out.println("Id yi kontrol edin");
				}
			} catch (Exception e) {
				System.out.println("Something wrong");
			} finally {
				session.close();
			}

			return null;
		}

	

}
