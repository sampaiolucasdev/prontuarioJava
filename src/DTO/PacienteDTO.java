/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author lucas
 */
public class PacienteDTO {
    private int id_Paciente;
    private String nomePaciente;
    private String dataNascimento;
    private String telefonePaciente;
    private String prontuarioPaciente;

    public String getProntuarioPaciente() {
        return prontuarioPaciente;
    }

    public void setProntuarioPaciente(String prontuarioPaciente) {
        this.prontuarioPaciente = prontuarioPaciente;
    }
    

    public int getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(int id_Paciente) {
        this.id_Paciente = id_Paciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }
    
    
}
