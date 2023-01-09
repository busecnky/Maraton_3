package com.busecnky.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.busecnky.entity.Musteri;
import com.busecnky.entity.Siparis;
import com.busecnky.entity.SiparisKalemi;
import com.busecnky.entity.Urun;


public class HibernateUtils {

	
	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	
	private static SessionFactory sessionFactoryHibernate() {
		

			try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Urun.class);
			configuration.addAnnotatedClass(Siparis.class);
			configuration.addAnnotatedClass(Musteri.class);
			configuration.addAnnotatedClass(SiparisKalemi.class);
		
			
			
			
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
			
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}	
		
		return null;
	}


	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	
			

}
