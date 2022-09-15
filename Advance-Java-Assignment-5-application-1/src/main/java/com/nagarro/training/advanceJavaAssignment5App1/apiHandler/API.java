package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

public class API {
	public static String GET_ALL_BOOKS_API = "http://localhost:8082/library/books/";
	public static String GET_BOOK_BY_ID_API = "http://localhost:8082/library/books/{id}";
	public static String ADD_BOOK_API = "http://localhost:8082/library/books/";
	public static String UPDATE_BOOK_API = "http://localhost:8082/library/books/{id}";
	public static String DELETE_BOOK_API = "http://localhost:8082/library/books/{id}";

	public static String GET_USER_BY_ID_API = "http://localhost:8082/user/{id}";
	
	public static String GET_AUTHORS_API = "http://localhost:8082/library/authors";

}
