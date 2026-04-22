-- ENUM types
CREATE TYPE borrow_status AS ENUM ('borrowed', 'returned', 'late');
CREATE TYPE payment_status AS ENUM ('paid', 'unpaid');

-- Categories
CREATE TABLE categories (
    id UUID PRIMARY KEY,
    name VARCHAR(255)
);

-- Authors
CREATE TABLE authors (
    id UUID PRIMARY KEY,
    name VARCHAR(255)
);

-- Publishers
CREATE TABLE publishers (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(50)
);

-- Users
CREATE TABLE users (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    job VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(50)
);

-- Officers
CREATE TABLE officers (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(50)
);

-- Books
CREATE TABLE books (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    category_id UUID,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- Many-to-Many: AuthorBook
CREATE TABLE author_book (
    book_id UUID,
    author_id UUID,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

-- Book Copies
CREATE TABLE book_copies (
    id UUID PRIMARY KEY,
    book_id UUID,
    year_published TIMESTAMP,
    publisher_id UUID,
    page_count INT,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (publisher_id) REFERENCES publishers(id)
);

-- Borrows
CREATE TABLE borrows (
    id UUID PRIMARY KEY,
    user_id UUID,
    book_copy_id UUID,
    borrow_date TIMESTAMP,
    due_date TIMESTAMP,
    return_date TIMESTAMP,
    officer_issued UUID,
    officer_received UUID,
    status borrow_status,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_copy_id) REFERENCES book_copies(id),
    FOREIGN KEY (officer_issued) REFERENCES officers(id),
    FOREIGN KEY (officer_received) REFERENCES officers(id)
);

-- Fines
CREATE TABLE fines (
    id UUID PRIMARY KEY,
    borrow_id UUID,
    user_id UUID,
    payment_status payment_status,
    paid_date TIMESTAMP,
    FOREIGN KEY (borrow_id) REFERENCES borrows(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);


-- Categories
INSERT INTO categories VALUES ('c1', 'Science');
INSERT INTO categories VALUES ('c2', 'History');
UPDATE categories SET name = 'Natural Science' WHERE id = 'c1';
DELETE FROM categories WHERE id = 'c2';
INSERT INTO categories VALUES ('c3', 'Technology');


-- Authors
INSERT INTO authors VALUES ('a1', 'Isaac Newton');
INSERT INTO authors VALUES ('a2', 'George Orwell');
UPDATE authors SET name = 'I. Newton' WHERE id = 'a1';
DELETE FROM authors WHERE id = 'a2';
INSERT INTO authors VALUES ('a3', 'Plato');


-- Publishers
INSERT INTO publishers VALUES ('p1', 'Oxford', 'UK', '111');
INSERT INTO publishers VALUES ('p2', 'MIT Press', 'USA', '222');
UPDATE publishers SET phone = '999' WHERE id = 'p1';
DELETE FROM publishers WHERE id = 'p2';
INSERT INTO publishers VALUES ('p3', 'Springer', 'DE', '333');


-- Users
INSERT INTO users VALUES ('u1', 'Ali', 'Student', 'Istanbul', '555');
INSERT INTO users VALUES ('u2', 'Ayse', 'Engineer', 'Ankara', '556');
UPDATE users SET job = 'Researcher' WHERE id = 'u1';
DELETE FROM users WHERE id = 'u2';
INSERT INTO users VALUES ('u3', 'Mehmet', 'Teacher', 'Izmir', '557');


-- Officers
INSERT INTO officers VALUES ('o1', 'Officer1', 'Istanbul', '700');
INSERT INTO officers VALUES ('o2', 'Officer2', 'Ankara', '701');
UPDATE officers SET address = 'Updated Istanbul' WHERE id = 'o1';
DELETE FROM officers WHERE id = 'o2';
INSERT INTO officers VALUES ('o3', 'Officer3', 'Izmir', '702');


-- Books
INSERT INTO books VALUES ('b1', 'Book1', 'c1');
INSERT INTO books VALUES ('b2', 'Book2', 'c3');
UPDATE books SET name = 'Updated Book1' WHERE id = 'b1';
DELETE FROM books WHERE id = 'b2';
INSERT INTO books VALUES ('b3', 'Book3', 'c1');



-- AuthorBook
INSERT INTO author_book VALUES ('b1', 'a1');
INSERT INTO author_book VALUES ('b3', 'a3');
UPDATE author_book SET author_id = 'a3' WHERE book_id = 'b1';
DELETE FROM author_book WHERE book_id = 'b3';
INSERT INTO author_book VALUES ('b3', 'a1');


-- Book Copies
INSERT INTO book_copies VALUES ('bc1', 'b1', '2000-01-01', 'p1', 500);
INSERT INTO book_copies VALUES ('bc2', 'b3', '2010-01-01', 'p3', 300);
UPDATE book_copies SET page_count = 550 WHERE id = 'bc1';
DELETE FROM book_copies WHERE id = 'bc2';
INSERT INTO book_copies VALUES ('bc3', 'b1', '2020-01-01', 'p1', 600);



-- Borrows
INSERT INTO borrows VALUES 
('br1','u1','bc1','2026-01-01','2026-01-10',NULL,'o1',NULL,'borrowed');

INSERT INTO borrows VALUES 
('br2','u3','bc3','2026-02-01','2026-02-10',NULL,'o3',NULL,'borrowed');

UPDATE borrows SET status = 'returned' WHERE id = 'br1';
DELETE FROM borrows WHERE id = 'br2';

INSERT INTO borrows VALUES 
('br3','u1','bc3','2026-03-01','2026-03-10',NULL,'o1',NULL,'borrowed');



-- Fines
INSERT INTO fines VALUES ('f1','br1','u1','unpaid',NULL);
INSERT INTO fines VALUES ('f2','br3','u1','unpaid',NULL);
UPDATE fines SET payment_status = 'paid' WHERE id = 'f1';
DELETE FROM fines WHERE id = 'f2';
INSERT INTO fines VALUES ('f3','br3','u1','paid','2026-03-15');