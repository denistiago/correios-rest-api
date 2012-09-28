package com.denistiago.client.utils;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.denistiago.model.Endereco;


public class Books {
	
	@JsonProperty("bookList")
	private
	List<Endereco> books;

	public List<Endereco> getBooks() {
		return books;
	}

	public void setBooks(List<Endereco> books) {
		this.books = books;
	}
}
