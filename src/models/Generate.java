package models;

import java.util.List;
import java.util.Random;

import entities.CategoryEntity;
import entities.ProductEntity;
import net.sf.ehcache.config.Searchable;

public class Generate {
	//GENERATE ID
	public static String generateId (int targetStringLength) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 57; // letter '9'
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		
		return generatedString;
	}
	
	
	//GENERATE AND CHECK RPODUCT ID
	public static ProductEntity searchProduct(List<ProductEntity> products, String id) {
		for (ProductEntity product : products) {
			if(product.getId().equals(id)) return product;
		}
		return null;
	}
	
	public static String generateProductId(List<ProductEntity> products) {
		String generatedString = null;
		do {
			generatedString = "P" + generateId(4);
		} while (searchProduct(products, generatedString) != null);
		
		return generatedString;
	}
	
	//GENERATE AND CHECK IMAGE ID
	public static String generateImageId(int targetStringLength) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 57; // letter '9'
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return "I" + generatedString;
	}
	
	//GENERATE AND CHECK CATEGORY ID
	public static CategoryEntity searchCategory(List<CategoryEntity> categories, String id) {
		for (CategoryEntity category : categories) {
			if(category.getId().equals(id)) return category;
		}
		return null;
	}
	
	public static String generateCategoryId(List<CategoryEntity> categories) {
		String generatedString = null;
		do {
			generatedString = "C" + generateId(4);
		} while (searchCategory(categories, generatedString) != null);
		
		return generatedString;
	}
}
