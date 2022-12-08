package com.jesus.medicaltracking.model;

        import com.jesus.medicaltracking.MainActivity;

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
        id = MainActivity.FechasId.incrementAndGet();
        this.fecha = fecha;
        this.medicamento = medicamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
