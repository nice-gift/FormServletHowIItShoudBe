package by.it_academy.jd2.Mk_jd2_103_23.vote.service;

import by.it_academy.jd2.Mk_jd2_103_23.vote.core.dto.Vote;
import by.it_academy.jd2.Mk_jd2_103_23.vote.core.exceptions.ValidationException;
import by.it_academy.jd2.Mk_jd2_103_23.vote.dao.VoteDao;
import by.it_academy.jd2.Mk_jd2_103_23.vote.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_jd2_103_23.vote.service.api.IVoteService;

public class VoteService implements IVoteService {
    private IVoteDao voteDao=new VoteDao();

    @Override
    public void save(Vote vote) {
        if (vote == null) {
            throw new IllegalArgumentException("Нет информации о голосе");
        }
        if (vote.getGenres() != null) {
            int size = vote.getGenres().size();
            if (size < 3 || size > 5) {
                throw new ValidationException("Выбрано неправильное количество жанров");
            }
        } else {
            throw new IllegalArgumentException("Нет информации о жанрах");
        }

        voteDao.save(vote);
    }
}
