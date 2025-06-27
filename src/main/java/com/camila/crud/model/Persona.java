package com.camila.crud.model;

import jakarta.persistence.*;

@Entity
@Table (name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Nombre", nullable = false)
    private String name;
    @Column (name = "Edad")
    private int age;
    @Column (name = "Genero")
    private char genre;
    @Column (name = "Celular")
    private String cell;



    public Persona (){

    }

    public Persona ( String name, int age, char genre, String cell ){
      ;
        this.name = name;
        this.age=age;
        this.genre= genre;
        this.cell=cell;
    }

    public int getId(){

        return id;
    }

    public String getName(){

        return name;
    }
    public void setName(String name){

        this.name= name;
    }
    public int getAge (){

        return age;
    }
    public void setAge (int age){

        this.age=age;
    }

    public char getGenre() {

        return genre;
    }

    public void setGenre(char genre) {

        this.genre = genre;
    }
    public String getCell (){

        return cell;
    }
    public void setCell(String cell){
        this.cell= cell;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("----Persona ").append(id).append("----").append('\n');
        sb.append("id:").append(id).append('\n');
        sb.append(" Nombre:").append(name).append('\n');
        sb.append(" Edad: ").append(age).append('\n');
        sb.append(" Genero: ").append(genre).append('\n');
        sb.append(" Celular: ").append(cell).append('\n');
        sb.append("--------------------------");
        return sb.toString();
    }
}
