package by.it_academy.jd2.Mk_jd2_103_23.vote.service.factory;

import by.it_academy.jd2.Mk_jd2_103_23.vote.dao.factory.VoteDaoFactory;
import by.it_academy.jd2.Mk_jd2_103_23.vote.service.VoteService;

public class VoteServiceFactory {
    private volatile static VoteService uniqueInstance;

    private VoteServiceFactory() {
    }

    public static VoteService getInstance() {
        if (uniqueInstance == null) {
            synchronized (VoteServiceFactory.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new VoteService(VoteDaoFactory.getInstance());
                }
            }
        }
        return uniqueInstance;
    }
}
