#  Digital Library Book Management System

A **Java-based console application** that allows librarians to efficiently manage a digital library. It supports operations like adding, updating, viewing, searching, and deleting book records, along with tracking their availability status.

---

##  Features

-  Add books with **Book ID**, **Title**, **Author**, **Genre**, and **Availability Status**
-  View all books displayed in a neat **tabular format**
-  Search books by **Book ID** or **Title**
-  Update book details
-  Delete books from the system
-  Input validation for:
  - Unique Book ID
  - Non-empty Title and Author
  - Valid Availability Status (`Available` or `Checked Out`)
-  Graceful error handling for invalid inputs

---

##  How to Compile & Run

### Open Terminal and navigate to the `src` folder

```bash
cd src
javac com/library/*.java
java com.library.LibraryApp
```

##  Sample Output
```bash
### === Digital Library Book Management System ===
1. Add Book
2. View All Books
3. Search Book by ID
4. Search Book by Title
5. Update Book Details
6. Delete Book
7. Exit


Book ID   Title                Author               Genre           Status         
--------------------------------------------------------------------------------------------
1233       Effective Java       Kartik Naik         Programming     Available

```
