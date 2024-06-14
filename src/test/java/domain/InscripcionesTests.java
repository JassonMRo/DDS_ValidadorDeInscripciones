package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InscripcionesTests {
    private Materia materia1;
    private Materia materia2;
    private Materia materia3;
    private Materia materia4;
    private Alumno alumno1;

    private Alumno  alumno2;
    private Inscripcion inscripcion1;
    private Inscripcion inscripcion2;

    private Inscripcion inscripcion3;

    @BeforeEach
    public void init(){
        this.alumno1 = new Alumno("Jasson", "Rodriguez", 1497741);
        this.alumno1.agregarMateriasAprobadas(materia2);

        this.alumno2 = new Alumno("Yusarely", "Ramos", 2078991);

        this.materia1 = new Materia("K045", "Disenio de Sistemas", "Noche");
        this.materia1.agregarMateriasCorrelativas(materia2);

        this.materia2 = new Materia("K044", "Analisis de Sistema", "Tarde");

        this.materia3 = new Materia("K010", "Fisica I", "Tarde");

        this.materia4 = new Materia("K020", "Analisis Matematico I", "Maniana");

        this.inscripcion1 = new Inscripcion(alumno1);
        this.inscripcion1.agregarMaterias(materia1);

        this.inscripcion2 = new Inscripcion(alumno2);
        this.inscripcion2.agregarMaterias(materia1);

        this.inscripcion3 = new Inscripcion(alumno2);
        this.inscripcion3.agregarMaterias(materia3);
        this.inscripcion3.agregarMaterias(materia4);
    }

    @Test
    @DisplayName("Jasson va a poder cursas Disenio de Sistemas")
    public void inscripcionAprobada() {
        inscripcion1.aprobada();

        Assertions.assertEquals(inscripcion1.getMateriasInscriptas(), alumno1.getMateriasACursar());
    }

    @Test
    @DisplayName("Yusarely no se va poder inscribir en Diseñio de Sistemas")
    public void inscripcionRechazada(){

        Assertions.assertFalse(inscripcion2.aprobada());
    }

    @Test
    @DisplayName("Yusarely va a poder cursar Fisica I y Analisis porque estas materias no tienen correlativas")
    public void inscripcionAMateriasDePrimerAnio(){
        inscripcion3.aprobada();

        Assertions.assertEquals(alumno2.getMateriasACursar(), inscripcion3.getMateriasInscriptas());
    }
}
