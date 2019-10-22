package com.emeryc.repos.http;

import com.emeryc.repos.transfer.Repos;
import com.emeryc.repos.transfer.Utilisateur;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.mock.BehaviorDelegate;

class Mock implements Service {

    private BehaviorDelegate<Service> delegate;
    public Mock(BehaviorDelegate<Service> delegate)
    {
        this.delegate = delegate;
    }


    @Override
    public Call<String> listReposString(String utilisateur) {
        return null;
    }

    @Override
    public Call<Utilisateur> utilisateur(String utilisateur) {

        Utilisateur u = new Utilisateur();
        u.id = 1L;
        u.login = "Emeryc P";
        u.followers = 38L;

        return this.delegate.returningResponse(u).utilisateur(utilisateur);
    }

    @Override
    public Call<List<Repos>> listRepos(String utilisateur) {

        List<Repos> r = new ArrayList<>();

        r.add(new Repos(1L, "Bon examen"));
        r.add(new Repos(2L, "Tu vas y arrivé!"));
        r.add(new Repos(3L, "Android c'est cool"));
        r.add(new Repos(4L, "Lâche pas mon gars, t'es capable ! :)"));


        return this.delegate.returningResponse(r).listRepos(utilisateur);
    }
}
