package idat.edu.pe.appjeanherrera.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {

    private String DNI;
    private String password;
    private String nombre;
    private String apellido;

    public Cliente(String DNI, String password, String nombre, String apellido) {
        this.DNI = DNI;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    protected Cliente(Parcel in) {
        DNI = in.readString();
        password = in.readString();
        nombre = in.readString();
        apellido = in.readString();
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(DNI);
        parcel.writeString(password);
        parcel.writeString(nombre);
        parcel.writeString(apellido);
    }
}
