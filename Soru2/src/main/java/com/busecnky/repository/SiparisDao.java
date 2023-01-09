package com.busecnky.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.busecnky.entity.Siparis;
import com.busecnky.entity.SiparisKalemi;


public class SiparisDao implements ICrud<Siparis> {
	
	
	public void siparisGrupla() {
		
		EntityManager entityManager = dataBaseConnectionHibernate();
        List<Object[]> list = entityManager.createNativeQuery("select musteri_id, count(*) from siparis group by musteri_id").getResultList();

        for (Object[] objects : list) {
			 System.out.println("Müşteri ID: "+ objects[0] +" Sipariş sayısı: "+ objects[1]);
		}
       
	}

	
	public void musteriBilgisi() {
		EntityManager entityManager = dataBaseConnectionHibernate();
        List<Object[]> list = entityManager.createNativeQuery("select musteri.isim, musteri.soyisim, siparis.id \n"
        		+ "from siparis \n"
        		+ "inner join musteri\n"
        		+ "on siparis.musteri_id = musteri.id").getResultList();

        for (Object[] objects : list) {
			 System.out.println("Müşteri Ad: "+ objects[0] + " Müşteri Soyad: "+ objects[1] + " Sipariş ID: "+ objects[2]);
		}
		
	}


		@Override
		public void save(Siparis t) {
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
		public void update(Siparis siparis) {
			Session session = null;
			try {
			
				if (siparis != null) {
					
					session = dataBaseConnectionHibernate();
					session.getTransaction().begin();
					session.merge(siparis);
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
				Siparis siparis = findById(id);
				if (siparis != null) {

					transaction = session.beginTransaction();
					session.delete(siparis);
					transaction.commit();
					System.out.println("Siparis silindi---> " + siparis.getId());
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
		public List<Siparis> findAll() {
			Transaction transaction = null;
			List<Siparis> sipariss = null;
			try (Session session = dataBaseConnectionHibernate()) {
				transaction = session.beginTransaction();
				sipariss = session.createQuery("from Siparis", Siparis.class).list();
				transaction.commit();

			}
			return sipariss;
		}
		

		@Override
		public Siparis findById(long id) {

			Session session = dataBaseConnectionHibernate();

			Siparis siparis;

			try {
				siparis = session.find(Siparis.class, id);
				if (siparis != null) {
					System.out.println("Siparis bulundu -->" + siparis);
					return siparis;
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

		public void siparisToplam() {
			List<Siparis> siparisList = findAll();

			for (Siparis s : siparisList) {
				System.out.println("Sipariş ID: " + s.getId() + "  Müşteri: " + s.getMusteri().getIsim() + " "
						+ s.getMusteri().getSoyisim());
				int siparisToplam = 0;
				for (SiparisKalemi skalemi : s.getSiparisKalemi()) {
					System.out.println(
							"\t Ürün: " + skalemi.getUrun().getUrunAdi() + " Fiyat: " + skalemi.getUrun().getUrunFiyati() 
										+ " Ürün: " + skalemi.getAdet());
					siparisToplam += skalemi.getUrun().getUrunFiyati()*skalemi.getAdet();

				}
				System.out.println("\tSipariş Toplamı: " + siparisToplam + "\n");

			}
			
		}


	

	

}
