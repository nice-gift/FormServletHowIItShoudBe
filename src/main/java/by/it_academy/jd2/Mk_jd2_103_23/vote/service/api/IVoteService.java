package by.it_academy.jd2.Mk_jd2_103_23.vote.service.api;

import by.it_academy.jd2.Mk_jd2_103_23.vote.core.dto.Artist;
import by.it_academy.jd2.Mk_jd2_103_23.vote.core.dto.Genre;
import by.it_academy.jd2.Mk_jd2_103_23.vote.core.dto.PairData;
import by.it_academy.jd2.Mk_jd2_103_23.vote.core.dto.Vote;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


/**
 * Сохранение голоса
 */

public interface IVoteService {
    void save(Vote vote);

    Map<Artist, Integer> getArtistStatistics();

    Map<Genre, Integer> getGenreStatistics();

    List<PairData<LocalDateTime, String>> getAbouts();
}
