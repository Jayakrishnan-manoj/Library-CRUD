package com.example.librarycrud.repository

import com.example.librarycrud.room.BookEntity
import com.example.librarycrud.room.BooksDB

class Repository(val booksDB: BooksDB) {
    suspend fun addBookToRoom(bookEntity: BookEntity) {
        booksDB.bookDao().addBook(bookEntity)
    }

    fun getAllBooks() = booksDB.bookDao().getAllBooks()

    suspend fun deleteBookFromRoom(bookEntity: BookEntity){
        booksDB.bookDao().deleteBook(bookEntity)
    }
}