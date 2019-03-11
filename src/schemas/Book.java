package schemas;

import java.util.Objects;

public class Book {

    public enum ReadingDifficulty {
        ELEMENTARY_LEVEL,
        MIDDLE_SCHOOL_LEVEL,
        HIGH_SCHOOL_LEVEL,
        COLLEGE_LEVEL,
        GRADUATE_LEVEL,
        INCOMPREHENSIBLE
    }

    private String name;
    //popularity is rated by the number of books sold a day at peak of popularity
    //Uses the Amazon best seller rank
    private int popularityRank;
    /*
    Amazon Best Seller Rank 50,000 to 100,000 - selling close to 1 book a day. (13)

    Amazon Best Seller Rank 10,000 to 50,000 - selling 5 to 15 books a day. (12)

    Amazon Best Seller Rank 5,500 to 10,000 - selling 15 to 25 books a day. (11)

    Amazon Best Seller Rank 3,000 to 5,500 - selling 25 to 70 books a day. (10)

    Amazon Best Seller Rank 1,500 to 3,000 - selling 70 to 100 books a day. (9)

    Amazon Best Seller Rank 750 to 1,500 - selling 100 to 120 books a day. (8)

    Amazon Best Seller Rank 500 to 750 - selling 120 to 175 books a day. (7)

    Amazon Best Seller Rank 350 to 500 - selling 175 to 200 books a day. (6)

    Amazon Best Seller Rank 200 to 350 - selling 200 to 300 books a day. (5)

    Amazon Best Seller Rank 35 to 200 - selling 300 to 1,000 books a day. (4)

    Amazon Best Seller Rank 20 to 35 - selling 1,000 to 2,000 books a day. (3)

    Amazon Best Seller Rank of 5 to 20 - selling 2,000 to 3,000 books a day. (2)

    Amazon Best Seller Rank of 1 to 5 - selling 3,000+ books a day. (1)
     */
    private int wordLength;
    private ReadingDifficulty readingDifficulty;

    public Book(String name, int popularityRank, int wordLength, ReadingDifficulty readingDifficulty) {
        this.name = name;
        this.popularityRank = popularityRank;
        this.wordLength = wordLength;
        this.readingDifficulty = readingDifficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularityRank() {
        return popularityRank;
    }

    public void setPopularityRank(int popularityRank) {
        this.popularityRank = popularityRank;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public ReadingDifficulty getReadingDifficulty() {
        return readingDifficulty;
    }

    public void setReadingDifficulty(ReadingDifficulty readingDifficulty) {
        this.readingDifficulty = readingDifficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getName().toLowerCase(), book.getName().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPopularityRank(), getWordLength(), getReadingDifficulty());
    }
}
