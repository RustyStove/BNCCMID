package employeedb;
import java.util.*;
import java.io.*;
import java.lang.reflect.Method;

public class employee {
	String kode, nama, kelamin, jabatan;
	int gaji;
	
	public employee(String kode, String nama, String kelamin, String jabatan, int gaji) {
		super();
		this.kode = kode;
		this.nama = nama;
		this.kelamin = kelamin;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
}
