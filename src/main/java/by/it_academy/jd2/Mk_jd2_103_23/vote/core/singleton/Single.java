package by.it_academy.jd2.Mk_jd2_103_23.vote.core.singleton;

import by.it_academy.jd2.Mk_jd2_103_23.vote.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_jd2_103_23.vote.dao.factory.VoteDaoFactory;
import by.it_academy.jd2.Mk_jd2_103_23.vote.service.api.IVoteService;
import by.it_academy.jd2.Mk_jd2_103_23.vote.service.factory.VoteServiceFactory;

public enum Single {
    ;

    //    DAO(VoteDaoFactory.getInstance()),
//    SERVICE(VoteServiceFactory.getInstance());
//
//    private IVoteService voteService;
//    private IVoteDao voteDao;
//
//    Single(IVoteService voteService) {
//        this.voteService = voteService;
//    }
//
//    Single(IVoteDao voteDao) {
//        this.voteDao = voteDao;
//}
    public static IVoteDao getVoteDao() {
        return VoteDaoFactory.getInstance();
    }

    public static IVoteService getVoteService() {
        return VoteServiceFactory.getInstance();
    }


}
