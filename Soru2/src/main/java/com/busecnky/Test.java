package com.busecnky;


import java.util.Arrays;


import com.busecnky.entity.Musteri;
import com.busecnky.entity.Siparis;
import com.busecnky.entity.SiparisKalemi;
import com.busecnky.entity.Urun;
import com.busecnky.service.MusteriService;
import com.busecnky.service.SiparisKalemiService;
import com.busecnky.service.SiparisService;
import com.busecnky.service.UrunService;

public class Test {

	public static void main(String[] args) {
		
		MusteriService musteriService = new MusteriService();
		UrunService urunService = new UrunService();
		SiparisService siparisService = new SiparisService();
		SiparisKalemiService siparisKalemiService = new SiparisKalemiService();
		
		
		Musteri m1 = new Musteri("Ali", "Kaya");
		Musteri m2 = new Musteri("Veli","Özkan");
		musteriService.save(m1);
		musteriService.save(m2);
	
		Urun u1 = new Urun ("Iphone 11", 17000);
		Urun u2 = new Urun ("Samsung S21", 18000) ;
		Urun u3 = new Urun ("LG LED TV", 8500);
		Urun u4 = new Urun ("Arçelik Süpürge", 2500);
		urunService.save(u1);
		urunService.save(u2);
		urunService.save(u3);
		urunService.save(u4);
		
		SiparisKalemi sk1 = new SiparisKalemi(u1,1);
		SiparisKalemi sk2 = new SiparisKalemi(u2,2);
		siparisKalemiService.save(sk1);
		siparisKalemiService.save(sk2);
		
		Siparis s1 = new Siparis(m1, Arrays.asList(sk1, sk2));
		siparisService.save(s1);
		
		SiparisKalemi sk3 = new SiparisKalemi(u2, 2) ;
		SiparisKalemi sk4 = new SiparisKalemi(u3, 1);
		siparisKalemiService.save(sk3);
		siparisKalemiService.save(sk4);
		
		Siparis s2 = new Siparis(m2, Arrays.asList (sk3, sk4)) ;
		siparisService.save(s2);
		
		SiparisKalemi sk5 = new SiparisKalemi (u4, 2);
		siparisKalemiService.save(sk5);
		
		Siparis s3 = new Siparis(m1, Arrays.asList (sk5));
		siparisService.save(s3);
		
		Siparis s4 = new Siparis(m2, Arrays.asList(new SiparisKalemi(u1,1)));
		Siparis s5 = new Siparis(m2, Arrays.asList (new SiparisKalemi(u2,1)));
		siparisService.save(s4);
		siparisService.save(s5);
		
		
		//SORU 2.A
		siparisService.siparisToplam();
		
		System.out.println("\n\n-----------------------------------------------------------------\n\n");
		
		//SORU 2.B
		
		musteriService.musteriUrunBilgileri();
		
		System.out.println("\n\n-----------------------------------------------------------------\n\n");
		
		//SORU 2.C
		
		siparisService.siparisGrupla();
		
		System.out.println("\n\n-----------------------------------------------------------------\n\n");
		
		//SORU 2.D
		
		siparisService.musteriBilgisi();
	}
}
