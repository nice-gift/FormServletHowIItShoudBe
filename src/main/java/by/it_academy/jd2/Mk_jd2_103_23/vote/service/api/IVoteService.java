package by.it_academy.jd2.Mk_jd2_103_23.vote.service.api;

import by.it_academy.jd2.Mk_jd2_103_23.vote.core.dto.Vote;


/**
 * Сохранение голоса
 */

public interface IVoteService {
    void save(Vote vote);
}
