package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Materia {
    @Setter
    @Getter
    private String codMateria;
    @Setter
    @Getter
    private String nombre;
    @Setter
    @Getter
    private String turno;
    @Getter
    private List<Materia> correlativas;

    public Materia(String codMateria, String nombre, String turno){
        this.codMateria = codMateria;
        this.nombre = nombre;
        this.turno = turno;
        this.correlativas = new ArrayList<>();
    }

    public void agregarMateriasCorrelativas(Materia ... materias){
        Collections.addAll(this.correlativas, materias);
    }
}
