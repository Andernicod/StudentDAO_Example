package br.dev.joaquim.StudentApp.dao;

import br.dev.joaquim.StudentApp.entities.Curso;
import java.util.*;

public interface CursoDAO {
    public boolean create(Curso curso);

    public List<Curso> findAll();

    public Curso findByCodigo(int codigoCurso);

    public boolean update(Curso curso);

    public boolean delete(int id);
}