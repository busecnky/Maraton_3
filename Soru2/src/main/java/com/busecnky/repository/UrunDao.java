package com.busecnky.repository;



import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.busecnky.entity.Urun;

public class UrunDao implements ICrud<Urun> {

		@Override
		public void save(Urun t) {
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
		public void update(Urun urun) {
			Session session = null;
			try {
			
				if (urun != null) {
					
					session = dataBaseConnectionHibernate();
					session.getTransaction().begin();
					session.merge(urun);
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
				Urun urun = findById(id);
				if (urun != null) {

					transaction = session.beginTransaction();
					session.delete(urun);
					transaction.commit();
					System.out.println("Urun silindi---> " + urun.getUrunAdi());
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
		public List<Urun> findAll() {
			Transaction transaction = null;
			List<Urun> uruns = null;
			try (Session session = dataBaseConnectionHibernate()) {
				transaction = session.beginTransaction();
				uruns = session.createQuery("from Urun", Urun.class).list();
				transaction.commit();

			}
			return uruns;
		}
		
	
		@Override
		public Urun findById(long id) {

			Session session = dataBaseConnectionHibernate();

			Urun urun;

			try {
				urun = session.find(Urun.class, id);
				if (urun != null) {
					System.out.println("Urun bulundu -->" + urun);
					return urun;
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
