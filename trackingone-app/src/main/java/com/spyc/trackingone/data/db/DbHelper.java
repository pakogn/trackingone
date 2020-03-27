package com.spyc.trackingone.data.db;


import com.spyc.trackingone.data.db.model.Option;
import com.spyc.trackingone.data.db.model.Question;
import com.spyc.trackingone.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Jorge Namitle on 24/03/2018.
 */

public interface DbHelper {

    Observable<Long> insertUser(final User user);

    Observable<List<User>> getAllUsers();

    Observable<List<Question>> getAllQuestions();

    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> isOptionEmpty();

    Observable<Boolean> saveQuestion(Question question);

    Observable<Boolean> saveOption(Option option);

    Observable<Boolean> saveQuestionList(List<Question> questionList);

    Observable<Boolean> saveOptionList(List<Option> optionList);

}
