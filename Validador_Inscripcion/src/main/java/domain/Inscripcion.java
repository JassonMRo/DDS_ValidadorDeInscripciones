package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    @Getter
    @Setter
    private Alumno alumno;
    @Getter
    private List<Materia> materiasInscriptas;

    public Inscripcion(Alumno alumno){
        this.alumno = alumno;
        this.materiasInscriptas = new ArrayList<>();
    }

    public boolean aprobada(){
        boolean aceptada = materiasInscriptas.stream().allMatch(materia -> this.alumno.puedeCursar(materia));
        if(aceptada){
            materiasInscriptas.forEach(materia -> this.alumno.agregarMateriasACursar(materia));
        }
        return aceptada;
    }
    public void agregarMaterias(Materia ... materias){
        Collections.addAll(this.materiasInscriptas, materias);
    }
}
