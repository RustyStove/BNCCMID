package employeedb;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
//import java.util.*;
//import java.io.*;
//import java.lang.reflect.Method;

public class dataprogram {
	
	static void clear() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		
		ArrayList<employee> data = new ArrayList<employee>();
		
		
		Scanner scanner = new Scanner(System.in);
		
		int choice = 0;
		int nomanager = 0;
		int nosupervisor = 0;
		int noadmin = 0;
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "0123456789";
		Random random = new Random();
		
		while(choice != 5) {
			System.out.print("--------Main Menu--------\n");
			System.out.print("1. Insert Dara\n");
			System.out.print("2. View Data\n");
			System.out.print("3. Update Data\n");
			System.out.print("4. Delete Data\n");
			System.out.print("5. Exit\n");
			System.out.print("Please Select An Option: ");
			choice = scanner.nextInt();
			
			switch(choice) {
			
				case 1:
					clear();
					String kode = "", nama ="", kelamin = "", jabatan = "";
					int gaji = 0;
					StringBuilder sb = new StringBuilder();
					
					
					boolean truth = false;
					
					while(truth !=true) {
					
						for(int i = 0; i < 2; i++) {
							int index = random.nextInt(alphabet.length());
							      
							char randomChar = alphabet.charAt(index);
	      
							sb.append(randomChar);
					    }
								
						sb.append('-');
							
						for(int i = 0; i < 4; i++) {
								
							int index = random.nextInt(numbers.length());
								      
							char randomChar = numbers.charAt(index);
	      
							sb.append(randomChar);
							
							}
						
						kode = sb.toString();
						
						int truthcount = 0;
						
						for(int i = 0; i<data.size(); i++) {
							if(kode.equals(data.get(i).kode)){
								truthcount += 1;
							}else if(truthcount > 1) {
								truth = false;
								break;
							}
						}
						
						if(truthcount <= 1) {
							truth = true;
						}
					}
					
					scanner.nextLine();
					truth = false;
					
					while (truth != true){
						
						System.out.print("Input nama karyawan [>=3]: ");
						nama = scanner.nextLine();
						
						if(nama.length() >= 3) {
							break;
						}else {
							System.out.print("Nama harus lebih dari atau sama dengan 3 huruf\n");
						}
					}
					
					while (truth != true){
						System.out.print("Input jenis kelamin [Laki-laki | Perempuan]: ");
						kelamin = scanner.nextLine();
						
						if(kelamin.equals("Laki-laki") || kelamin.equals("Perempuan")) {
							break;
						}else {
							System.out.print("Tolong cek kembali kelamin yang dimasukkan (Case Sensitif)\n");
						}
					}
					
					while (truth != true){
						System.out.print("Input jabatan [Manager | Supervisor | Admin]: ");
						jabatan = scanner.nextLine();
						
						if(jabatan.equals("Manager")){
							gaji = 8000000;
							nomanager += 1;
							break;
						}if(jabatan.equals("Supervisor")){
							gaji = 6000000;
							nosupervisor += 1;
							break;
						}if(jabatan.equals("Admin")){
							noadmin += 1;
							gaji = 4000000;
							break;	
						}else{
							System.out.print("Tolong cek kembali jabatan yang dimasukkan (Case Sensitif)\n");
						}
					}
					
					data.add(new employee(kode, nama, kelamin, jabatan, gaji));
					System.out.print("Berhasil menambahkan karyawan dengan id " + kode + ".");
					
					int tempgaji = 0, jabatancount = 0, m = 0;
					String tempname = "", tempkode = "", tempkelamin = "", tempjabatan = "";
					
					if(nomanager % 3 == 1 && nomanager > 1){
						System.out.print("\nBonus sebesar 10% telah diberikan kepada karyawan dengan id ");
						
						while(jabatancount < nomanager - 1) {
							if(data.get(m).jabatan.equals("Manager")) {
								tempname = data.get(m).nama;
								tempkode = data.get(m).kode;
								tempkelamin = data.get(m).kelamin;
								tempjabatan = data.get(m).jabatan;
								tempgaji = data.get(m).gaji + (int)(data.get(m).gaji * 10/100);
								
								if (jabatancount == 0) {
									System.out.print(tempkode);
								}else {
									System.out.print(", " + tempkode);
								}
								
								data.set(m, new employee(tempkode, tempname, tempkelamin, tempjabatan, tempgaji));
								
								jabatancount += 1;
								m++;
							}else {
								m++;
							}
								
						}
					}else if(nosupervisor % 3 == 1 && nosupervisor > 1) {
						System.out.print("\nBonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
						
						while(jabatancount < nosupervisor - 1) {
							if(data.get(m).jabatan.equals("Supervisor")) {
								tempname = data.get(m).nama;
								tempkode = data.get(m).kode;
								tempkelamin = data.get(m).kelamin;
								tempjabatan = data.get(m).jabatan;
								tempgaji = data.get(m).gaji + (int)(data.get(m).gaji * 7.5/100);
								
								if (jabatancount == 0) {
									System.out.print(tempkode);
								}else {
									System.out.print(", " + tempkode);
								}
								
								data.set(m, new employee(tempkode, tempname, tempkelamin, tempjabatan, tempgaji));
								
								jabatancount += 1;
								m++;
							}else {
								m++;
							}
								
						}
						
					}else if(noadmin % 3 == 1 && noadmin > 1) {
						System.out.print("\nBonus sebesar 5% telah diberikan kepada karyawan dengan id ");
						
						while(jabatancount < noadmin - 1) {
							if(data.get(m).jabatan.equals("Admin")) {
								tempname = data.get(m).nama;
								tempkode = data.get(m).kode;
								tempkelamin = data.get(m).kelamin;
								tempjabatan = data.get(m).jabatan;
								tempgaji = data.get(m).gaji + (int)(data.get(m).gaji * 5/100);
								
								if (jabatancount == 0) {
									System.out.print(tempkode);
								}else {
									System.out.print(", " + tempkode);
								}
								
								data.set(m, new employee(tempkode, tempname, tempkelamin, tempjabatan, tempgaji));
								
								jabatancount += 1;
								m++;
							}else {
								m++;
							}
								
						}
					}
					
					Collections.sort(data, new Comparator<employee>() {
						
						public int compare(employee s1, employee s2) {
							return s1.nama.compareToIgnoreCase(s2.nama);
						}
					});
					
					
					System.out.print("\n[Enter to return]");
					scanner.nextLine();
					clear();
					break;
					
				
				case 2:
					if(data.size()>0) {
						
						clear();
						scanner.nextLine();
						System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
						System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|\n"
								,"No","Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
						System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					
						for(int i = 0; i< data.size(); i++) {
							System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13s|\n"
									,i + 1 ,data.get(i).kode, data.get(i).nama, data.get(i).kelamin, data.get(i).jabatan, data.get(i).gaji);
						}
						
						System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
						System.out.print("[Enter to return]");
						scanner.nextLine();
						clear();
						break;
						
					}else {
						
						scanner.nextLine();
						System.out.println("No Data Found");
						System.out.print("[Enter to return]");
						scanner.nextLine();
						clear();
						break;
					}
					
				case 3:
					if(data.size()>0) {
						
						clear();
						
						int option = 0;
						
						System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
						System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|\n"
								,"No","Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
						System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					
						for(int i = 0; i< data.size(); i++) {
							System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13s|\n"
									,i + 1 ,data.get(i).kode, data.get(i).nama, data.get(i).kelamin, data.get(i).jabatan, data.get(i).gaji);
						}
						
						System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
						
						int checktruth = 0;
						//code for changing stuff
						
						while (checktruth == 0) {
							scanner.nextLine();
							System.out.print("\nInput nomor karyawan yang ingin diganti: ");
							option = scanner.nextInt() - 1;
							
							if(checktruth < 0 || checktruth > data.size() - 1) {
								System.out.print("No data found");
							}else {
								checktruth = 1;
								
								String lastkode= data.get(option).kode
										,lastname= data.get(option).nama
										,lastgender= data.get(option).kelamin,
										lastjabatan= data.get(option).jabatan;
								int lastgaji= data.get(option).gaji; 
								
								String newname = "", newgender = "", newjabatan = "";
								int newgaji = 0;
								
								scanner.nextLine();
								
								System.out.print("Masukkan [0] untuk tidak ganti data\n");
								truth = false;
								
								while (truth != true){
									
									System.out.print("Input nama karyawan [>=3]: ");
									newname = scanner.nextLine();
									
									if(newname.length() >= 3) {
										break;
									}else if(newname.equals("0")) {
										newname = lastname;
										break;
									}else{
										System.out.print("Nama harus lebih dari atau sama dengan 3 huruf\n");
									}
								}
								
								while (truth != true){
									System.out.print("Input jenis kelamin [Laki-laki | Perempuan]: ");
									newgender = scanner.nextLine();
									
									if(newgender.equals("Laki-laki") || newgender.equals("Perempuan")) {
										break;
									}else if(newgender.equals("0")){
										newgender = lastgender;
										break;
										
									}else {
										System.out.print("Tolong cek kembali kelamin yang dimasukkan (Case Sensitif)\n");
									}
								}
								
								while (truth != true){
									System.out.print("Input jabatan [Manager | Supervisor | Admin]: ");
									newjabatan = scanner.nextLine();
									
									if(newjabatan.equals("Manager")){
										newgaji = 8000000;
										nomanager += 1;
										break;
									}else if(newjabatan.equals("Supervisor")){
										newgaji = 6000000;
										nosupervisor += 1;
										break;
									}else if(newjabatan.equals("Admin")){
										noadmin += 1;
										newgaji = 4000000;
										break;	
									}else if (newjabatan.equals("0")) {
										newjabatan = lastjabatan;
										newgaji = lastgaji;
										break;
									}else{
										System.out.print("Tolong cek kembali jabatan yang dimasukkan (Case Sensitif)\n");
									}
								}
								
								data.set(option, new employee(lastkode, newname, newgender, newjabatan, newgaji));
								System.out.print("Berhasil menambahkan karyawan dengan id " + lastkode + ".");
								
								int tempogaji = 0, jabatancounto = 0, mo = 0;
								String temponame = "", tempokode = "", tempokelamin = "", tempojabatan = "";
								
								if(nomanager % 3 == 1 && nomanager > 1){
									System.out.print("\nBonus sebesar 10% telah diberikan kepada karyawan dengan id ");
									
									while(jabatancounto < nomanager - 1) {
										if(data.get(mo).jabatan.equals("Manager")) {
											temponame = data.get(mo).nama;
											tempokode = data.get(mo).kode;
											tempokelamin = data.get(mo).kelamin;
											tempojabatan = data.get(mo).jabatan;
											tempogaji = data.get(mo).gaji + (int)(data.get(mo).gaji * 10/100);
											
											if (jabatancounto == 0) {
												System.out.print(tempokode);
											}else {
												System.out.print(", " + tempokode);
											}
											
											data.set(mo, new employee(tempokode, temponame, tempokelamin, tempojabatan, tempogaji));
											
											jabatancounto += 1;
											mo++;
										}else {
											mo++;
										}
											
									}
								}else if(nosupervisor % 3 == 1 && nosupervisor > 1) {
									System.out.print("\nBonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
									
									while(jabatancounto < nosupervisor - 1) {
										if(data.get(mo).jabatan.equals("Supervisor")) {
											temponame = data.get(mo).nama;
											tempokode = data.get(mo).kode;
											tempokelamin = data.get(mo).kelamin;
											tempojabatan = data.get(mo).jabatan;
											tempogaji = data.get(mo).gaji + (int)(data.get(mo).gaji * 7.5/100);
											
											if (jabatancounto == 0) {
												System.out.print(tempokode);
											}else {
												System.out.print(", " + tempokode);
											}
											
											data.set(mo, new employee(tempokode, temponame, tempokelamin, tempojabatan, tempogaji));
											
											jabatancounto += 1;
											mo++;
										}else {
											mo++;
										}
											
									}
									
								}else if(noadmin % 3 == 1 && noadmin > 1) {
									System.out.print("\nBonus sebesar 5% telah diberikan kepada karyawan dengan id ");
									
									while(jabatancounto < noadmin - 1) {
										if(data.get(mo).jabatan.equals("Admin")) {
											temponame = data.get(mo).nama;
											tempokode = data.get(mo).kode;
											tempokelamin = data.get(mo).kelamin;
											tempojabatan = data.get(mo).jabatan;
											tempogaji = data.get(mo).gaji + (int)(data.get(mo).gaji * 5/100);
											
											if (jabatancounto == 0) {
												System.out.print(tempokode);
											}else {
												System.out.print(", " + tempokode);
											}
											
											data.set(mo, new employee(tempokode, temponame, tempokelamin, tempojabatan, tempogaji));
											
											jabatancounto += 1;
											mo++;
										}else {
											mo++;
										}	
									}
								}
							}
						}
						
						Collections.sort(data, new Comparator<employee>() {
							
							public int compare(employee s1, employee s2) {
								return s1.nama.compareToIgnoreCase(s2.nama);
							}
						});
						
						System.out.print("[Enter to return]");
						scanner.nextLine();
						clear();
						break;
						
					}else {
						
						scanner.nextLine();
						System.out.println("No Data Found");
						System.out.print("[Enter to return]");
						scanner.nextLine();
						clear();
						break;
					}
					 
				case 4:
					
					if(data.size()>0) {
						
						clear();
						
						int changeoption;
						
						System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
						System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|\n"
								,"No","Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
						System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
					
						for(int i = 0; i< data.size(); i++) {
							System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13s|\n"
									,i + 1 ,data.get(i).kode, data.get(i).nama, data.get(i).kelamin, data.get(i).jabatan, data.get(i).gaji);
						}
						
						System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
						
						int truthcheck = 0;
						
						while (truthcheck == 0) {
							scanner.nextLine();
							System.out.print("\nInput nomor urutan karyawan yang ingin dihapus: ");
							changeoption = scanner.nextInt() - 1;
							
							if(changeoption < 0 || changeoption > data.size() - 1) {
								System.out.print("No data found");
							}else {
								truthcheck = 1;
								System.out.print("Karyawan dengan kode " + data.get(changeoption).kode + " berhasil dihapus.\n");
								data.remove(changeoption);
								scanner.nextLine();
							}
						}
						
						System.out.print("[Enter to return]");
						scanner.nextLine();
						clear();
						break;
						
					}else {
						
						scanner.nextLine();
						System.out.println("No Data Found");
						System.out.print("[Enter to return]");
						scanner.nextLine();
						clear();
						break;
					}
					 
			}
		}
		System.out.println("\nProgram Exited.\n");
		scanner.close();
	}

}