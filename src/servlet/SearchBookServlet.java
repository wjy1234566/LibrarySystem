package com.library.servlet;

import com.library.entity.BookEntity;
import com.library.repository.SearchBookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/search")
public class SearchBookServlet extends HttpServlet {
    String search = null;
    String searchType = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.search = req.getParameter("search");
        this.searchType = req.getParameter("searchType");
        // 对获取的type的值进行解析后赋值(根据查询类型来用于sql查询)
        switch (Integer.parseInt(searchType)) {
            case 1:
                searchType = "book_name";
                break;
            case 2:
                searchType = "book_id";
                break;
            case 3:
                searchType = "author";
                break;
            case 4:
                searchType = "publisher";
                break;
            case 5:
                searchType = "book_class";
                break;
        }

        SearchBookRepository searchBookRepository = new SearchBookRepository();
        List<BookEntity> list = searchBookRepository.searchBook(search,searchType);

        if (! list.isEmpty()){
            req.setAttribute("list",list);
        }
        else {
            req.setAttribute("message", "未找到此书<br>");
        }
        req.getRequestDispatcher("search_book.jsp").forward(req,resp);
    }
}
