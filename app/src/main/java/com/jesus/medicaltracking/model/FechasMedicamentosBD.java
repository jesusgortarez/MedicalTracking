package com.jesus.medicaltracking.model;

        import io.realm.RealmList;
        import io.realm.RealmObject;
        import io.realm.annotations.PrimaryKey;

public class FechasMedicamentosBD extends RealmObject {
    @PrimaryKey
    private int id;

    private  String fecha;
    private String medicamento;

    public  FechasMedicamentosBD(){}

    public FechasMedicamentosBD(String fecha, String medicamento){
        this.fecha = fecha;
        this.medicamento = medicamento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public String toString() {
        return getMedicamento();
    }
}
