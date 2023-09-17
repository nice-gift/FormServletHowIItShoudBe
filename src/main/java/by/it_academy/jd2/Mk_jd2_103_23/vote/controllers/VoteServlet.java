package by.it_academy.jd2.Mk_jd2_103_23.vote.controllers;

import by.it_academy.jd2.Mk_jd2_103_23.vote.core.dto.Artist;
import by.it_academy.jd2.Mk_jd2_103_23.vote.core.dto.Genre;
import by.it_academy.jd2.Mk_jd2_103_23.vote.core.dto.Vote;
import by.it_academy.jd2.Mk_jd2_103_23.vote.core.exceptions.ValidationException;
import by.it_academy.jd2.Mk_jd2_103_23.vote.service.api.IVoteService;
import by.it_academy.jd2.Mk_jd2_103_23.vote.service.VoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private static final String ARTIST_PARAM_NAME = "artist";
    private static final String GENRE_PARAM_NAME = "genre";
    private static final String ABOUT_PARAM_NAME = "about";
    private IVoteService iVoteService = new VoteService();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        String artist = req.getParameter(ARTIST_PARAM_NAME);
        String[] genres = req.getParameterValues(GENRE_PARAM_NAME);
        String about = req.getParameter(ABOUT_PARAM_NAME);

        Vote vote = new Vote();

        vote.setArtist(new Artist(artist));

        for (String genre : genres) {
            vote.addGenre(new Genre(genre));
        }

        vote.setAbout(about);

        try {
            iVoteService.save(vote);
        } catch (IllegalArgumentException e) {
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        } catch (ValidationException e) {
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }


//        Map<String, String[]> parameterMap = req.getParameterMap();
//        PrintWriter writer = resp.getWriter();
//        parameterMap.forEach((k, arr) -> {
//            writer.write("<p>name: " + k + "</p>");
//            writer.write("<br>");
//            Arrays.stream(arr)
//                    .forEach(e -> writer.write("<p>" + e + "</p>"));
//        });


    }
}
