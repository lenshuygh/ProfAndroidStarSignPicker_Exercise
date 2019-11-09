package com.lens.profandroidbook.mystarsignpicker;

import androidx.annotation.Nullable;

public class Starsign {
    private String name;

    public Starsign(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Starsign -> " + name;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof Starsign){
            return ((Starsign) obj).getName().equals(name);
        }else{
            return false;
        }
    }
}
