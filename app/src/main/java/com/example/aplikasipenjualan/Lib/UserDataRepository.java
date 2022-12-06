package com.example.aplikasipenjualan.Lib;

import android.content.Context;
import android.service.autofill.UserData;

import com.example.aplikasipenjualan.ObjectModel.User;
import com.example.aplikasipenjualan.ObjectModel.UserDao;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UserDataRepository {

    AppDatabase database;
    public UserDataRepository(Context context) {
        database = AppDatabase.getInstance(context);
    }

    public User getByEmail(String email) throws ExecutionException, InterruptedException {

        Callable<User> callable = new Callable<User>() {
            @Override
            public User call() throws Exception {

                return database.userDao().findByEmail(email);
            }
        };

        Future<User> future = Executors.newSingleThreadExecutor().submit(callable);

        return future.get();
    }
}
