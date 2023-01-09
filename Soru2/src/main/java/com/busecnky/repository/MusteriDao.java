package com.busecnky.repository;



import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.busecnky.entity.Musteri;

public class MusteriDao implements ICrud<Musteri> {

		@Override
		public void save(Musteri t) {
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
		public void update(Musteri musteri) {
			Session session = null;
			try {
			
				if (musteri != null) {
					
					session = dataBaseConnectionHibernate();
					session.getTransaction().begin();
					session.merge(musteri);
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
				Musteri musteri = findById(id);
				if (musteri != null) {

					transaction = session.beginTransaction();
					session.delete(musteri);
					transaction.commit();
					System.out.println("Musteri silindi---> " + musteri.getIsim());
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
		public List<Musteri> findAll() {
			Transaction transaction = null;
			List<Musteri> musteris = null;
			try (Session session = dataBaseConnectionHibernate()) {
				transaction = session.beginTransaction();
				musteris = session.createQuery("from Musteri", Musteri.class).list();
				transaction.commit();

			}
			return musteris;
		}
		
	

		@Override
		public Musteri findById(long id) {

			Session session = dataBaseConnectionHibernate();

			Musteri musteri;

			try {
				musteri = session.find(Musteri.class, id);
				if (musteri != null) {
					System.out.println("Musteri bulundu -->" + musteri);
					return musteri;
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
