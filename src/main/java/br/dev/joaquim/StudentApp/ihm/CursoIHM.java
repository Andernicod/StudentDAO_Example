package br.dev.joaquim.StudentApp.ihm;

import java.util.Scanner;
import br.dev.joaquim.StudentApp.dao.H2CursoDAO;
import br.dev.joaquim.StudentApp.entities.Curso;

public class CursoIHM {

    private H2CursoDAO cursoDAO;

    public CursoIHM(H2CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("=== Course Menu ===");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addCurso(scanner);
                    break;
                case 2:
                    viewAllCursos();
                    break;
                case 3:
                    updateCurso(scanner);
                    break;
                case 4:
                    deleteCurso(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    private void addCurso(Scanner scanner) {
        System.out.print("Enter course code: ");
        int cod = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course name: ");
        String nome = scanner.nextLine();
        System.out.print("Enter course professor name: ");
        String nomeProfessor = scanner.nextLine();
        System.out.print("Enter course period: ");
        String periodo = scanner.nextLine();

        Curso curso = new Curso(cod, nome, nomeProfessor, periodo);
        cursoDAO.create(curso);
        System.out.println("Course added successfully!");
    }

    private void viewAllCursos() {
        System.out.println("=== List of Courses ===");
        for (Curso curso : cursoDAO.findAll()) {
            System.out.println(curso.toString());
        }
    }

    private void updateCurso(Scanner scanner) {
        System.out.print("Enter the course code to be updated: ");
        int cod = scanner.nextInt();
        scanner.nextLine();

        Curso curso = cursoDAO.findByCodigo(cod);
        if (curso == null) {
            System.out.println("Course not found.");
            return;
        }
        cursoDAO.update(curso);
        System.out.println("Course updated successfully.");
    }

    private void deleteCurso(Scanner scanner) {
        System.out.print("Enter the course code to be deleted: ");
        int cod = scanner.nextInt();
        cursoDAO.delete(cod);
        System.out.println("Course deleted!");
    }
}