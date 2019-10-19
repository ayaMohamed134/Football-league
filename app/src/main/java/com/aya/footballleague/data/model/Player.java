package com.aya.footballleague.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {
    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("position")
    private String position;

    @Expose
    @SerializedName("nationality")
    private String nationality;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }

        Player player = (Player) o;
        if (!id.equals(player.id)) {
            return false;
        }
        if (!name.equals(player.name)) {
            return false;
        }
        if (!position.equals(player.position)) {
            return false;
        }
        return nationality.equals(player.nationality);
    }
}
