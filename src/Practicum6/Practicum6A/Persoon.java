package Practicum6.Practicum6A;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> games;

    public Persoon(String naam, double budget) {
        this.naam = naam;
        this.budget = budget;
        games = new ArrayList<Game>();
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {

        if (!games.contains(g) && budget >= g.huidigeWaarde()) {
            games.add(g);
            budget = budget - g.huidigeWaarde();
        } else {
            return false;
        }
        return true;
    }

    public boolean verkoop(Game g, Persoon koper) {
        if (games.contains(g) && !koper.games.contains(g) && koper.budget >= g.huidigeWaarde()) {
            games.remove(g);
            koper.games.add(g);
            budget = budget + g.huidigeWaarde();
            koper.budget = koper.budget - g.huidigeWaarde();
        } else {
            return false;
        }
        return true;
    }

    public String toString() {
        String s = naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:";
        for (Game game : games) {
            s += "\n" + game;
        }
        return s;
    }

}
