package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String apellido;
    @Getter
    @Setter
    private Integer legajo;
    @Getter
    private List<Materia> materiasAprobadas;
    @Getter
    private List<Materia> materiasACursar;

    public Alumno(String nombre, String apellido, Integer legajo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
        this.materiasACursar = new ArrayList<>();
    }

    public boolean puedeCursar(Materia materia){
        return materia.getCorrelativas().stream().allMatch(materiaCorrelativa -> materiaAprobada(materiaCorrelativa));
    }
    public boolean materiaAprobada(Materia materia){
        return materiasAprobadas.contains(materia);
    }

    public void agregarMateriasAprobadas(Materia ... materias){
        Collections.addAll(materiasAprobadas, materias);
    }

    public void agregarMateriasACursar(Materia ... materias){
        Collections.addAll(materiasACursar, materias);
    }
}
