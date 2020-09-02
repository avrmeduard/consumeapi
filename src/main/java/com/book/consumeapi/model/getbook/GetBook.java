package com.book.consumeapi.model.getbook;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookId",
        "title",
        "author",
        "publisher",
        "isbn",
        "numberOfPages",
        "language",
        "genre"
})


public class GetBook {

    /**
     * Book id.
     *
     */
    @JsonProperty("bookId")
    @JsonPropertyDescription(" Book id.")
    private Integer bookId;

    /**
     * Name of the book.
     *
     */
    @JsonProperty("title")
    @JsonPropertyDescription(" Book title.")
    private String title;

    /**
     * Author of the book.
     *
     */
    @JsonProperty("author")
    @JsonPropertyDescription(" Book author.")
    private String author;

    /**
     * Publisher of the book.
     *
     */
    @JsonProperty("publisher")
    @JsonPropertyDescription(" Book publisher.")
    private String publisher;

    /**
     * ISBN of the book.
     *
     */
    @JsonProperty("isbn")
    @JsonPropertyDescription(" Book isbn.")
    private String isbn;

    /**
     * Number of pages from the book.
     *
     */
    @JsonProperty("numberOfPages")
    @JsonPropertyDescription(" Book number of pages.")
    @JsonIgnore
    private Integer numberOfPages;

    /**
     * Language of the book.
     *
     */
    @JsonProperty("language")
    @JsonPropertyDescription(" Book language.")
    private String language;

    /**
     * Genre of the book.
     *
     */
    @JsonProperty("genre")
    @JsonPropertyDescription(" Book genre.")
    private String genre;


    /**
     * Book id.
     *
     */
    @JsonProperty("bookId")
    public Integer getBookId() {
        return bookId;
    }

    /**
     * Book id.
     *
     */
    @JsonProperty("bookId")
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * Name of the book.
     *
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Name of the book.
     *
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Author of the book.
     *
     */
    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    /**
     * Author of the book.
     *
     */
    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Publisher of the book.
     *
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     * Publisher of the book.
     *
     */
    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * ISBN of the book.
     *
     */
    @JsonProperty("isbn")
    public String getIsbn() {
        return isbn;
    }

    /**
     * ISBN of the book.
     *
     */
    @JsonProperty("isbn")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Number of pages from the book.
     *
     */
    @JsonProperty("numberOfPages")
    @JsonIgnore
    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Number of pages from the book.
     *
     */
    @JsonProperty("numberOfPages")
    @JsonIgnore
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Language of the book.
     *
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * Language of the book.
     *
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Genre of the book.
     *
     */
    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    /**
     * Genre of the book.
     *
     */
    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "GetBook{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
