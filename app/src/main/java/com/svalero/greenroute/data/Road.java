package com.svalero.greenroute.data;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Road implements Serializable {

    private long id;
    private String name;
    private float length;
    private boolean toll;
    private String image;
    private String buildDate;
}
