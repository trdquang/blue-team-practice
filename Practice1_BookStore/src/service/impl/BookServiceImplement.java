package service.impl;

import dto.AuthorDTO;
import dto.BookDTO;
import dto.UserDTO;
import entity.Author;
import entity.Book;
import mapper.BookMapper;
import model.BookModel;
import service.IBookService;
import util.FilePath;
import util.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class BookServiceImplement implements IBookService {
    public String bookFilePath = FilePath.BOOK_FILE_PATH;
    FileUtil fileUtil = new FileUtil();
    BookMapper bookMapper = new BookMapper();

    public BookServiceImplement() throws IOException {
    }

    @Override
    public List<BookDTO> getAll() throws IOException {
        List<BookDTO> bookDTOS = new ArrayList<>();
        try {
            List<String> res = FileUtil.readFileBuffer(bookFilePath);
            for (int i = 0; i < res.size(); i++) {
                if(!res.get(i).equals("")){
                String[] obj = res.get(i).split(",");
                String id = obj[0];
                String name = obj[1];
                int quantity = Integer.parseInt(obj[2].strip());
                Set<Integer> s = new HashSet<>();
                for (int j = 4; j < obj.length; j++) {
                    s.add(Integer.parseInt(obj[j].strip()));
                }
                int sell= Integer.parseInt(obj[3]);
                BookDTO bookTmp = new BookDTO(id, name, quantity, sell,s);
                bookDTOS.add(bookTmp);
                }
            }
            return bookDTOS;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public void save(BookModel model) throws IOException {
        Book newBook = bookMapper.modelToEntity(model);
        newBook.setId(String.valueOf(getAll().size()+1));
        StringBuilder content=new StringBuilder(newBook.getId() + "," + newBook.getName()+","+newBook.getQuantity());
        for (int authorId: newBook.getAuthorIds()){
            content.append(","+authorId);
        }
        content.append(0);
        fileUtil.writeFile(bookFilePath, content.toString()+"\n", true);
    }


    @Override
    public void edit(BookDTO bookDTO) throws IOException {
        List<BookDTO> bookDTOList = getAll();
        BookDTO sltBookDTO=bookDTOList.stream().filter(x->x.getId().equals(bookDTO.getId())).toList().get(0);
        sltBookDTO.setName(bookDTO.getName());
        sltBookDTO.setQuantity(bookDTO.getQuantity());
        sltBookDTO.setAuthorIds(bookDTO.getAuthorIds());
        List<Book> bookList = bookDTOList.stream().map(x -> bookMapper.toEntity(x)).toList();
        fileUtil.writeFile(bookFilePath, "", false);
        for (Book book : bookList) {
            StringBuilder context = new StringBuilder(book.getId() + "," + book.getName() + "," + book.getQuantity());
            for (Integer authorId : book.getAuthorIds()) {
                context.append("," + authorId);
            }
            context.append(book.getSell());
            fileUtil.writeFile(bookFilePath,context.toString()+"\n",true);
        }
    }

    @Override
    public void deleteById(String id) throws IOException {
        List<BookDTO> bookDTOList = getAll();
        for (BookDTO dto:bookDTOList){
            if(dto.getId().equals(id)){
                bookDTOList.remove(dto);
                break;
            }
        }
        List<Book> bookList = bookDTOList.stream().map(x -> bookMapper.toEntity(x)).toList();
        fileUtil.writeFile(bookFilePath, "", false);
        for (Book book : bookList) {
            StringBuilder context = new StringBuilder(book.getId() + "," + book.getName() + "," + book.getQuantity());
            for (Integer authorId : book.getAuthorIds()) {
                context.append("," + authorId);
            }
            context.append(book.getSell());
            fileUtil.writeFile(bookFilePath,context.toString()+"\n",true);
        }
    }

    @Override
    public BookDTO findById(String id) throws IOException {
//        BookDTO bookDTO = new BookDTO();
        List<BookDTO> bookDTOS = getAll();
        for(BookDTO it: bookDTOS){
            if(it.getId().strip().equalsIgnoreCase(id))
                return it;
        }
        return null;
//        return getAll().stream().filter(x->x.getId().equals(id)).toList().get(0);
    }

    @Override
    public List<BookDTO> getAllByAuthor(AuthorDTO author) throws IOException {
        List<BookDTO> bookDTOList= new ArrayList<>();
        for(BookDTO dto:getAll()){
            for (int authorId:dto.getAuthorIds()){
                if(authorId==Integer.parseInt(author.getId())){
                    bookDTOList.add(dto);
                    break;
                }
            }
        }
        return bookDTOList;
    }

    @Override
    public void sell(int bookId,int quantity) throws IOException {
        List<BookDTO> bookDTOList = getAll();
        BookDTO sltBookDTO=bookDTOList.stream().filter(x->x.getId().equals(bookId)).toList().get(0);
        sltBookDTO.setQuantity(sltBookDTO.getQuantity()-quantity);
        sltBookDTO.setSell(sltBookDTO.getSell()+quantity);
        List<Book> bookList = bookDTOList.stream().map(x -> bookMapper.toEntity(x)).toList();
        fileUtil.writeFile(bookFilePath, "", false);
        for (Book book : bookList) {
            StringBuilder context = new StringBuilder(book.getId() + "," + book.getName() + "," + book.getQuantity());
            for (Integer authorId : book.getAuthorIds()) {
                context.append("," + authorId);
            }
            fileUtil.writeFile(bookFilePath,context.toString()+"\n",true);
        }
    }
}
