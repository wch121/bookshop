package dao_.BadicDao_;

import dao_.Domain.Book;

import java.util.List;

public class BookDao extends BasicDao {


    public int addBook(Book book) {
        String sql = "insert into t_book(`name`, `price`, `author`, `sales`, `stock`, `img_path`) values(?, ?, ?, ?, ?, ?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path());

    }

    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);

    }

    /**
     * 这里实际上就是说我用一个同样id的书去代替我想修改的那本书，至于说想改哪些部分都可以，当然除了id
     * @param book
     * @return
     */
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?, `price`=?, `author`=?, `sales`=?, `stock`=?, `img_path`=? where id = ?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path(), book.getId());

    }
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`, `price`, `author`, `sales`, `stock`, `img_path` from t_book where `id` = ?";
        return (Book) querySingle(sql, Book.class, id);
    }
    public List<Book> queryBooks() {
        String sql = "select  `id`, `name`, `price`, `author`, `sales`, `stock`, `img_path` from t_book";
        return queryMulti(sql, Book.class);
    }


    public Integer queryPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number number = (Number) queryScalar(sql);
        return number.intValue();
    }

    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`, `name`, `price`, `author`, `sales`, `stock`, `img_path` from t_book limit ?, ?";
        return queryMulti(sql, Book.class, begin, pageSize);

    }

    public Integer queryPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where `price` between ? and ?";
        Number number = (Number) queryScalar(sql, min, max);
        return number.intValue();

    }

    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`, `name`, `price`, `author`, `sales`, `stock`, `img_path` from t_book where `price` between ? and ? order by `price` limit ?, ?";
        return queryMulti(sql, Book.class, min, max, begin, pageSize);
    }
}
