package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of products:");
		int n = sc.nextInt();
		List <Product> list = new ArrayList<>();
		
		for (int i =0; i<n;i++) {
			System.out.printf("Product #%d data\n", i+1);
			System.out.print("Name:");
			String name = sc.next();
			System.out.print("Price:");
			Double price = sc.nextDouble();
			System.out.print("Common, used or imported?(c/u/i)");
			char typeProduct = sc.next().charAt(0);
			if (typeProduct=='i') {
				System.out.print("Customs Fee:");
				Double customFee = sc.nextDouble();
				ImportedProduct product = new ImportedProduct(name, price, customFee);
				list.add(product);
			}
			if (typeProduct=='c') {
				Product product = new Product(name, price);
				list.add(product);
			}
			if (typeProduct=='u') {
				System.out.print("Manufactured Date:");
				String dateReceived = sc.next();
		        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		        Date dateFormatted = formato.parse(dateReceived);
				UsedProduct product = new UsedProduct(name,price,dateFormatted);
				list.add(product);
			}
		}
			System.out.println("PRICE TAGS");
			for (Product c : list) {
				System.out.println(c.priceTag());
			}
				
			
			
		}
	}


