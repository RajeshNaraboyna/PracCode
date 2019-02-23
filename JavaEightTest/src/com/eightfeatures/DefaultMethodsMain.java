package com.eightfeatures;

public class DefaultMethodsMain {

	public static void main(String[] args) {

	}

	class Book {

	}

	interface BookShelf {
		default <T> T getBook() {
			return null;
		}

		public static void insertBook(Book book) {

		}
	}

}
