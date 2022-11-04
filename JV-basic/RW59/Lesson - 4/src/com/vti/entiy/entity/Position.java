package com.vti.entiy.entity;


import com.vti.entiy.entity.enumtype.PositionName;

public class Position {
    public  int positionId;
    public PositionName positionName;

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName=" + positionName +
                '}';
    }
}
