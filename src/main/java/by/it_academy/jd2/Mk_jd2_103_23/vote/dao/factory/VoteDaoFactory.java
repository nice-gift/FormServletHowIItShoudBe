package by.it_academy.jd2.Mk_jd2_103_23.vote.dao.factory;

import by.it_academy.jd2.Mk_jd2_103_23.vote.dao.VoteDao;
import by.it_academy.jd2.Mk_jd2_103_23.vote.dao.api.IVoteDao;

public class VoteDaoFactory {
    private volatile static VoteDao uniqueInstance;

    private VoteDaoFactory() {
    }

    public static IVoteDao getInstance() {
        if (uniqueInstance == null) {
            synchronized (VoteDaoFactory.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new VoteDao();
                }
            }
        }
        return uniqueInstance;
    }
}
