# 📚 Book Dataset Reader for SST's LLD Module

> Assignment Doc: https://docs.google.com/document/d/1oko7HD3GeD9KD0VYloPmB6JnkbXHHSYncXeWcATtiuo/edit?tab=t.0

> Dataset URL: https://www.kaggle.com/sootersaalu/amazon-top-50-bestselling-books-2009-2019

The program is written in Java and allows interactive exploration of the dataset through different tasks.

## 📂 Project Structure

```
.
├── data.csv                 # Dataset file (Amazon's Top 50 Bestselling Books 2009–2019)
├── run                      # Shell script to compile & run the project
└── bookreader/              # Source code
    ├── Book.java            # Book class (attributes + methods)
    ├── DatasetReader.java   # Reads CSV and creates Book objects
    ├── Driver.java          # Entry point of the program
    ├── helper/              # Helper classes (e.g., AuthorHelper)
    ├── io/                  # Input/Output bridge (Console handling)
    └── tasks/               # Different dataset tasks
```

## ⚙️ Features / Tasks

The program supports multiple dataset queries:

1. Total number of books by an author
  - Input: Author name
  - Output: Number of books written by that author
2. All authors in the dataset
  - Output: List of all unique authors
3. Names of all books by an author
  - Input: Author name
  - Output: Titles of books by that author
4. Classify by user rating
  - Input: Rating value (e.g., 4.7)
  - Output: List of books with that rating
5. Price of all books by an author
  - Input: Author name
  - Output: Book names with their prices
6. Print all books
  - Output: Prints every book’s details

## 🚀 How to Run

1. Clone/download the repository.
2. Ensure data.csv is present in the project directory.
3. Run using the provided script:

```sh
./run
```

or manually:

```sh
javac bookreader/Driver.java
java bookreader/Driver /path/to/data.csv
```

## 🗂 Dataset Info

- Name – Title of the book
- Author – Book’s author
- User Rating – Amazon user rating (3.3–4.9)
- Reviews – Number of reviews (37–87,800)
- Price – Price in USD ($0–$105)
- Year – Bestseller year (2009–2019)
- Genre – Fiction or Non-fiction

## 👨‍💻 Author

Developed by [AttAditya](https://github.com/AttAditya)

