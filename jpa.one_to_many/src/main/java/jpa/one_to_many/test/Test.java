package jpa.one_to_many.test;

import java.util.Date;
import javax.persistence.*;
import jpa.one_to_many.model.*;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnitName");
		EntityManager manager = factory.createEntityManager();
		
		@SuppressWarnings("deprecation")
		Ogrenci ogrenci = new Ogrenci("Ali","Veli",Cinsiyet.ERKEK, 
				new Date(100,02,01));
		
		OgrenciKimlik kimlik = new OgrenciKimlik("A123456789",
				new Date(122,01,01));
		
		ogrenci.setKimlik(kimlik);
		
		Adres adres = new Adres("123","456","XXX","YYY","ZZZ");
	
		ogrenci.getAdresler().add(adres);
		// adresin de hangi öğrenciye ait olduğunu 
		// bildirmezsek adresler tablosunda ogrenciid null gelir. 
		adres.setOgrenci(ogrenci);
		
		manager.getTransaction().begin();
		//manager.persist(adres);
		//manager.persist(kimlik);
		manager.persist(ogrenci);
		
		manager.getTransaction().commit();
		
		System.out.println(ogrenci);
		
	}
}
