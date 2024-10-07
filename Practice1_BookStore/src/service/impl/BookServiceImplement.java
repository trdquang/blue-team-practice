package service.impl;

import dto.BookDTO;
import entity.Author;
import entity.Book;
import mapper.BookMapper;
import model.BookModel;
import service.IBookService;
import util.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class BookServiceImplement implements IBookService {
    public String bookFilePath = "D:\\java_project\\blue-team-practice\\Practice1_BookStore\\src\\util\\book.txt";
    FileUtil fileUtil = new FileUtil();
    BookMapper bookMapper = new BookMapper();

    public BookServiceImplement() throws IOException {
    }

    @Override
    public List<BookDTO> getAll() throws IOException {
        if (fileUtil.readFileBuffer(bookFilePath).size() != 0 && fileUtil.readFileBuffer(bookFilePath).get(0) != null) {
            List<Book> bookList = fileUtil.readFileBuffer(bookFilePath).stream().map(x -> convertToEntity(x)).toList();
            return bookList.stream().map(x -> bookMapper.toDTO(x)).collect(Collectors.toList());
        } else {
            return new ArrayList<BookDTO>();
        }
    }

    @Override
    public void save(BookModel model) throws IOException {
        Book book = bookMapper.modelToEntity(model);
        int id = 0;
        if (fileUtil.readFileBuffer(bookFilePath).size()!=0 && fileUtil.readFileBuffer(bookFilePath).get(0)!=null) {
            id = fileUtil.readFileBuffer(bookFilePath).size() + 1;
            book.setId(String.valueOf(id));
            book.setAuthorIds(model.getAuthorIds());
            StringBuilder content = new StringBuilder(book.getId() + "," + book.getName() + "," + book.getQuantity());
            for (int i = 0; i < book.getAuthorIds().size(); i++) {
                content.append("," + book.getAuthorIds().stream().toList().get(i));
            }
            content.append("\n");
            fileUtil.writeFile("D:\\java_project\\blue-team-practice\\Practice1_BookStore\\src\\util\\book.txt", content.toString(), true);
        } else {
            id = 1;
            book.setId(String.valueOf(id));
            book.setAuthorIds(model.getAuthorIds());
            StringBuilder content = new StringBuilder(book.getId() + "," + book.getName() + "," + book.getQuantity());
            for (int i = 0; i < book.getAuthorIds().size(); i++) {
                content.append("," + book.getAuthorIds().stream().toList().get(i));
            }
            content.append("\n");
            fileUtil.writeFile("D:\\java_project\\blue-team-practice\\Practice1_BookStore\\src\\util\\book.txt", content.toString(), false);
        }
    }

    @Override
    public void edit(BookDTO bookDTO) throws IOException {
        List<BookDTO> bookDTOList = getAll();
        BookDTO sltBook = bookDTOList.stream().filter(x -> x.getId().equals(bookDTO.getId())).toList().get(0);
        sltBook.setName(bookDTO.getName());
        sltBook.setQuantity(bookDTO.getQuantity());
        sltBook.setAuthorIds(bookDTO.getAuthorIds());
        fileUtil.writeFile(bookFilePath, "", false);
        for (BookDTO dto : bookDTOList) {
            StringBuilder content = new StringBuilder(dto.getId() + "," + dto.getName() + "," + dto.getQuantity());
            for (int authorId : dto.getAuthorIds()) {
                content.append("," + authorId);
            }
            content.append("\n");
            fileUtil.writeFile(bookFilePath, content.toString(), true);
        }
    }

    @Override
    public void deleteById(String id) throws IOException {
        List<BookDTO> bookList = getAll();
        bookList.remove(bookList.stream().filter(x -> x.getId().equals(id)).toList().get(0));
        fileUtil.writeFile(bookFilePath, "", false);
        for (BookDTO dto : bookList) {
            StringBuilder content = new StringBuilder(dto.getId() + "," + dto.getName() + "," + dto.getQuantity());
            for (int authorId : dto.getAuthorIds()) {
                content.append("," + authorId);
            }
            content.append("\n");
            fileUtil.writeFile(bookFilePath, content.toString(), true);
        }
    }

    @Override
    public BookDTO findById(String id) throws IOException {
        if (fileUtil.readFileBuffer(bookFilePath).size() != 0 && !fileUtil.readFileBuffer(bookFilePath).get(0).equals("")) {
            return bookMapper.toDTO(fileUtil.readFileBuffer(bookFilePath).stream().map(x -> convertToEntity(x)).toList().get(0));
        } else {
            return null;
        }
    }

    @Override
    public List<BookDTO> getAllByAuthor(String authorId) throws IOException {
        List<BookDTO> books = new ArrayList<>();
        for (BookDTO book:getAll()){
            for (Integer auId: book.getAuthorIds()){
                if(auId==Integer.parseInt(authorId)){
                    books.add(book);
                    break;
                }
            }
        }
        return books;
    }

    public Book convertToEntity(String obj) {
        String[] content = obj.split(",");
        String id = new String();
        String name = new String();
        int quantity = 0;
        Set<Integer> authorIds = new HashSet<>();
        for (int i = 0; i < content.length; i++) {
            if (i == 0) {
                id = content[i];
            } else if (i == 1) {
                name = content[i];
            } else if (i == 2) {
                quantity = Integer.parseInt(content[i]);
            } else {
                authorIds.add(Integer.parseInt(content[i]));
            }
        }
        return new Book(id, name, quantity, authorIds);
    }
}
